package sort;

public class SelectionSort {

    // 选择排序 复杂度O（n^2）,空间复杂度O（1）
    public static void selsctionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; i < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i ,minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
