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

    
}