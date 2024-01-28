public class Sorting1D_lab {
  static int heights[]={180,165,150,170,145};

  static void BubbleSort1D(int arr[]){
    int temp;
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<(arr.length-1);j++){
            if(arr[j]>arr[j+1]){
           temp= arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
            }
        }
    }
}
   static void SelectionSort1D(int[] arr){
    int i,j;
   
    for(i=0;i<arr.length-1;i++){
        for(j=i+1;j<arr.length;j++){                
            if(arr[j]<arr[i]){              
                
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;                              
            }
        }  
    }
}
   static void InsertionSort1D(int[] arr){
   for(int i=0; i<arr.length; i++){
    int current=arr[i];
    int j=i-1;
    while(j>=0 && arr[j]>current){
        arr[j+1]=arr[j];
        j--;
    }
     arr[j+1]=current;
   }
    }
    static int partition(int[] arr, int beg, int end){
        int pivot=arr[end];
        int i=beg-1;

        for(int j=beg; j<end; j++){
            if(arr[j]< pivot){
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[end]=temp;
        return i;
    }
    static void QuickSort1D(int[] arr, int beg, int end){
          int p;
          if(beg<end){
            p=partition(arr,beg,end);
            QuickSort1D(arr, beg, p-1);
            QuickSort1D(arr, p+1, end);
          }
    }

   static void display(){
    for(int i=0; i<heights.length; i++){
        System.out.print(heights[i]+" ");
    }
}
    public static void main(String[] args) {
        
        System.out.print("\nBy Insertion Sort: ");
        long beforeIS=System.nanoTime();
        InsertionSort1D(heights);
        long afterIS=System.nanoTime();
        display();
        System.out.println("\nTime took by Insertion Sort:"+(afterIS-beforeIS));

         System.out.print("\nBy Bubble Sort: ");
          long beforeBS=System.nanoTime();
        BubbleSort1D(heights);
         long afterBS=System.nanoTime();
        display();
         System.out.println("\nTime took by Bubble Sort:"+(afterBS-beforeBS));

         System.out.print("\nBy Selection Sort: ");
         long beforeSS=System.nanoTime();
        SelectionSort1D(heights);
        long afterSS=System.nanoTime();
        display();
        System.out.println("\nTime took by Selection Sort:"+(afterSS-beforeSS));

          System.out.print("\nBy Quick Sort: ");
         long beforeQS=System.nanoTime();
        QuickSort1D(heights, 0, heights.length-1);
        long afterQS=System.nanoTime();
        display();
        System.out.println("\nTime took by Quick Sort:"+(afterQS-beforeQS));

    }
}
