public class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> grayCodeN = new ArrayList<>();
        
        if (n == 0) {
            grayCodeN.add(0);
            return grayCodeN;
        }
        
        
        List<Integer> grayCodeNminus1 = new ArrayList<>();
        //n = 1 
        grayCodeN.add(0);
        grayCodeN.add(1);
        grayCodeNminus1.add(0);
        grayCodeNminus1.add(1);
        for(int i = 2; i <= n; i++) {
            //add grayCodeNminus1 to grayCodeN
            grayCodeN.clear();
            grayCodeN.addAll(grayCodeNminus1);
            for (int j = grayCodeNminus1.size() - 1; j >= 0; j--) {
                int newValue = grayCodeNminus1.get(j) | (1 << (i - 1));
                grayCodeN.add(newValue);
            }
            
            grayCodeNminus1.clear();
            grayCodeNminus1.addAll(grayCodeN);
        }
        return grayCodeN;
    
    }
}
