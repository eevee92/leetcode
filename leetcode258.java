// leetcode 258 Add Digits
    public int addDigits(int num) {
        if(num/10==0)
            return num;
        int sum = 0;
        while(num/10 > 0)
        {
            int digit = num%10;
            sum += digit;
            if(sum>=10)
                sum = sum/10 + sum%10;
                
            num = num/10;
        }
	// 最后一个数字要单独处理
        sum += num;
        if(sum>=10)
            sum = sum/10+sum%10;
        return sum;
    }
