package swordingTooffer;

public class leftMove {
    public static String LeftRotateString(String str,int n) {
        char[] chars=str.toCharArray ();
        if (str.length ()<1||str==null){return  "";}
        if (n>chars.length){n=n%chars.length;}
        reverse (chars,0,n-1);
        reverse (chars,n,chars.length-1);
        reverse (chars,0,chars.length-1);
        return new String (chars);

    }
    public static void reverse(char[] chars,int s,int e){
        while (s<e){
            char temp=chars[s];
            chars [s]=chars[e];
            chars [e]=temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        String s="abcXYZdef";
        System.out.println (LeftRotateString (s,3));
    }
}
