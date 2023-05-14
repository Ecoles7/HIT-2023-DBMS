import java.util.ArrayList;
import java.util.List;

//树节点
public class TreeNode {
    String op;
    String info;
    List<TreeNode> child;
    TreeNode(String op, String info, List<TreeNode> child) {
        this.op = op;
        this.info = info;
        this.child = child;
    }
    TreeNode() {
        this.op = "";
        this.info = "";
        this.child = new ArrayList<>();
    }
    TreeNode(String info){
        this.op="";
        this.info=info;
        this.child = new ArrayList<>();
    }
    TreeNode(String op, String info){
        this.op=op;
        this.info=info;
        this.child = new ArrayList<>();
    }
    public String toString() {
        String s1="";
        String s2="";
        if(op.length()>0){
            s1=op;
        }

        if(info.length()>0){
            s2=info;
        }

        return s1 + " " + s2;
    }

}
