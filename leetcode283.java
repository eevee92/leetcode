// leetcode 283 move zeroes
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==0)
            {
               int pos = i;
               while(pos+1<nums.length)
               {
                   int j = pos+1;
                   while(j<nums.length)
                   {
                       if(nums[j]==0)
                            j++;
                        else break;
                   }
                   // 上面while的结束有多种情况
                   // j++, j++ 一直到j=length, 即后面都是0,自然跳出循环
                   if(j==nums.length)
                        break;
                    
                   // j=length-1的时候，发现一个不是0，break;
                   // j<length-1, 发现一个不是0, break;
                   // 这时候,j 不会自加，不会越界，我们直接用就好
                   
                   int temp = nums[j];
                   nums[j] = nums[pos];
                   nums[pos] = temp;
                   pos = j;
                   if(j==nums.length-1)
                        break;
               }
            }
        }
    }
