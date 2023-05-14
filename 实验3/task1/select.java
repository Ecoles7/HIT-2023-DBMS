import java.util.Objects;

public class select {
    public static void linearSearch(extmem buffer){
        //选出R.A=40的元组

        String[] resR=new String[7];
        int TumpleNumR=0;
        int countR=0;
        for(int i=0;i<16;i++){
            String path="task1\\dir\\relation\\"+"R"+i+".blk";
            int index=buffer.loadBlock(path);
            for(String data: buffer.data[index]){
                if(data==null){continue;}
                String data1=data.split(" ")[0];
                String data2=data.split(" ")[1];
                if(Objects.equals(data1, "40")){
                    resR[TumpleNumR]=data;
                    TumpleNumR++;
                    if(TumpleNumR==7){
                        String writePath="task1\\dir\\select\\R"+countR+".blk";
                        buffer.writeBuffer(resR,writePath);
                        resR=new String[7];
                        TumpleNumR=0;
                        countR++;
                    }
                }
            }
            buffer.freeBlock(index);
        }

        if(TumpleNumR!=0){
            String writePath="task1\\dir\\select\\R"+countR+".blk";
            buffer.writeBuffer(resR,writePath);
        }


        String[] resS=new String[7];
        int TumpleNumS=0;
        int countS=0;
        //选出S.C=60的元组
        for(int i=0;i<32;i++){
            String path="task1\\dir\\relation\\"+"S"+i+".blk";
            int index=buffer.loadBlock(path);

            for(String data: buffer.data[index]){
                if(data==null){continue;}
                String data1=data.split(" ")[0];
                String data2=data.split(" ")[1];
                if(Objects.equals(data1, "60")){
                    resS[TumpleNumS]=data;
                    TumpleNumS++;
                    if(TumpleNumS==7){
                        String writePath="task1\\dir\\select\\S"+countS+".blk";
                        buffer.writeBuffer(resS,writePath);
                        resS=new String[7];
                        TumpleNumS=0;
                        countS++;
                    }
                }
            }
            buffer.freeBlock(index);
        }
        if(TumpleNumS!=0){
            String writePath="task1\\dir\\select\\S"+countS+".blk";
            buffer.writeBuffer(resS,writePath);
        }

    }
    public static void main(String[] args){
        extmem buffer=new extmem(8);
        linearSearch(buffer);
    }
}
