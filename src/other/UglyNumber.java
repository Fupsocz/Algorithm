package other;

public class UglyNumber {

    /**
     * 假设一个数的因子仅包含2，3，5中任意的数，则成此数为丑数，强行把1归为丑数
     * 则丑数分别为 1,2,3,4,5,6,8,9,10,12  求第N个丑数
     */


    public static int uglyNumber(int n){
        int[] help = new int[n];
        help[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int index = 1;
        while (index < n){
            help[index] = Math.min(2 * help[i2], Math.min(3 * help[i3], 5 * help[i5]));
            if (help[index] == 2 * help[i2]){
                i2++;
            }
            if (help[index] == 3 * help[i3]){
                i3++;
            }
            if (help[index] == 5 * help[i5]){
                i5++;
            }
            index++;
        }
        return help[index - 1];
    }
}
