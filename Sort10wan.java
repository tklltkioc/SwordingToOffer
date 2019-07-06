package swordingTooffer;

import java.util.Arrays;

public class Sort10wan {

	public static void main(String[] args) {
	        int[] ages = new int[] { 23, 45, 32, 43, 21, 24, 25, 23, 22, 22, 21 };
	        System.out.println("原数组为：" + Arrays.toString(ages));
	        Sort10wan.sort(ages);
	        System.out.println("排序后的数组为：" + Arrays.toString(ages));
	    }
	 
	public static void sort(int []ages){
		int oldestAge=100;
		int []timesOfAges=new int[oldestAge];
		int len=ages.length;
		for(int i=0;i<len;i++){
			timesOfAges[ages[i]]++;;//新建额外数组，统计处于该年龄的人数
		}
 
		//依据年龄降序重新排序
		int index=0;
		for(int i=0;i<oldestAge;i++){
			for(int j=0;j<timesOfAges[i];j++){
				ages[index]=i;
				index++;
			}
		}
		
	}
}
