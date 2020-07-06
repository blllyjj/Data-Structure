public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] intArray={-22,-15,1,7,20,35,55};
        int index=binarySearch(intArray, 0, intArray.length, 1);
        System.out.println(index);
    }

    public static int binarySearch(int[] array, int start, int end, int value){
        //return the index number of the array
        if(end<=start){
            return -1;
        }
        int midpoint=(start+end)/2;
        if(array[midpoint]==value){
            return midpoint;
        }else if(value>array[midpoint]){
            //search right
            //searching value is larger than array[midpoint]
            return binarySearch(array, midpoint+1, end, value);
        }else{
            //search left
            //searching value is smaller than array[midpoint]
            return binarySearch(array, start, midpoint, value);
        }

    }
}