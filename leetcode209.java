// leetcode 209

// 方法１
public class Solution {
    public boolean wordPattern(String pattern, String str) {
     String[] strs = str.split(" ");
     if((pattern.length()==0 || strs.length==0) || (pattern.length() != strs.length))
        return false;
    Map<Character, String> map = new HashMap<Character, String>();
    
    Set<String> unique = new HashSet<String>();
    
    for(int i=0; i<pattern.length(); i++)
    {
        Character ch = new Character(pattern.charAt(i));
        if(map.containsKey(ch))
        {
            if( !map.get(ch).equals(strs[i]) )
                return false;
        }
        else
        {
            if(unique.contains(strs[i]))
                return false;
            else
            {
                map.put(ch, strs[i]);
                unique.add(strs[i]);
            }
        }
    }
    return true;
    }
}

// 方法２
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] strs = str.split(" ");
        if(pattern.length() == 0 || str.length() == 0)
            return false;
        if(p.length != strs.length)
            return false;
        
        Map<Character,ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        for(int i=0; i<pattern.length(); i++)
        {
            Character key = new Character(pattern.charAt(i));
            if(map.containsKey(key))
            {
                ArrayList list = map.get(key);
                list.add(new Integer(i));
                map.put(key,list);
            }
            else
            {
                 ArrayList list = new ArrayList();
                 list.add(new Integer(i));
                 map.put(key, list);
            }
        }

        // 用作后面检查map对应位置的str是不是不同的
        ArrayList<String>  map2String = new ArrayList<String>();

        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character)entry.getKey();
            List<Integer> val = (ArrayList<Integer>)entry.getValue();
            map2String.add(strs[val.get(0).intValue()]);
            for(int i=0; i<val.size()-1; i++)
            {
                if(! strs[val.get(i).intValue()].equals(strs[val.get(i+1).intValue()]) )
                return false;
            }
        }
        
        // 检查是否出现　"abba","dog dog dog dog"的情况
        for(int i=0; i<map2String.size()-1; i++)
        {
            if(map2String.get(i).equals(map2String.get(i+1)))
                return false;
        }
        return true;
    }
}
