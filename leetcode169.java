// leetcode 169 Majority Element
        HashMap hashmap = new HashMap();
        for(int i : nums)
        {
            if(!hashmap.containsKey(i))
            {
                hashmap.put(i,1);
            }
            else
            {
                hashmap.put(i,1+(int)hashmap.get(i));
            }
        }
        int max = 0;
        int majority = 0;
        Iterator iter = hashmap.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry entry = (Map.Entry)iter.next();
            int value = (int)entry.getValue();
            if (value>max)
            {
                max = value;
                majority = (int)entry.getKey();
            }
        }
        return majority;        
    }
