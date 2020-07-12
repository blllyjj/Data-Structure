public class treeNode{

    public int data;
    public treeNode left;
    public treeNode right;

    public treeNode(int data){
        this.data=data;
    }

    public void insert(int value){
        if(value<data){ //this data is root's data  (aka root.data)
            //create left node to equal to this value
            if(left==null){ //if root's left is null
                left=new treeNode(value);
            }else{
                left.insert(value);
            }
        }
        if(value>data){
            if(right==null){
                right=new treeNode(value);
            }else{
                right.insert(value);
            }
        }
    }

    public String toString(){
        return "Data "+data;
    }

    //printing out all the number from left to right
    public void traverseNode(){
        if(left!=null){
            left.traverseNode();
        }
        System.out.print(" "+data+" ");
        if(right!=null){
            right.traverseNode();
        }
    }
    
}