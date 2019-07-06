package swordingTooffer;

public class PofNthsaizi {
    public String[] printProbability(int n) {
        if (n <= 0)
            return null;
        int maxValue=6;
        //结果可能性总数
        int total = (int) Math.pow(maxValue, n);
        //可能出现的数字范围
        String[] result = new String[maxValue * n - n + 1];

        //dp[n][k] n个骰子朝上一面点数之和为k的次数
        int[][] dp = new int[n + 1][maxValue * n + 1];
        //初始化dp[1][1...6]
        for (int x = 1; x <= maxValue; x++)
            dp[1][x] = 1;
        //执行计算，dp(c,k)=dp(c-1,k-1)+dp(c-1,k-2)+dp(c-1,k-3)+dp(c-1,k-4)+dp(c-1,k-5)+dp(c-1,k-6).
        //dp[n][k]=sum（dp[n-1][k-m]）(1<=m<=6&&m<k,k<=maxValue*n)
        for (int c = 2; c <= n; c++)
            for (int k = 2; k <= maxValue * n; k++) {
                int sum = 0;
                for (int m = 1; m < k && m <= maxValue; m++)
                    sum += dp[c - 1][k - m];
                dp[c][k] = sum;
            }
        //统计结果,用分数表示
        for (int k = n; k <= maxValue * n; k++) {
            result[k - n] = dp[n][k] + "/" + total;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] result = new PofNthsaizi().printProbability(3);
        System.out.println(result.length);
        for (String val : result)
            System.out.print(val + ",");
    }
}
