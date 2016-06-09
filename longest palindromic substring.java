//Longest Palindromic Substring

/*________________________________________________*/
// naieve solution
	public String longestPalindrome(String s) {
        int maxlength = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for(int i=0; i<s.length()+1; i++)
        {
            for(int j=i; j<s.length()+1; j++)
            {
                String str = s.substring(i,j);
                int judge = isPalindrome(str);
                if(judge > maxlength)
                {
                    maxlength = judge;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxStart,maxEnd);
    }
    private int isPalindrome(String s)
    {
        int compareTimes = s.length()/2;
        for(int k=0; k<compareTimes; k++)
        {
            if( (s.charAt(k) != (s.charAt(s.length()-1-k))) )
                return -1;
        }
        return s.length();
    }

/*________________________________________________*/
//  solution 2-1:　　center method
    public String longestPalindrome(String s) {
    	if(s.equals(""))
            return "";
        if(s.length()==1 || (s.length()==2&&(s.charAt(0)==s.charAt(1))))
        	return s;
		// 以下是对s.length()>=3的分析
        int maxlength = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for(int i=1; i<s.length()-1; i++)
        {
            int center = i;
            int left = i-1;
            int right = i+1;
            int count = 1;
            while( left>=0 && s.charAt(left)==s.charAt(center) )
            {
                left--;
                count++;
            }
            while( right <= s.length()-1 && s.charAt(right)==s.charAt(center) )
            {
                right++;
                count++;
            }
            if (count > maxlength)
            {
                maxlength = count;
                maxStart = left+1;
                maxEnd = right-1;
            }
            // 以上是相同字符左右扩展移动了之后得到的maxlength,以及maxStart maxEnd
            
            // 以下是两边字符左右扩展移动得到的
            int flag = 0;
            while( left >= 0 && right <= s.length()-1 )
            {
                if( s.charAt(left) == s.charAt(right) )
                {
                    count += 2;
                    left--;
                    right++;
                }
                else
                    break;
            }
            if(count > maxlength)
            {
                maxlength = count;
                maxStart = left+1;
                maxEnd = right-1;
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }

/*________________________________________________*/
//  solution 2-2 center method 的精简版
    public String longestPalindrome(String s) {
    	if(s.isEmpty())
    		return "";
    	if(s.length()==1)
    		return s;
    	int maxlength = 1;
    	String longestPalindrome = "";
    	for(int i=0; i<s.length(); i++)
    	{
    		String palindromeOdd = findPalindrome(s,i,i);
    		if(palindromeOdd.length() > maxlength)
    		{
    			maxlength = palindromeOdd.length();
    			longestPalindrome = palindromeOdd;
    		}
    		String palindromeEven = findPalindrome(s,i,i+1);
    		if(palindromeEven.length() > maxlength)
    		{
    			maxlength = palindromeEven.length();
    			longestPalindrome = palindromeEven;
    		}
    	}
    	return longestPalindrome;
    }
    private String findPalindrome(String s, int begin, int end)
    {
    	while( begin>=0 && end <=s.length()-1 && (s.charAt(begin)==s.charAt(end)) )
    	{
    		begin--;
    		end++;
    	}
    	return s.substring(begin+1, end);
    }

