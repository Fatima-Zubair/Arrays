public class Sorting2D_Lab {
  static int arr[][]={{2,10,15}, {5,1,3}, {6,9,4}};

  static void BubbleSort2D(int arr[][]) {
    int rows = arr.length;
    int cols = arr[0].length;

    int totalElements = rows * cols;

    for (int i = 0; i < totalElements - 1; i++) {
        for (int j = 0; j < totalElements - i - 1; j++) {
            int row1 = j / cols;
            int col1 = j % cols;
            int row2 = (j + 1) / cols;
            int col2 = (j + 1) % cols;

            if (arr[row1][col1] > arr[row2][col2]) {
                int temp = arr[row1][col1];
                arr[row1][col1] = arr[row2][col2];
                arr[row2][col2] = temp;
            }
        }
    }
}


static void SelectionSort2D(int arr[][]) {
    int rows = arr.length;
    int cols = arr[0].length;

    int totalElements = rows * cols;

    for (int i = 0; i < totalElements - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < totalElements; j++) {
            int row1 = j / cols;
            int col1 = j % cols;
            int rowMin = minIndex / cols;
            int colMin = minIndex % cols;

            if (arr[row1][col1] < arr[rowMin][colMin]) {
                minIndex = j;
            }
        }

        int temp = arr[i / cols][i % cols];
        arr[i / cols][i % cols] = arr[minIndex / cols][minIndex % cols];
        arr[minIndex / cols][minIndex % cols] = temp;
    }
}

    static void InsertionSort2D(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;

        int totalElements = rows * cols;

        for (int i = 1; i < totalElements; i++) {
            int key = arr[i / cols][i % cols];
            int j = i - 1;

            while (j >= 0 && arr[j / cols][j % cols] > key) {
                arr[(j + 1) / cols][(j + 1) % cols] = arr[j / cols][j % cols];
                j = j - 1;
            }
            arr[(j + 1) / cols][(j + 1) % cols] = key;
        }
    }
    static int partition(int arr[][], int low, int high) {
        int pivot = arr[high / arr[0].length][high % arr[0].length];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j / arr[0].length][j % arr[0].length] < pivot) {
                i++;

                int temp = arr[i / arr[0].length][i % arr[0].length];
                arr[i / arr[0].length][i % arr[0].length] = arr[j / arr[0].length][j % arr[0].length];
                arr[j / arr[0].length][j % arr[0].length] = temp;
            }
        }

        int temp = arr[(i + 1) / arr[0].length][(i + 1) % arr[0].length];
        arr[(i + 1) / arr[0].length][(i + 1) % arr[0].length] = arr[high / arr[0].length][high % 
                                                                                  arr[0].length];
        arr[high / arr[0].length][high % arr[0].length] = temp;

        return i + 1;
    }

    static void QuickSort2D(int arr[][], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            QuickSort2D(arr, low, pi - 1);
            QuickSort2D(arr, pi + 1, high);
        }
    }

   static void display() {
    for (int i = 0; i < arr.length; i++) {
        System.out.print("[");
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println("]");
    }
}
    public static void main(String[] args) {
        
        System.out.print("\nBy Insertion Sort: \n");
        long beforeIS=System.nanoTime();
        InsertionSort2D(arr);
        long afterIS=System.nanoTime();
        display();
        System.out.println("\nTime took by Insertion Sort:"+(afterIS-beforeIS));

         System.out.print("\nBy Bubble Sort: \n");
          long beforeBS=System.nanoTime();
        BubbleSort2D(arr);
         long afterBS=System.nanoTime();
        display();
         System.out.println("\nTime took by Bubble Sort:"+(afterBS-beforeBS));

         System.out.print("\nBy Selection Sort: \n");
         long beforeSS=System.nanoTime();
        SelectionSort2D(arr);
        long afterSS=System.nanoTime();
        display();
        System.out.println("\nTime took by Selection Sort:"+(afterSS-beforeSS));

          System.out.print("\nBy Quick Sort: \n");
         long beforeQS=System.nanoTime();
        QuickSort2D(arr, 0, arr.length-1);
        long afterQS=System.nanoTime();
        display();
        System.out.println("\nTime took by Quick Sort:"+(afterQS-beforeQS));

    }
}
