public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(LongestPrefix(new String[]{"geek","geezer","geef","gelo"}));
        
    }
    public static String LongestPrefix(String arr[]) {
        return LongestPrefix(arr,0,arr.length-1);
    }
    private static String LongestPrefix(String arr[],int low,int high) {
        if(high==low) return arr[high];
        return longestMatch(LongestPrefix(arr,low,(low+high)/2),LongestPrefix(arr,(low+high)/2+1,high));
    }
    private static String longestMatch(String s1,String s2) {
        StringBuilder s = new StringBuilder("");
        int l = Math.min(s1.length(),s2.length());
        for(int i=0;i<l;i++) {
            if(s1.charAt(i)==s2.charAt(i)) {
                s.append(s1.charAt(i));
            }else {
                break;
            }
        }
        return s.toString();
    }
    
}