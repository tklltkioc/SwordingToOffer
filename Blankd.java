package SwordingToOffer;

public class Blankd {
    public static String replaceSpace (StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder newstr = new StringBuilder ();
        for (int i = 0; i < str.length (); i++) {
            if (str.charAt (i) == ' ') {
                newstr.append ('%');
                newstr.append ('2');
                newstr.append ('0');
            } else {
                newstr.append (str.charAt (i));
            }
        }
        return newstr.toString ();
    }

    public static void main (String[] args) {
        StringBuffer s = new StringBuffer ();
        s.append ("3");
        s.append (" ");
        s.append ("2");
        System.out.println (replaceSpace (s));
    }

}
