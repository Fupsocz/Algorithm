package other;

import java.util.HashMap;

public class Split4Parts {

    /**
     * 给定一个数组，是否可以切成三份，选定的两个数不算，三份的累加和相等
     */

    public static boolean canSplit(int[] arr){
        if (arr == null || arr.length < 7){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = arr[0];
        for (int i = 0; i < arr.length; i++){
            map.put(sum, i);
            sum += arr[i];
        }
        int lSum = arr[0];  // l第一刀左侧的累加和
        for (int s1 = 1 ;s1 < arr.length - 5; s1++){  // s1是第一刀的位置
            int checkSum = lSum * 2 + arr[s1];
            if (map.containsKey(checkSum)){
                int s2 = map.get(checkSum);
                checkSum += lSum + arr[s2];
                if (map.containsKey(checkSum)){
                    int s3 = map.get(checkSum);
                    if (checkSum + arr[s3] + lSum == sum){
                        return true;
                    }
                }
            }
            lSum += arr[s1];
        }
        return false;
    }
}
