package swordingTooffer;


import java.util.ArrayList;

public class minKth {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(input.length < k || k == 0)
            return list;

        for (int i = 0; i < k; i++)
            list.add(input[i]);

        for (int i = k; i < input.length; i++) {

            int j = getMax(list);
            int temp =  list.get(j);
            if (input[i] < temp)
                list.set(j, input[i]);
        }
        return list;
    }
    public static int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(data,3));
    }
}
