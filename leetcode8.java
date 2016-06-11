// leetcode 8 String to Integer (atoi)
    public int myAtoi(String str) 
    {
        if(str.isEmpty())
            return 0;
        if(str.length()==1 && str.charAt(0)=='+')
            return 0;
        if(str.length()==1 && str.charAt(0)=='-')
            return 0;
            
        int sign = 1;
        int start = 0;
        int end = str.length();
        
        while(str.charAt(start) == ' ' && start < str.length())
            start++;
        if( str.charAt(start) == '-')
        {
            sign = -1;
            start++;
        }
        else if( str.charAt(start) == '+')
        {
            sign = 1;
            start++;
        }
        
        if ( !(str.charAt(start)<='9' && str.charAt(start)>='0'))
            return 0;
            
        end = start;
        while(end < str.length())
        {
            if(str.charAt(end)!=' ' && str.charAt(end) <= '9' && str.charAt(end) >= '0' )
                end++;
            else break;
        }
        
        // 判断是否数据溢出
        String digit = str.substring(start,end);
        int result;
        try{
            result = sign*(Integer.parseInt(digit));
        }catch(NumberFormatException e)
        {
            if(sign==1)
                return Integer.MAX_VALUE;
            if(sign==-1)
                return Integer.MIN_VALUE;
        }
        return sign*(Integer.parseInt(digit));

    }
