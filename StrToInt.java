package SwordingToOffer;

public class StrToInt {
    public static int StrToInt(String str) {
        if (str.length () == 0 || str == null) {
            return 0;
        }
        char[] a = str.toCharArray ();
        int strChar = 0;
        if (a[0] == '-')
            strChar = 1;
        int sum = 0;
        for (int i = strChar; i < str.length (); i++) {
            if (a[i] == '+' && i == 0)
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return strChar == 0 ? sum : sum * -1;
    }


    public static void main(String[] args) {
        String s = "-2147483648";
        String s0 = "21-47483648";
        String s1 = "-2111";
        String s2 = "";
        System.out.println (StrToInt (s));
        System.out.println (StrToInt (s0));
        System.out.println (StrToInt (s1));
        System.out.println (StrToInt (s2));
    }
}
