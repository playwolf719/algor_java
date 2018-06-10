package dynamic;

import java.util.Map;
import java.util.Stack;

/**
 * Created by playwolf on 6/9/2018.
 */
public class longestCommonChuan {

    public static void lcd(){

    }
    public static void main(String[] args) throws Exception {
//        System.out.println(backpackFunc(5,maxWeight));
        char[] a = {'A','B','C','B','D','A','B'};
        char[] b = {'B','D','C','A','B','A'};
        int[][] res =new int[a.length][b.length];
        String[][] direct =new String[a.length][b.length];
        int maxlen = 0;
//        for (int i =0;i<a.length;i++){
//            if (a[i]==b[0]){
//                res[i][0] = 1;
//            }
//        }
//        for (int j =0;j<b.length;j++){
//            if (a[0]==b[j]){
//                res[0][j] = 1;
//            }
//        }
        for (int i=0;i<a.length;i++){
            for (int j=0;j<b.length;j++){
                if (i==0||j==0){
                    direct[i][j] = "";
                    if (a[i]==b[j]){
                        res[i][j] = 1;
                        direct[i][j] = "last";
                    }
                }else{
                    int tmp = 0;
                    if (a[i]==b[j]){
                        tmp = res[i-1][j-1]+1;
                        direct[i][j] = "left_up";
                    }else{
//                       最长公共子序列
                        if (res[i-1][j]>res[i][j-1]){
                            direct[i][j] = "up";
                        }else {
                            direct[i][j] = "left";
                        }
                        tmp = Math.max(res[i-1][j],res[i][j-1]);
//                       最长公共子串
//                        tmp = 0;

                    }

                    res[i][j] = tmp;
                }

            }
        }
        maxlen = res[a.length-1][b.length-1];
        for (int i=a.length-1;i>=0;i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                if (res[i][j] >= maxlen) {
                    System.out.print(j);
                    int start_j = j;
                    System.out.print(start_j);
                    Stack tmp = new Stack();
                    for (int h = i;  h >= 0 && start_j >= 0; ) {
                        if (direct[h][start_j].equals("left_up")) {
                            tmp.add(b[start_j]);
                            h--;
                            start_j--;
                        } else if (direct[h][start_j].equals("left")) {
                            start_j--;
                        } else if (direct[h][start_j].equals("up")) {
                            h--;
                        } else if (direct[h][start_j].equals("last")) {
                            tmp.add(b[start_j]);
                            break;
                        } else {
                            break;
                        }
                    }

                    System.out.println("stack!");
                    for (int k = tmp.size(); k > 0; k--) {
                        System.out.println("stack: " + tmp.pop());
                    }
                    break;
                }
            }
        }
        int cc=1;
    }
}
