package swordingTooffer;

public class numToChar {
    public static int translation(int n){
        if (n<0)return 0;
        if(n < 10)
            return 1;
        int tp = n;
        int pre = -1;
        while(tp > 0){
            int cur = tp%10;	//对10 求余得到当前的数字 cur
            if(pre == -1)		//如果pre = -1 说明当前是右边第一个数字
                pre = cur;
            else{
                if(cur*10 + pre <= 25){
                    return  translation(tp) + translation(tp/10);
                }
                pre = cur;		//将cur 赋给 pre，用以下次循环使用
            }
            tp = tp/10;
        }
        return 1;
    }

    public static int getTranslationCount(int number){
        if(number<0)
            return 0;
        if(number==1)
            return 1;
        return getTranslationCount(Integer.toString(number));
    }
    //动态规划，从右到左计算。
    //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    //如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
    public static int getTranslationCount(String number) {
        int f1 = 1,f2 = 1,g ;
        int temp;
        for(int i=number.length()-2;i>=0;i--){
            if(Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))<26)
                g = 1;
            else
                g = 0;
            temp = f2;
            f2 = f2+g*f1;
            f1 = temp;
        }
        return f2;
    }
    public static void main(String[] args){
        System.out.println(translation(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(translation (12));  //3
        System.out.println(translation (12222));  //8
        System.out.println(getTranslationCount(101)); //3
        System.out.println(getTranslationCount(12222)); //8
    }
}
