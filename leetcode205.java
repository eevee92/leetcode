// leetcode 205
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if( s.length()==0 || t.length()==0 )
            return true;
        if( s.length() != t.length() )
            return false;
        Map map = new HashMap();
        Set unique = new HashSet();
        
        for(int i=0; i<s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                if( (char)map.get(s.charAt(i)) != t.charAt(i) )
                    return false;
            }
            else
            {
                if(unique.contains(t.charAt(i)))
                    return false;
                else
                {
                    unique.add(t.charAt(i));
                    map.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }
}
