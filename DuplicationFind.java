package swordingTooffer;

public class DuplicationFind {
	    private int countRange(int[] array,int length, int start, int end) {
	        if (start < 0 || end > length-1) throw new IllegalArgumentException("Wrong Arguments");
	        int count = 0;
	        for (int i = 0; i < length; ++i) {
	            if (array[i] <= end && array[i] >= start) ++count;
	        }
	        return count;
	    }
	    public int returnOneDuplication(int[] array) {
	        if (array == null) throw new IllegalArgumentException("Wrong Arguments");
	        int length = array.length;
	        int start = 1;
	        int end = length - 1;
	        while (start <= end) {
	            int middle = ((end -start) >> 1) + start;
	            int count = countRange(array, length, start, middle);
	            if (start == end) {
	                if (count > 1) return start;
	                else break;
	            }
	            if (count > middle - start + 1) end = middle;
	            else start = middle + 1; //注意这个+1
	        }
	        return -1;
	    }
	    public static void main(String[] args) {
	    	DuplicationFind duplicationInArrayNotEdit = new DuplicationFind();
	        int[] Array = new int[]{2,3,5,4,3,2,6,7};
	        System.out.println(duplicationInArrayNotEdit.returnOneDuplication(Array));
	    }
	}
