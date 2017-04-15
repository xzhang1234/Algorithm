public class LFUCache {
    class Cache {
        int key;
        int freq;
        int time;
        public Cache (int k, int f, int t) {key = k; freq = f; time = t;}
        @Override
        public boolean equals(Object object) {return key==((Cache) object).key;}
        @Override
        public int hashCode() {return key;}
    }

    final int capacity;
    int currTime;
    Map<Integer, Integer> keyValuePair;
    Map<Integer, Integer> keyFreqPair;
    PriorityQueue<Cache> cacheQueue;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        currTime = 0;
        keyValuePair = new HashMap<>();
        keyFreqPair = new HashMap<>();
        cacheQueue = new PriorityQueue<>(capacity+1, new Comparator<Cache>(){
            @Override
            public int compare(Cache a, Cache b) {
                return a.freq == b.freq ? a.time - b.time : a.freq - b.freq;
            }
        });
    }
    
    public int get(int key) {
        currTime++;
        if (keyValuePair.containsKey(key)) {
            keyFreqPair.put(key, keyFreqPair.get(key) + 1);
            cacheQueue.remove(new Cache(key, 0, 0));
            cacheQueue.offer(new Cache(key, keyFreqPair.get(key), currTime));
        }
        return keyValuePair.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        currTime++;
        if (capacity == 0) return;
        if (keyValuePair.size() == capacity && !keyValuePair.containsKey(key)) {
            Cache leastFreqUsedCache = cacheQueue.poll();
            keyValuePair.remove(leastFreqUsedCache.key);
            keyFreqPair.remove(leastFreqUsedCache.key);
        }
        keyValuePair.put(key, value);
        keyFreqPair.put(key, keyFreqPair.getOrDefault(key, 0) + 1);
        cacheQueue.remove(new Cache(key, 0, 0));
        cacheQueue.offer(new Cache(key, keyFreqPair.get(key), currTime));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
