package swordingTooffer;

public class ZhengZe {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null) {
            return false;
        }
        if (pattern == null){
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        if (str==null&&pattern!=null){
            if (pattern.length>1&&pattern[1]=='*')
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            else
                return false;
        }
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {

        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String x="aaa";
        String x1="a.a.";
        String x2="aa*a*";
        char[] a=x.toCharArray ();
        char[] a1=x1.toCharArray ();
        char[] a2=x2.toCharArray ();

        System.out.println (match (a,a1));
        System.out.println (match (a,a2));

    }
}
