package 剑指;

public class ReplaceBlank {
	public static int replaceBlank(char[]string,int usedlength) {
		if(string==null||string.length<usedlength)
			return -1;
		int whiteCount=0;
		for (int i = 0; i < usedlength; i++) {
			if(string[i]==' ') {
				whiteCount++;
			}
		} 
		int targetLength=whiteCount*2+usedlength;
		int tmp=targetLength;
		if(targetLength>string.length) {
			return -1;
		}
		if(whiteCount==0) {
			return usedlength;
		}
		usedlength--;//指针p1,数组需要减一
		targetLength--;//指针p2
		while(usedlength>=0&&usedlength<targetLength) {
			if(string[usedlength]==' ') {
				string[targetLength--]='0';
				string[targetLength--]='2';
				string[targetLength--]='%';
			}else {
				string[targetLength--]=string[usedlength];
			}
			usedlength--;
		}
		
		return tmp;
		
	}
	
	public static void main(String[] args) {
		char[]a=new char[50];
		a[0]=' ';
        a[1] = 'e';
        a[2] = ' ';
        a[3] = ' ';
        a[4] = 'r';
        a[5] = 'e';
        a[6] = ' ';
        a[7] = ' ';
        a[8] = 'a';
        a[9] = ' ';
        a[10] = 'p';
        a[11] = ' ';
        int length=replaceBlank(a, 12);
        System.out.println(new String(a, 0, length));
	}

}
