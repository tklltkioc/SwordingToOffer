package SwordingToOffer;

public class reverseString {
    public static String ReverseSentence (String str) {
        if (str == null || str.length () < 1) {
            return null;
        }
        if (str.trim ().equals ("")) {
            return str;
        }
        String[] s1 = str.split (" ");
        StringBuffer sb = new StringBuffer ();
        for (int i = s1.length - 1; i >= 0; i--) {
            sb.append (s1[i]);
            sb.append (" ");
        }
        return sb.toString ();
    }

    public static String ReverseSentence2 (String str) {
        if (str == null) {
            return null;
        }
        if (str.trim ().equals ("")) {
            return str;
        }
        String string = str;
        String[] strings = string.split (" ");
        StringBuilder sBuilder = new StringBuilder ();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                sBuilder.append (strings[i]);
            } else {
                sBuilder.append (strings[i]);
                sBuilder.append (" ");
            }
        }

        String string2 = sBuilder.toString ();
        return string2;
    }

    public static void main (String[] args) {
        String s1 = "I am a student.";
        String s2 = "student. a am I";
        System.out.println (ReverseSentence (s1));
        System.out.println (ReverseSentence2 (s1));
        System.out.println (ReverseSentence (s2));
        System.out.println (ReverseSentence2 (s2));
    }


}
