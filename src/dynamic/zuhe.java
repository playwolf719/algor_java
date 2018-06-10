package dynamic;

/**
 * Created by playwolf on 6/7/2018.
 */
public class zuhe {
    public static int zuheFunc(int n,int c){
        if (n<c || c<0){
            return 0;
        }
        if (c==0){
            return 1;
        }
        return zuheFunc(n-1,c-1)+zuheFunc(n-1,c);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(zuhe.zuheFunc(5,2));
    }
}
