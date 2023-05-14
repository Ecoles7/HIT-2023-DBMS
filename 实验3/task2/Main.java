import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static TreeNode getTree(String query){
        String[] tokens=query.split(" ");
        List<String> tokenList= Arrays.asList(tokens);
        int index=0;
        TreeNode node=new TreeNode();
        while (index<tokenList.size()){
            String token=tokenList.get(index);
            if(Objects.equals(token, "SELECT") || Objects.equals(token, "PROJECTION")){
                int end=tokenList.indexOf("]");
                node.op=token;
                node.info=String.join(" ",tokenList.subList(index+2,end));
                index=end+1;
            }
            else if(Objects.equals(token, "JOIN")){
                node.op=token;
                String before=tokenList.get(index-1);
                String after=tokenList.get(index+1);
                node.child.add(new TreeNode(before));
                node.child.add(new TreeNode(after));
                index++;
            }
            else if(Objects.equals(token, "(")){
                int count=1;
                int index2=index+1;
                while(index2<tokenList.size() && count>0){
                    if(Objects.equals(tokenList.get(index2), "(")){
                        count++;
                    }
                    else if(Objects.equals(tokenList.get(index2), ")")){
                        count--;
                    }
                    index2++;
                }
                node.child.add(getTree(String.join(" ",tokenList.subList(index+1,index2-1))));
                index=index2;
            }else{
                index++;
            }
        }
        return node;
    }

    public static void outputTree(TreeNode node,String sep){
        System.out.println(sep+node.toString());
        if(node.child.size()>0){
            for(TreeNode child:node.child){
                outputTree(child,sep+'\t');
            }
        }
    }

    public static TreeNode optimize(TreeNode node,String[] infoList){
        if(node.op.equals("SELECT")){
            node=optimize(node.child.get(0),node.info.split("&"));
        }
        else if(node.op.equals("PROJECTION")){
            node.child.set(0,optimize(node.child.get(0),infoList));
        }
        else if(node.op.equals("JOIN")){
            String op="SELECT";

            TreeNode node0=new TreeNode(op,infoList[0]);
            node0.child.add(node.child.get(0));
            node.child.set(0,node0);
            if(infoList.length>1){
                TreeNode node1=new TreeNode(op,infoList[1]);
                node1.child.add(node.child.get(1));
                node.child.set(1,node1);
            }
        }
        return node;
    }

    public static void main(String[] args){
        String quiry1="SELECT [ ENAME = ’Mary’ & DNAME = ’Research’ ] ( EMPLOYEE JOIN DEPARTMENT )";
        String quiry2="SELECT [ ESSN = ’01’ ] ( PROJECTION [ ESSN, PNAME ] ( WORKS_ON JOIN PROJECT ) )";
        String quiry3="PROJECTION [ BDATE ] ( SELECT [ ENAME = ’John’ & DNAME = ’ Research’ ] ( EMPLOYEE JOIN DEPARTMENT ) )";
        TreeNode root=getTree(quiry3);
        String[] list=null;
        root=optimize(root,list);
        outputTree(root,"");

    }



}
