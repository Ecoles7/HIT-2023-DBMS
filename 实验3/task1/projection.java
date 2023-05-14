import java.util.Objects;

public class projection {
    public static void pro(extmem buffer){
        String[] resR=new String[14];
        int TumpleNumR=0;
        int countR=0;
        for(int i=0;i<16;i++){
            String path="task1\\dir\\relation\\"+"R"+i+".blk";
            int index=buffer.loadBlock(path);
            for(String data: buffer.data[index]){
                if(data==null){continue;}
                String data1=data.split(" ")[0];
                resR[TumpleNumR]=data1;
                TumpleNumR++;
                if(TumpleNumR==14){
                    String writePath="task1\\dir\\projection\\R"+countR+".blk";
                    buffer.writeBuffer(resR,writePath);
                    resR=new String[14];
                    TumpleNumR=0;
                    countR++;
                }
            }
            buffer.freeBlock(index);
        }
    }

    public static void main(String[] args){
        extmem buffer=new extmem(8);
        pro(buffer);
    }
}
