package String;

public class Manachar {
	private static char specialChar = '$';
	public static char[] newString(String s) {
		char arr[] = new char[s.length()*2+1];
		for(int i=0;i<arr.length;i++) {
			if(i%2==0)
				arr[i] = specialChar;
			else
				arr[i] = s.charAt(i/2);
		}
		return arr;
	}
	public static int manachar(String s) {
		char newInput[] = newString(s);
		int T[] = new int[newInput.length];
		int start = 0;
        int end = 0;
        for(int i=0; i < newInput.length; ) {
            while(start >0 && end < newInput.length-1 && newInput[start-1] == newInput[end+1]) {
                start--;
                end++;
            }
            T[i] = end - start + 1;
            if(end == T.length -1) {
                break;
            }
            int newCenter = end + (i%2 ==0 ? 1 : 0);
            for(int j = i + 1; j <= end; j++) {
                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                if(j + T[i - (j - i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            i = newCenter;
            end = i + T[i]/2;
            start = i - T[i]/2;            
        }
        int max = Integer.MIN_VALUE;
        int val;
        for(int i = 0; i < T.length; i++) {
            val = T[i]/2;
            if(max < T[i]/2) {
                max = val;
            }
        }
        return max;
	}
	public static void main(String args[]) {
		System.out.println(manachar("happyyppa"));
	}
}
