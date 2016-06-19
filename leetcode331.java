// leetcode 331
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length()==0)
            return false;
        String target = ",#,#";
        String str = new String(preorder);
        while(str.indexOf(target) > 0)
        {
            int pos = str.indexOf(target);
            if(str.charAt(pos-1)=='#')
                return false;
						//　从后往前找到前一个','
            int j = pos-1;
            while(str.charAt(j) != ',' && j>0 )   // 这里，跳出while循环有两个情况，　一个是直到j==0都没有发现前面有',' ，另一个是找到了前一个','
                j--;
            
            String newStr = "";
            if(j!=0)   // 前面是有','的情况
                newStr = str.substring(0,j+1) + "#" + str.substring(pos+4,str.length());
            else			//  前面没有','的情况
                newStr = "#" + str.substring(pos+4, str.length()); 
            str = newStr;
        }
        if(str.length()==1 && str.charAt(0)=='#')
            return true;
        else
            return false;
    }
}
