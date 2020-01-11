package sort;

public class QuickSort {


    /**
     * 随机快排额外空间复杂度是O(logN)
     */

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 把arr[L...R]上排好序

    public static void process(int[] arr, int L, int R){
        if (L < R){ // arr[L...R]上不止一个数

            // 如果不加下面这一句就是经典快排，复杂度是N方，加了就是随机快排，复杂度是O(NlogN)
            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R); // p数组是等于区域的[左位置，右位置]
            process(arr, L, p[0] - 1); // p[0] 等于区域的最左位置
            process(arr, p[1] + 1, R); // p[1] 等于区域的最右位置
        }
    }

    // 默认以arr[R]作为划分值，在arr[L...R]上，  <   ==   >
    // 返回一个数组int[] res，长度一定是2，res[0]代表等于区域的左边界
    // res[1]代表等于区域的右边界

    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1; // 小于区域的右边界
        int more = R; // 大于区域的左边界
        int index = L; // 当前数的下标
        while (index < more){
            if (arr[index] < arr[R]){ // arr[R]做划分
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[R]){
                swap(arr, --more, index);
            } else { // ==
                index++;
            }
        }
        swap(arr, more ,R);
        return  new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
