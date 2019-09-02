package SwordingToOffer;

import java.util.Arrays;
import java.util.Comparator;

public class minSortNum {
    public static String PrintMinNumber (int[] numbers) {
        if (numbers == null || numbers.length == 0) return " ";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder ();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf (numbers[i]);
        }

        Arrays.sort (str, new Comparator<String> () {
            @Override
            public int compare (String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo (c2);
            }
        });

        for (int i = 0; i < len; i++) {
            sb.append (str[i]);
        }
        return sb.toString ();
    }

    public static void main (String[] args) {
        int x[] = {3, 32, 321};
        System.out.println (PrintMinNumber (x));

    }
}
