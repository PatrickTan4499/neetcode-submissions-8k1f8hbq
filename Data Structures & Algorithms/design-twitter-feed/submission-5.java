class Twitter {
    int count;
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        this.count = 0;
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        followerMap.putIfAbsent(userId, new HashSet<>());
        followerMap.get(userId).add(userId);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        for(int followed : followerMap.get(userId)) {
            if(tweetMap.containsKey(followed)) {
            List<int[]> tweets = tweetMap.get(followed);

            for(int[] tweet : tweets) {
                minHeap.offer(new int[]{tweet[0], tweet[1], followed, tweets.size()-1});

                if(minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
            }
        }

        LinkedList<Integer> answer = new LinkedList<>();
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            answer.addFirst(curr[1]);
        }
        return answer;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.get(followerId) != null) {
            if(followerMap.get(followerId).contains(followeeId)) {
                followerMap.get(followerId).remove(followeeId);
            }
        }
    }
}
