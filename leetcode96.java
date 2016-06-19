// leetcode 96
public class Solution {
    public int numTrees(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if(n==0 || n==1)
            return 1;
        list.add(new Integer(1));
        list.add(new Integer(1));
        for( int k = 2; k <= n; k++ )
        {
            int sum = 0;
            int i=0;
            int j=k-1;
            while(i<k)
            {
                sum += list.get(i).intValue() * list.get(j).intValue();
                i++;
                j--;
            }
            list.add( new Integer(sum) );
        }
        return list.get(n).intValue();    
    }
}
