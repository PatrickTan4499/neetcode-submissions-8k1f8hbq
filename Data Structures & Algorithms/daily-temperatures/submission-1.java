class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for ( int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek().getKey()) {
                Pair<Integer, Integer> pair = stack.pop();
                result[pair.getValue()] = i - pair.getValue();
            }
            stack.push(new Pair<>(temp, i));
        }
        return result;
    }
}
