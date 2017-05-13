public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        MaxQueue maxQueue = new MaxQueue();
        for (int i = 0; i < k; i++) {
            maxQueue.offer(nums[i]);
        }
        for (int i = 0; i + k < nums.length; i++) {
            result[i] = maxQueue.getMax();
            maxQueue.offer(nums[i + k]);
            maxQueue.poll();
        }
        result[nums.length - k] = maxQueue.getMax();
        return result;
    }
}

class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> maxQueue;
    /** initialize your data structure here. */
    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }
    
    public void offer(int x) {
        queue.offer(x);
        while (!maxQueue.isEmpty() && x > maxQueue.peekLast()) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(x);
    }
    
    public void poll() {
        int x = queue.poll();
        if (x == maxQueue.getFirst()) {
            maxQueue.removeFirst();
        }
    }
    
    public int top() {
        return queue.peek();
    }
    
    public int getMax() {
        return maxQueue.getFirst();
    }
}
