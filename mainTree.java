public class mainTree {

    treeNode root;

    public void insert(int value){
        if(root==null){
            root=new treeNode(value);
        }else{
            root.insert(value);
        }
    }

    public void traverse(){
        if(root!=null){
            root.traverseNode();
        }
    }



}