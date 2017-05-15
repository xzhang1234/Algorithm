public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] heights2 = Arrays.copyOf(heights, heights.length + 1);
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxArea = 0;
        while (i < heights2.length){
            //right first <, left first <=
            if (s.isEmpty() || heights2[i] >= heights2[s.peek()]){
                s.push(i++);
            } else {
                int height = heights2[s.pop()];
                int area = s.isEmpty() ? height * i : height * (i - s.peek() - 1);
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }
}
