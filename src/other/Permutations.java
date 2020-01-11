package other;

import java.util.ArrayList;
import java.util.List;

/*
 Input a array. Output all the possible orders of arrays.
 */

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }
    private static void dfs(List<List<Integer>> res, int[] nums, int j) {
        if (j == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(res, nums, j+1);
            swap(nums, i, j);
        }
    }
    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> list = permute(arr);
        for(List<Integer> ls: list){
            System.out.println();
            for(int a : ls){
                System.out.print(a);
            }
        }
    }
}
