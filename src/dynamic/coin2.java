package dynamic;

/**
 * Created by playwolf on 6/7/2018.
 */
public class coin2 {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private static int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        System.out.println(rem+" "+count[rem-1]);
        return count[rem - 1];
    }
    public static int maxVal = 1000000000;
    public static int findIt(int[] coins,int amount,int[] tmpArr){
        if (amount<0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        if(tmpArr[amount-1]!=0)return tmpArr[amount-1];
        int min = maxVal;
        for (int coin : coins){
            int res = findIt(coins,amount-coin,tmpArr);
            if (res>=0&&res<min){
                min = res+1;
            }
        }
        tmpArr[amount-1] = min==maxVal?-1:min;
        return tmpArr[amount-1];
    }
    public int coinChange2(int[] coins, int amount) {
        int[] res = new int[amount];
        if (amount < 1) return 0;
        return findIt(coins,amount,res);

    }

    public static void main(String[] args) throws Exception {
//        System.out.println(backpackFunc(5,maxWeight));
        int[] coins = {357,239,73,52};
        int amount = 9832;
        System.out.println(coinChange(coins,amount));

    }
}
