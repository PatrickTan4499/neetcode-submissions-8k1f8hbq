class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair<Integer, Integer>> pairList = new ArrayList<>();

        for(int i = 0; i< position.length; i++) {
            pairList.add(new Pair<>(position[i], speed[i]));
        }

        pairList.sort((a, b) -> Integer.compare(b.getKey(), a.getKey()));
        Stack<Double> stack = new Stack<>();

        for(Pair<Integer, Integer> pair : pairList) {
            double time = (double)(target - pair.getKey()) / pair.getValue();

            if(!stack.isEmpty() && time <= stack.peek()) {
                continue;
            } else {
            stack.push(time);
            }

        }

        return stack.size();
    }
}
