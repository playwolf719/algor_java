package dynamic;

/**
 * Created by playwolf on 6/7/2018.
 */
public class backpack {
    public static int[] vals={1,2,3,4,5,6};
    public static int[] weights={1,2,3,4,5,6};
    private static final int maxWeight = 10;
    public static int[][] res =new int[vals.length+1][maxWeight+1];

//    递归思想正确，但二维数组res不会被完全计算
    public static int backpackFunc(int idx,int tWeight){
//        边界条件
        if (idx<0 || idx>vals.length  ||tWeight<0||tWeight>maxWeight){
            return 0;
        }
//        初始值
        if (tWeight ==0 ){
            res[idx][tWeight] = 0;
            return res[idx][tWeight];
        }
//        计算过得则没必要重复计算
        if (res[idx][tWeight]>0){
            return res[idx][tWeight];
        }
        res[idx][tWeight] = backpackFunc(idx-1,tWeight);
        if (tWeight>=weights[idx]){
            res[idx][tWeight] = Math.max(res[idx][tWeight],backpackFunc(idx-1,tWeight-weights[idx])+vals[idx] );
        }
        return res[idx][tWeight];
    }
    public static void backpackFuncDiedai(){
        res[0][0] = 0;
        for(int i=1;i<vals.length+1;i++){
            res[i][0] = 0;
            for (int j=1;j<=maxWeight;j++){
                res[i][j] = res[i-1][j];
                if(j>=weights[i-1]){
                    res[i][j] = Math.max(res[i][j],res[i-1][j-weights[i-1]]+vals[i-1]);
                }
            }
            System.out.println("水电费");
        }
    }
    public static void main(String[] args) throws Exception {
//        System.out.println(backpackFunc(5,maxWeight));
        backpackFuncDiedai();

    }
}
