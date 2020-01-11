package other;

public class MinOps {


    /**
     * 判断一个数的最少因子数个数
     */


    public static int minOps(int n){
        if (n < 2) {
            return 0;
        }
        if (isPrim(n)){
            return n - 1;
        }

        int[] divSumAndCount = divSumAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }

    /**
     * 判断一个数是否为质数？只需要从2遍历到n的平方根即可
     * @param n
     * @return
     */
    public static boolean isPrim(int n){
        if (n < 2){
            return false;
        }
        int max = (int)Math.sqrt((double) n);
        for (int i = 2; i <= max; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int[] divSumAndCount(int n){
        int count = 0;
        int sum = 0;
        for (int i = 2; i <= n; i++){
            if (n % i == 0){
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[]{sum, count};
    }
}
