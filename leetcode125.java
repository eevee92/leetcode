//leetcode 125
// 以下解法在输入特别长的字符串的时候会超时

public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0)
            return true;
        
        
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            if( !Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)) )
                count++;
        }
        if(count==s.length()) // 纯标点的情况　',.' 或者'.'
            return true;
        
        int i = 0;
        int j = s.length()-1;
        while(i < j)
        {
            while(!Character.isLetter( s.charAt(i) ) && !Character.isDigit( s.charAt(i) ))
                i++;
            while(!Character.isLetter( s.charAt(j) ) && !Character.isDigit( s.charAt(j) ))
                j--;
            if(s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j))
                return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
    
}
