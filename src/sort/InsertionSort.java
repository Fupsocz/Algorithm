package sort;

public class InsertionSort {

    // 插入排序，依次保证0位有序，然后1位有序，2位有序....
    // 复杂度视情况而定，最坏O（n^2），最好是O（n），以最坏情况为准

    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){ // ****关键点****，把判断条件放在了for循环里
                swap(arr, j, j+1);
            }
        }
    }

    // 交换两个数，不用任何辅助空间
    // 异或运算，直接理解为无进位相加
    public static void swap(int[] arr, int i, int j){
        // 假设i = x，j = y；
       arr[i] = arr[i] ^ arr[j]; // i = x ^ y, j = y
       arr[j] = arr[i] ^ arr[j]; // i = x ^ y, j = y ^ x ^ y = x
       arr[i] = arr[i] ^ arr[j]; // i = x ^ y ^ x = y, j = x
    }
}
