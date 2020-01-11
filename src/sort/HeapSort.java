package sort;

public class HeapSort {

    /**
     * 堆排序时间复杂度O(NlogN)，额外空间复杂度O(1)
     * 如果只是建立堆的过程，用从下往上的方式，时间复杂度为O(N)
     * 优先级队列结构 PriorityQueue，就是堆结构
     */

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 这个是从上往下建立堆的方式，但是从下往上建堆的方式更好，复杂度可以收敛到O(N)
        for (int i = 0; i < arr.length; i++){ // O(N)次
            heapInsert(arr, i); // O(logN)
        }
        int heapSize = arr.length; // 堆的有效size
        swap(arr, 0, --heapSize); // 最大值，和堆中的最后一个数交换，堆有效size-1
        while (heapSize > 0){ // O(N)次
            heapIfy(arr,0,heapSize); // O(logN)
            swap(arr,0,--heapSize);
        }
    }

    // index位置上是新加的数
    // 0~index范围伤的数，调成大根堆

    public static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index-1) / 2]){
            swap(arr,index,(index-1) / 2);
            index = (index-1) / 2;
        }
    }

    // arr[0]
    // arr[i]的位置的值发生了变化，并且是变小，堆大小是size(arr[0~heapSize-1]),请重新调整成大根堆

    public static void heapIfy(int[] arr, int i, int heapSize){
        int L = i * 2 + 1; // 左孩子的位置
        while (L < heapSize){ // 如果当前位置的数有孩子的话，循环发生
            // 如果右孩子有的话，和左孩子的值比较，最大的值的下标，作为largest的值
            int largest = L + 1 < heapSize // 右孩子如果不越界
                        && arr[L + 1] > arr[L] // 右孩子的值大于左孩子的值
                            ? L + 1 : L;
            // 两个孩子和父节点的值比较，最大的值的下标，作为largest的值
            largest = arr[largest] > arr[i] ? largest : i;
            if (largest == i){ // 如果最大的值的下标已经是父节点的位置，过程停止
                break;
            }
            // 选出来的largest的位置一定不是i位置，是i位置的左右两个孩子中，较大数的下标
            swap(arr,largest,i);
            i = largest;
            L = i * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
