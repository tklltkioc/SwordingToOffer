package SwordingToOffer;

import java.util.*;

public class firstChar {
    public static int FirstNotRepeatingChar(String str, int n) {
        char[] c = str.toCharArray ();
        int a[] = new int['z' - 0];
        for (int i = 0; i < n; i++) {
            char d = c[i];
            a[(int) d]++;
        }
        for (int i = 0; i < n; i++) {
            if (a[(int) c[i]] == 1) {
                return i;
            }
        }
        return 0;
    }

    public static int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length () == 0) return -1;
        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<> ();
        for (int i = 0; i < str.length (); ++i) {
            if (mp.containsKey (str.charAt (i))) {
                int time = mp.get (str.charAt (i));
                mp.put (str.charAt (i), ++time);
            } else {
                mp.put (str.charAt (i), 1);
            }
        }
        int pos = -1;
        for (int i = 0; i < str.length (); ++i) {
            char c = str.charAt (i);
            if (mp.get (c) == 1)
                return i;
        }
        return pos;
    }

    public static void main(String[] args) {
        String str = "sadcds";
        System.out.println (FirstNotRepeatingChar (str, 6));
        System.out.println (FirstNotRepeatingChar (str, 4));
        System.out.println (FirstNotRepeatingChar2 (str));


    }
}
