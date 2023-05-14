import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class extmem {
    public int numIO; //磁盘IO次数
    public int numAllBlk; //缓冲区块总数目
    public int numFreeBlk; //可用块的数目
    public boolean[] dataFlag; //占用状态
    public String[][] data;//数据

    public extmem(){}

    public extmem(int numAllBlk) {
        this.numIO = 0;
        this.numAllBlk = numAllBlk;//默认8个块
        this.numFreeBlk = numAllBlk;
        this.dataFlag = new boolean[numAllBlk];
        this.data=new String[this.numAllBlk][7];
    }

    //获得第一个空闲的块
    public int getFreeBlock(){
        for(int i=0;i<this.numAllBlk;i++){
            if(!this.dataFlag[i]){
                this.dataFlag[i]=true;
                this.numFreeBlk--;
                return i;
            }
        }
        return -1;
    }

    //释放块
    public boolean freeBlock(int index){
        boolean flag=this.dataFlag[index];
        if(flag){
            this.dataFlag[index]=false;
            this.numFreeBlk++;
            return true;
        }
        else{
            return false;
        }
    }

    public void freeAllBlock(){
        for(int i=0;i<numAllBlk;i++){
            freeBlock(i);
        }
    }

    //读入数据
    public int loadBlock(String addr){
        int index=this.getFreeBlock();
        try{
            Scanner sc = new Scanner(new FileReader(addr));
            //以换行符为界限，读入数据
            String[] temp=new String[7];
            int i=0;
            while(sc.hasNextLine()){
                temp[i]=sc.nextLine();
                i++;
            }
            this.data[index]=temp;
            this.numIO++;
            this.dataFlag[index]=true;
        }
        catch(Exception e){
            System.out.println("文件不存在");
            return -1;
        }
        return index;
    }

    //将缓冲区数据写入磁盘
    public boolean writeBlock(int index,String addr){
        try(FileWriter fw = new FileWriter(addr)) {
            for (int i = 0; i < 7; i++) {
                fw.write(this.data[index][i]);
                fw.write("\n");
            }
            this.numIO++;
            this.numFreeBlk++;
            this.dataFlag[index]=false;
            return true;
        }catch(Exception e){
            System.out.println("文件不存在，新建");
            return false;
        }
    }

    //将数据写入缓冲区
    public boolean writeBuffer(String[] data,String addr){
        int index=getFreeBlock();
        if(index==-1){
            return false;
        }
        else{
            this.data[index]=data;  //将数据写入缓冲区
            this.writeBlock(index,addr); //再将数据写入磁盘
            this.freeBlock(index);
            return true;
        }
    }


    //生成关系R的随机数据
    public String[] genDataR(int tupleNum, int blkNum){
        //R数据生成
        int numR=tupleNum*blkNum;
        String[] dataR=new String[numR];
        for(int i=0;i<numR;i++){
            dataR[i]= (int) (Math.random() * 39 + 1) +" "+ (int) (Math.random() * 999 + 1);
        }
        return dataR;
    }

    //生成关系S的随机数据
    public String[] genDataS(int tupleNum, int blkNum){
        //S数据生成
        int numS=tupleNum*blkNum;
        String[] dataS=new String[numS];
        for(int i=0;i<numS;i++){
            dataS[i]= (int) (Math.random() * 40 + 20) +" "+ (int) (Math.random() * 999 + 1);
        }
        return dataS;
    }

    //将关系R和S的数据写入磁盘
    public void writeDisk(int tupleNum, int blkNum1, int blkNum2,String dir){
        String[] dataR=genDataR(tupleNum,blkNum1);
        String[] dataS=genDataS(tupleNum,blkNum2);

        //写入R的数据
        for(int i=0;i<blkNum1;i++){
            String[] temp=new String[tupleNum];
            String path=dir+"R"+i+".blk";
            File file=new File(path);
            if(!file.exists()){
                try{
                    file.createNewFile();
                }catch(Exception e){
                    System.out.println("文件创建失败");
                }
            }
            try(FileWriter fw = new FileWriter(path)) {
                for(int j=0;j<tupleNum;j++){
                    temp[j]=dataR[i*tupleNum+j];
                    fw.write(temp[j]);
                    fw.write("\n");
                }
                fw.close();
            }catch(Exception e){
                System.out.println("文件不存在");
            }

        }

        //写入S的数据
        for(int i=0;i<blkNum2;i++){
            String[] temp=new String[tupleNum];
            String path=dir+"S"+i+".blk";
            File file=new File(path);
            if(!file.exists()){
                try{
                    file.createNewFile();
                }catch(Exception e){
                    System.out.println("文件创建失败");
                }
            }
            try(FileWriter fw = new FileWriter(path)) {
                for(int j=0;j<tupleNum;j++){
                    temp[j]=dataS[i*tupleNum+j];
                    fw.write(temp[j]);
                    fw.write("\n");
                }
                fw.close();
            }catch(Exception e){
                System.out.println("文件不存在");
            }
        }

    }

    public static void main(String[] args) {
        //初始化
        extmem em=new extmem();
        //生成数据
       em.writeDisk(7, 16,32,"task1\\dir\\relation\\");

    }




}
