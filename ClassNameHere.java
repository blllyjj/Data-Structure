public class ClassNameHere {
    public static void main(String[] args) {
       int[] intArray={-22,-15,1,7,20,35,55};
       System.out.println(iterativeBinarySearch(intArray,-15));
    }
    
    public static int iterativeBinarySearch(int[] intArray, int value){
       int start=0;
       int end=intArray.length;
       
       while(start<end){
          int midpoint=(end+start)/2;
          if(intArray[midpoint]==value){
             return midpoint;
          }
          else if(intArray[midpoint]<value){
             //search right
             start=midpoint+1;
          }else{
             //search left
             end=midpoint;
          }
       }
       
       //if testing the while loop no answer is match
       //the value doesnt exist in the array
       //return -1
       return -1;
    }
 }