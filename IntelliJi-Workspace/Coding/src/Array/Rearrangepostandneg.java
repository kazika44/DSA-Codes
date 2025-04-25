package Array;

public class Rearrangepostandneg {
    public static void main(String args[]) {
        int arr[] = {2, 3, -4, -1, 6, -9};

        int n = arr.length;

        System.out.println("Given array is ");
        printArray(arr, n);

        rearrange(arr, n);

        System.out.println("Rearranged array is ");
        printArray(arr, n);
    }

    public static void rearrange(int[] arr, int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && arr[i] > 0) {
                i += 1;
            }
            while (j > 0 && arr[j] < 0) {
                j -= 1;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        if (i == 0 || i == n)
            return;
        int k = 0;
        while (k < n && i < n) {
            swap(arr, k, i);
            i += 1;
            k += 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
}
