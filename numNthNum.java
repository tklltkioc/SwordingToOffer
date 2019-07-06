package swordingTooffer;

public class numNthNum {
    public static int digitAtIndex(int index){
        if(index<0)
            return -1;
        if(index<10)
            return index;
        int curIndex = 10,length = 2;
        int boundNum = 10;
        //判断第index数属于几位数
        while (curIndex+lengthSum(length)<index){
            curIndex+=lengthSum(length);
            boundNum*=10;
            length++;
        }
        //2、3、4等位数中的第几个
        int addNum = (index-curIndex)/length;
        //加上前位数数字的个数
        int curNum = boundNum + addNum;
        //输出index的数字
        return Integer.toString(curNum).charAt(index-curIndex-addNum*length)-'0';
    }
    public static int lengthSum(int length){
        int count = 9;
        for(int i=1;i<length;i++)
            count*=10;
        return count*length;
    }
    public static void main(String[] args){
        for(int i=9;i<16;i++)
            System.out.println(digitAtIndex(i));
        System.out.println(digitAtIndex(100));
//        System.out.println(digitAtIndex2(190));

    }
    private static int digitAtIndex2(int index)
    {
        if (index < 0) return -1;
        int digits = 1;
        while (true)
        {
            int digitNumbers = countOfNumbersFor(digits); //当前位数的数值个数
            //数值乘上它的位数等于数字个数，
            //比如，两位数有90个（10~99），每个数值有2个数字，总数字个数为180
            int countOfNumbers = digitNumbers * digits;
            if (index < countOfNumbers)
            {
                return digitAtIndex(index, digits);
            } else
            {
                //在下一位中查找
                index -= countOfNumbers;
                digits++;
            }
        }
    }

    //digits位数的数字个数，
    //两位数有9*10=90个（10~99），三位数有9*100=900个（100~999）
    private static int countOfNumbersFor(int digits)
    {
        if (digits == 1)
            return 10;

        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    private static int digitAtIndex(int index, int digits)
    {
        //对应的数值
        int number = beginNumberFor(digits) + index / digits;
        //从数值右边开始算的位置
        int indexFromRight = digits - index % digits;
        //去除右边的indexFromRight-1个数字
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        //求个位数字
        return number % 10;
    }

    //digits位数的第一个数字，两位数从10开始，三位数从100开始
    private static int beginNumberFor(int digits)
    {
        if (digits == 1)
            return 0;
        return (int) Math.pow(10, digits - 1);
    }
}
