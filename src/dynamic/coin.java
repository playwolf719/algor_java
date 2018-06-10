package dynamic;

/**
 * Created by playwolf on 6/7/2018.
 */
public class coin {
    public static int maxVal = 1000000000;
    public static int findIt(int index,int[] coins,int amount,int[] tmpArr){
        if (index>=coins.length){
            return maxVal;
        }
        if (amount<0){
            return maxVal;
        }
        if (amount==0){
            return 0;
        }
        if (tmpArr[amount-1]!=0){
            return tmpArr[amount-1];
        }
        int a = findIt(index,coins,amount-coins[index],tmpArr)+1;
        int b = findIt(index+1,coins,amount,tmpArr);

        int tmp = Math.min(a,b);
        if (tmp<maxVal){
            tmpArr[amount-1] = tmp;
            System.out.println(amount+" "+tmp);
            int cc=1;
        }
        return tmp;
    }
    public static int coinChange(int[] coins, int amount) {
        int[] res =new int[amount];
//        for (int j=0;j<amount;j++){
//            res[j] = -1;
//        }
        int tmpRes = findIt(0,coins,amount,res);
        if (tmpRes < maxVal){
            return tmpRes;
        }
        return -1;

    }

    public static void main(String[] args) throws Exception {
//        System.out.println(backpackFunc(5,maxWeight));
        int[] coins = {357,239,73,52};
//        int[] coins = {1,2,5};
        int amount = 9832;
        System.out.println(coinChange(coins,amount));

    }
}
