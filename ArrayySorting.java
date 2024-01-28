import java.util.Scanner;
class test{
  Scanner sc=new Scanner(System.in);
   void insert(int[]arr){
    System.out.println("Enter array elements: ");
        for(int i=0; i<arr.length; i++){
          arr[i]=sc.nextInt();
        }}
         void display(int[]arr){
        for(int i=0; i<arr.length; i++){
          System.out.print(arr[i]+" ");
        }}
    int LinearSearch(int[]arr, int x){
      
      for(int i=0; i<arr.length;i++){
        if(arr[i]==x)
        return i;
      }
      return -1;
    }
    void Found(int x){
       if(x==-1){
            System.out.println("NOT FOUND");
        }
        else{
           System.out.println("FOUND AT INDEX "+x);
        }  
    }
     int BinarySearch(int[]arr, int findE){
          int L=0, R=arr.length-1;
          int mid;
          while(L<=R){
            mid=(L+R)/2;
            if(findE==arr[mid]){
                return mid;
            }
            else if(findE>arr[mid]){
              L=mid+1;
            }
            else{
                R=mid-1;
            }
          }
            return -1;
     }

     int[] BubbleSort(int [] arr){
     for(int i=0; i<arr.length-1;i++){
      for(int j=0; j<(arr.length-1)-i; j++){
        if(arr[j]>arr[j+1]){
           int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
        }
      }
     }
      return arr;
     }
}
public class ArrayySorting {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
      test t1=new test();
      System.out.println("Enter array size: ");
      int size=sc.nextInt();
        int arr[]=new int[size];
        t1.insert(arr);

       
        System.out.println("Enter any integer to search by linear search: ");
      int x=sc.nextInt();
      long beforeLS=System.nanoTime();
        int found=t1.LinearSearch(arr,x);
         long afterLS=System.nanoTime();
         System.out.println("TIME TAKEN FOR LS: "+(afterLS-beforeLS));
       
         t1.Found(found);
 
      arr=t1.BubbleSort(arr);
       //t1.display(arr);

         System.out.println("Enter any integer to search by binary search: ");
      int y=sc.nextInt();
        long beforeBS=System.nanoTime();
        int found1=t1.BinarySearch(arr,y);
         long afterBS=System.nanoTime();
         System.out.println("TIME TAKEN FOR BS: "+(afterBS-beforeBS));
          t1.Found(found1);}}
