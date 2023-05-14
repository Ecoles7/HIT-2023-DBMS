import java.util.*;

public class join {
    public void nestedLoopJoin(extmem buffer){
        //每一轮中6个块读R，1个块读S，留一个输出
        String[] res=new String[7];
        int TumpleNum=0;
        int count=0;
        //在外层先读R,总共需要读3次
        int R_times=3;
        for(int i=0;i<R_times;i++){
            int start=i*6;
            int end=Math.min((i+1)*6,16);
            String[][] dataR=new String[end-start][];

            for(int j=start;j<end;j++){
                String path="task1\\dir\\relation\\"+"R"+j+".blk";
                String[] data=buffer.data[buffer.loadBlock(path)];
                dataR[j-start]=data;
            }

            //内层读S
            for(int k=0;k<32;k++){
                String path="task1\\dir\\relation\\"+"S"+k+".blk";
                int indexS=buffer.loadBlock(path);
                String[] dataS=buffer.data[indexS];
                for(String[] R:dataR){
                    for(String itemR:R){
                        if(itemR==null){continue;}
                        String R_a=itemR.split(" ")[0];
                        for(String itemS:dataS){
                            if(itemS==null){continue;}
                            String S_c=itemS.split(" ")[0];
                            if(Objects.equals(R_a, S_c)){
                                res[TumpleNum]=itemR+" "+itemS;
                                TumpleNum++;
                                if(TumpleNum==3){
                                    String writePath="task1\\dir\\join\\nlj\\SR"+count+".blk";
                                    buffer.writeBuffer(res,writePath);
                                    res=new String[7];
                                    TumpleNum=0;
                                    System.out.println(count);
                                    count++;
                                }
                            }
                        }
                    }
                }
                buffer.freeBlock(indexS);
            }

            buffer.freeAllBlock();
        }

        if(TumpleNum!=0){
            String writePath="task1\\dir\\join\\nlj\\SR"+count+".blk";
            buffer.writeBuffer(res,writePath);
        }

    }


    public void hashJoin(extmem buffer){
        int hash_num=6;
        List<List<String>> dataR=new ArrayList<>();
        List<List<String>> dataS=new ArrayList<>();
        for(int i=0;i<hash_num;i++){
            dataR.add(new ArrayList<>());
            dataS.add(new ArrayList<>());
        }
        String[][] hashBlock=new String[hash_num][7];

        int[] countR=new int[hash_num];
        //读入R的数据到缓存区
        for(int i=0;i<16;i++){
            String path="task1\\dir\\relation\\"+"R"+i+".blk";
            int index=buffer.loadBlock(path);
            String[] data=buffer.data[index];
            for(String item:data){
                if(item==null){continue;}
                int hashIndex=   Integer.parseInt(item.split(" ")[0] ) %  hash_num;
                hashBlock[hashIndex][ countR[hashIndex]  ]=item;
                countR[hashIndex]++;
                if(countR[hashIndex]==7){
                    String path1="task1\\dir\\join\\hashj\\R"+hashIndex+dataR.get(hashIndex).size()+".blk";
                    buffer.writeBuffer(hashBlock[hashIndex],path1);
                    dataR.get(hashIndex).add(path1);
                    hashBlock[hashIndex]=new String[7];
                    countR[hashIndex]=0;
                }
            }
            buffer.freeBlock(index);
        }

        for(int i=0;i<hash_num;i++){
            if(countR[i]!=0){
                String path1="task1\\dir\\join\\hashj\\R"+i+dataR.get(i).size()+".blk";
                buffer.writeBuffer(hashBlock[i],path1);
                dataR.get(i).add(path1);
            }
        }

        buffer.freeAllBlock();

        //读入S的数据到缓存区
        int[] countS=new int[hash_num];
        for(int i=0;i<32;i++){
            String path="task1\\dir\\relation\\"+"S"+i+".blk";
            int index=buffer.loadBlock(path);
            String[] data=buffer.data[index];
            for(String item:data){
                if(item==null){continue;}
                int hashIndex=Integer.parseInt(item.split(" ")[0] ) %  hash_num;
                hashBlock[hashIndex][ countS[hashIndex]  ]=item;
                countS[hashIndex]++;
                if(countS[hashIndex]==7){
                    String path1="task1\\dir\\join\\hashj\\S"+hashIndex+dataS.get(hashIndex).size()+".blk";
                    buffer.writeBuffer(hashBlock[hashIndex],path1);
                    dataS.get(hashIndex).add(path1);
                    hashBlock[hashIndex]=new String[7];
                    countS[hashIndex]=0;
                }
            }
            buffer.freeBlock(index);
        }

        for(int i=0;i<hash_num;i++){
            if(countS[i]!=0){
                String path1="task1\\dir\\join\\hashj\\S"+i+dataS.get(i).size()+".blk";
                buffer.writeBuffer(hashBlock[i],path1);
                dataS.get(i).add(path1);
            }
        }

        buffer.freeAllBlock();

        //进行连接操作
        int count=0;
        //遍历所有哈希桶
        for(int i=0;i<hash_num;i++){
            List<String> rBufferData=new ArrayList<>();
            //保存R关系处于第i个桶的全部blk
            for(String add:dataR.get(i)){
                String[] tempData=buffer.data[buffer.loadBlock(add)];
                List<String> temp=new ArrayList<>(Arrays.asList(tempData));
                rBufferData.addAll(temp);
            }


            int TumpleNum=0;
            String[] res=new String[7];

            //将S的第i个hash桶内容逐块加入
            for(String add:dataS.get(i)){
                if(i==1){System.out.println(dataS.get(i));}
                int index=buffer.loadBlock(add);
                String[] tempData=buffer.data[index];
                for(String rData:rBufferData){
                    for(String sData:tempData){
                        if(rData==null||sData==null){continue;}
                        String R_a=rData.split(" ")[0];
                        String S_c=sData.split(" ")[0];
                        if(Objects.equals(R_a, S_c)){
                            res[TumpleNum]=rData+" "+sData;
                            TumpleNum++;
                            if(TumpleNum==3){
                                String writePath="task1\\dir\\join\\hashj\\SR"+count+".blk";
                                buffer.writeBuffer(res,writePath);
                                res=new String[7];
                                TumpleNum=0;
                                count++;
                            }

                        }
                    }
                }
                buffer.freeBlock(index);
            }
            if(TumpleNum!=0){
                String writePath="task1\\dir\\join\\hashj\\SR"+count+".blk";
                buffer.writeBuffer(res,writePath);
                count++;
            }
            buffer.freeAllBlock();
        }

    }

    public void sortMergeJoin(extmem buffer) {
        sort(buffer);
        //执行连接操作
        int rindex = 0;
        int sindex = 0;
        int count = 0;
        int resCount = 0;
        String[] res = new String[7];
        String[] rData = buffer.data[buffer.loadBlock("task1\\dir\\join\\sortmerge\\sort\\Rfinal0.blk")];
        String[] sData = buffer.data[buffer.loadBlock("task1\\dir\\join\\sortmerge\\sort\\Sfinal0.blk")];
        while (rindex < 112 && sindex < 224) {
            String R_a = rData[rindex%7].split(" ")[0];
            String S_c = sData[sindex%7].split(" ")[0];
            if (Objects.equals(R_a, S_c)) {
                res[count] = rData[rindex % 7] + " " + sData[sindex % 7];
                count++;
                if (count == 3) {
                    String writePath = "task1\\dir\\join\\sortmerge\\res\\SR" + resCount + ".blk";
                    buffer.writeBuffer(res, writePath);
                    res = new String[7];
                    count = 0;
                    resCount++;
                }
                int tempIndex = sindex + 1;
                while (tempIndex < 224) {
                    if (tempIndex % 7 == 0) {
                        buffer.freeBlock(1);
                        int curnum=tempIndex/7;
                        String index = "task1\\dir\\join\\sortmerge\\sort\\Sfinal" + curnum+ ".blk";
                        sData = buffer.data[buffer.loadBlock(index)];
                    }
                    if (Objects.equals(R_a, sData[tempIndex % 7].split(" ")[0])) {
                        res[count] = rData[rindex % 7] + " " + sData[tempIndex % 7];
                        count++;
                        tempIndex++;
                        if (count == 3) {
                            String writePath = "task1\\dir\\join\\sortmerge\\res\\SR" + resCount + ".blk";
                            buffer.writeBuffer(res, writePath);
                            res = new String[7];
                            count = 0;
                            resCount++;
                        }
                    } else {
                        break;
                    }
                }

                if (tempIndex / 7 > sindex / 7) {
                    buffer.freeBlock(1);
                    String index = "task1\\dir\\join\\sortmerge\\sort\\Sfinal" + sindex / 7 + ".blk";
                    sData = buffer.data[buffer.loadBlock(index)];
                }
                tempIndex = rindex + 1;
                while (tempIndex < 112) {
                    if (tempIndex % 7 == 0) {
                        buffer.freeBlock(0);
                        String index = "task1\\dir\\join\\sortmerge\\sort\\Rfinal" + tempIndex / 7 + ".blk";
                        rData = buffer.data[buffer.loadBlock(index)];
                    }
                    if (Objects.equals(S_c, rData[tempIndex % 7].split(" ")[0])) {
                        res[count] = rData[tempIndex % 7] + " " + sData[sindex % 7];
                        count++;
                        tempIndex++;
                        if (count == 3) {
                            String writePath = "task1\\dir\\join\\sortmerge\\res\\SR" + resCount + ".blk";
                            buffer.writeBuffer(res, writePath);
                            res = new String[7];
                            count = 0;
                            resCount++;
                        }
                    } else {
                        break;
                    }
                }

                if (tempIndex / 7 > rindex / 7) {
                    buffer.freeBlock(0);
                    String index = "task1\\dir\\join\\sortmerge\\sort\\Rfinal" + rindex / 7 + ".blk";
                    rData = buffer.data[buffer.loadBlock(index)];
                }

                rindex++;
                sindex++;
                if (rindex % 7 == 0 && rindex < 112) {
                    buffer.freeBlock(0);
                    String index = "task1\\dir\\join\\sortmerge\\sort\\Rfinal" + rindex / 7 + ".blk";
                    rData = buffer.data[buffer.loadBlock(index)];
                }

                if (sindex % 7 == 0 && sindex < 224) {
                    buffer.freeBlock(1);
                    String index = "task1\\dir\\join\\sortmerge\\sort\\Sfinal" + sindex / 7 + ".blk";
                    sData = buffer.data[buffer.loadBlock(index)];
                }
            } else if (Integer.parseInt(R_a) > Integer.parseInt(S_c) ) {
                sindex++;
                if (sindex % 7 == 0 && sindex < 224) {
                    buffer.freeBlock(1);
                    String index = "task1\\dir\\join\\sortmerge\\sort\\Sfinal" + sindex / 7 + ".blk";
                    sData = buffer.data[buffer.loadBlock(index)];
                }

            } else {
                rindex++;
                if (rindex % 7 == 0 && rindex < 112) {
                    buffer.freeBlock(0);
                    String index = "task1\\dir\\join\\sortmerge\\sort\\Rfinal" + rindex / 7 + ".blk";
                    rData = buffer.data[buffer.loadBlock(index)];
                }
            }
        }
        if (count != 0) {
            String writePath = "task1\\dir\\join\\sortmerge\\res\\SR" + resCount + ".blk";
            buffer.writeBuffer(res, writePath);
        }
    }

    //先把R和S排好序
    public void sort(extmem buffer){
        //排序R
        // 每次用7个块读 1个块输出 由于R有16个块 所以需要3次
        for(int i=0;i<=3;i++){
            int start=i*7;
            int end=Math.min((i+1)*7,16);
            List<String> dataR=new ArrayList<>();
            for(int j=start;j<end;j++){
                String path="task1\\dir\\relation\\"+"R"+j+".blk";
                int index=buffer.loadBlock(path);
                String[] tempData=buffer.data[index];
                List<String> temp=new ArrayList<>(Arrays.asList(tempData));
                dataR.addAll(temp);
            }
            dataR.sort(Comparator.comparingInt(o -> Integer.parseInt(o.split(" ")[0])));
            //将排好序的写回磁盘
            int lgh=end-start;
            for(int k=0;k<lgh;k++){
                int num=i*7+k;
                String path="task1\\dir\\join\\sortmerge\\sort\\R"+num+".blk";
                String[] temp=new String[7];
                for(int j=0;j<7;j++){
                    if(k*7+j<dataR.size()){
                        temp[j]=dataR.get(k*7+j);
                    }
                }
                //System.out.println(temp[0]);
                buffer.writeBuffer(temp,path);

                buffer.freeBlock(7);
            }
            buffer.freeAllBlock();
        }


        //块间排序R
        List<List<String>> blkData=new ArrayList<>();
        for(int i=0;i<3;i++){
            blkData.add(new ArrayList<>());
        }
        int[] indexList=new int[3];
        List<String> sortBlk=new ArrayList<>();
        for(int i=0;i<3;i++){
            indexList[i]=i*7;
        }

        int count=0;
        while(true){
            for(int i=0;i<blkData.size();i++){
                if(blkData.get(i).size()==0){
                    buffer.freeBlock(i);
                    if(indexList[i]<Math.min((i+1)*7,16)){
                        String path="task1\\dir\\join\\sortmerge\\sort\\R"+indexList[i]+".blk";
                        int index=buffer.loadBlock(path);
                        List<String> temp=new ArrayList<>(Arrays.asList(buffer.data[index]));
                        //将blkData的第i个更改为temp
                        blkData.set(i,temp);
                        indexList[i]++;
                    }
                }
            }
            boolean flag=true;
            for(int i=0;i<blkData.size();i++){
                if(blkData.get(i).size()>0){
                    flag=false;
                    break;
                }
            }
            if(count==16 && flag){
                break;
            }else{
                int tempIndex=0;
                int digit=Integer.MAX_VALUE;
                for(int i=0;i<3;i++){
                    if(blkData.get(i).size()>0 ) {
                        if ((Integer.parseInt(blkData.get(i).get(0).split(" ")[0]) < digit)) {
                            tempIndex = i;
                            digit = Integer.parseInt(blkData.get(i).get(0).split(" ")[0]);
                        }
                    }
                }
                sortBlk.add(blkData.get(tempIndex).get(0));
                blkData.get(tempIndex).remove(0);
                if (sortBlk.size() == 7) {
                    String path = "task1\\dir\\join\\sortmerge\\sort\\Rfinal" + count + ".blk";
                    buffer.writeBuffer(sortBlk.toArray(new String[7]), path);
                    sortBlk = new ArrayList<>();
                    count++;
                }
            }
        }



        buffer.freeAllBlock();

        //排序S
        // 每次用7个块读 1个块输出 由于S有32个块 所以需要5次
        for(int i=0;i<=4;i++){
            int start=i*7;
            int end=Math.min((i+1)*7,32);
            List<String> dataS=new ArrayList<>();
            for(int j=start;j<end;j++){
                String path="task1\\dir\\relation\\"+"S"+j+".blk";
                int index=buffer.loadBlock(path);
                String[] tempData=buffer.data[index];
                List<String> temp=new ArrayList<>(Arrays.asList(tempData));
                dataS.addAll(temp);
            }
            dataS.sort(Comparator.comparingInt(o -> Integer.parseInt(o.split(" ")[0])));
            //将排好序的写回磁盘
            int lgh=end-start;
            for(int k=0;k<lgh;k++){
                int num=i*7+k;
                String path="task1\\dir\\join\\sortmerge\\sort\\S"+num+".blk";
                String[] temp=new String[7];
                for(int j=0;j<7;j++){
                    if(k*7+j<dataS.size()){
                        temp[j]=dataS.get(k*7+j);
                    }
                }
                buffer.writeBuffer(temp,path);

                buffer.freeBlock(7);
            }
            buffer.freeAllBlock();
        }

        //块间排序S
        List<List<String>> blkDataS=new ArrayList<>();
        for(int i=0;i<5;i++){
            blkDataS.add(new ArrayList<>());
        }
        int[] indexListS=new int[5];
        List<String> sortBlkS=new ArrayList<>();
        for(int i=0;i<5;i++){
            indexListS[i]=i*7;
        }

        int countS=0;
        while(true){
            for(int i=0;i<blkDataS.size();i++){
                if(blkDataS.get(i).size()==0){
                    buffer.freeBlock(i);
                    if(indexListS[i]<Math.min((i+1)*7,32)){
                        String path="task1\\dir\\join\\sortmerge\\sort\\S"+indexListS[i]+".blk";
                        int index=buffer.loadBlock(path);
                        List<String> temp=new ArrayList<>(Arrays.asList(buffer.data[index]));
                        //将blkData的第i个更改为temp
                        blkDataS.set(i,temp);
                        indexListS[i]++;
                    }
                }
            }
            boolean flag=true;
            for(int i=0;i<blkDataS.size();i++){
                if(blkDataS.get(i).size()>0){
                    flag=false;
                    break;
                }
            }
            if(countS==32 && flag){
                break;
            }else{
                int tempIndex=0;
                int digit=Integer.MAX_VALUE;
                for(int i=0;i<5;i++){
                    if(blkDataS.get(i).size()>0 ) {
                        if ((Integer.parseInt(blkDataS.get(i).get(0).split(" ")[0]) < digit)) {
                            tempIndex = i;
                            digit = Integer.parseInt(blkDataS.get(i).get(0).split(" ")[0]);
                        }
                    }
                }
                sortBlkS.add(blkDataS.get(tempIndex).get(0));
                blkDataS.get(tempIndex).remove(0);
                if (sortBlkS.size() == 7) {
                    String path = "task1\\dir\\join\\sortmerge\\sort\\Sfinal" + countS + ".blk";
                    buffer.writeBuffer(sortBlkS.toArray(new String[7]), path);
                    sortBlkS = new ArrayList<>();
                    countS++;
                }
            }
        }



    }

    public static void main(String[] args){
        extmem buffer=new extmem(8);
        join join=new join();
        join.nestedLoopJoin(buffer);
    }
}
