package dynamic;

import java.util.*;

/**
 * Created by playwolf on 6/9/2018.
 */
public class travel {
    public static int[][] disMap= {{0,4,1},{1,0,3},{1,2,0},};
    public static Map<Integer,ArrayList<ArrayList<Integer>>> mapListList = new HashMap<>();
    public static ArrayList<ArrayList<Integer>> arrListList = new ArrayList<>();

    public static int make(boolean[] visit){
        int v=0;
        for (int i=0;i<visit.length;i++){
            if (visit[i]){
                v = (int) (v+Math.pow(2,i));
            }
        }
        return v;
    }

    public static int travelSub(int index, boolean[] visit, int level, ArrayList<Integer> arrList){
        int v = 0;

        int min = 1000;

        for(boolean res:visit){
            if (res){
                v++;
                if (v==visit.length){
                    min = 0;
                }
            }
        }
        if (min!=0) {
            for (int i = 0; i < visit.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    arrList.add(Integer.valueOf(i));
                    if (level==visit.length-1){
                        ArrayList<Integer> newList = new ArrayList<Integer>(arrList);
                        arrListList.add(newList);
//                        System.out.println("nima2  " + arrList);
                    }
                    int tmp1 = travelSub(i, visit, level + 1, arrList);
                    int tmp2 = disMap[index][i];
                    int tmp = tmp1 + tmp2;
                    if (tmp < min) {
                        min = tmp;
                        if (index == 0 && level==0 ) {
                            ArrayList<ArrayList<Integer>> tmpList = new ArrayList<>();
                            if (mapListList.containsKey(min)){
                                tmpList = mapListList.get(min);
                            }
                            tmpList.add(arrListList.get(arrListList.size()-1) );
                            mapListList.put(min,tmpList );
                            System.out.println("nima " + min + "  " + mapListList);
                        }

                    }

                    arrList.remove(Integer.valueOf(i));
                    visit[i] = false;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        boolean[] visit = new boolean[3];
        ArrayList<Integer> arrList = new ArrayList<>();
        int a = travelSub(0,visit,0,arrList);
        System.out.println(a);

    }
}
