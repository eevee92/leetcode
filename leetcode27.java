// leetcode 27 Remove Element    
	public int removeElement(int[] nums, int val) {
        int count = 0;
        int i = 0;
        int j = nums.length-1;
        while(i<j)
        {
            while(nums[i]!=val && i<nums.length-1)  // 跳过不是３的，找到３的起点
            {
                i++;
                count++;
            }
            while(nums[j]==val && j>0 )//　找到不是３
                j--;
            
            if(i<j)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
                count++;
            }
        }
        if(i==j)
        {
            if(nums[i]!=val)
                count++;
        }
        System.out.println(count);
        return count;
    }
