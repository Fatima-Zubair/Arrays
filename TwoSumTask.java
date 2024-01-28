import java.util.Scanner; 

public class TwoSumTask {
    static void display_target_indexes(int array[], int target){
        boolean a=false;
        for(int i=0;i<array.length-1; i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==target){
                    System.out.println("[ "+i+", "+j+" ]");
                    a=true;
                    break;    }
                    }     
        }   if(!a){
            System.out.println("Indexes not found");}
    }
    public static void main(String[] args) {
   
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:" );
        int size=sc.nextInt();
        int array[]=new int[size];
        System.out.println("Enter array elements: ");
        for(int i=0; i<array.length; i++){
              array[i]=sc.nextInt();}
        System.out.println("Enter the target: ");
        int target=sc.nextInt();
        display_target_indexes(array, target);   
    }
}
