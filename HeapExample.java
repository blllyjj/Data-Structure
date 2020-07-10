public class HeapExample{
    private int[] heap;
    private int size;

    HeapExample(int capacity){
        heap=new int[capacity];
    }

    public boolean isFull(){
        return size==heap.length;
    }

    public int getParent(int index){
        //return the parent position of the entered index
        return (index-1)/2;
    }

    public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Full");
        }
        
        heap[size]=value;
        fixHeapAbove(size);
        size++;
    }

    public void fixHeapAbove(int index){
        int newValue=heap[index]; //store the current value for comparison later
        while(index>0 && newValue>heap[getParent(index)]){
            heap[index]=heap[getParent(index)];
            index=getParent(index);
        }
        heap[index]=newValue;
    }

    public int delete(int index){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("empty");
        }
        //return the value that is deleted
        // int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index]=heap[size-1];

        if(index==0 || heap[getParent(index)]>heap[index] ){
            //fix below 
            fixHeapBelow(index, size-1);
        }else{
            //fix above
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    public void fixHeapBelow(int index, int LastHeapIndex){
        int childToSwap; // to hold the swapping index
        while(index<=LastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= LastHeapIndex){// left child exist
                if(rightChild > LastHeapIndex){//right child doesnt exist
                    //since right child doesnt exist 
                    //assign left child to the index holder childToSwap
                    childToSwap = rightChild;
                }else{
                    //right also exist
                    //in this case the index has both left and right children
                    //choose the larger one
                    childToSwap = (heap[leftChild]>heap[rightChild]) ? leftChild : rightChild;
                }
                //we now know the index to do the swapping
                //check if swapping would occur
                //if so swap it
                if(heap[index] < heap[childToSwap]){//condition met swap it
                    int temp=heap[index];
                    heap[index]=heap[childToSwap];
                    heap[childToSwap]=temp;
                }else{//condition not met dont swap
                    break;
                }
                index = childToSwap;
            }
            else{
                break;
            }
        }
    }

    //helper function
    public int getChild(int index, boolean left){
        //if it true get left child 
        //else get right child 
        return ( 2*index+(left ? 1 : 2) );
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }
    
}
