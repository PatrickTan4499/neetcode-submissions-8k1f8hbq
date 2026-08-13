class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i< nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while(start < end) {

                int curSum = nums[i] + nums[start] + nums[end];
                if(curSum == 0) {
                    answer.add(Arrays.asList(nums[i],nums[start],nums[end]));
                                    while(start < end && nums[start] == nums[start+1]) {
                    start++;
                }
                while(start < end && nums[end] == nums[end-1]) {
                    end--;
                }
                    start++;
                    end--;
                } else if (curSum > 0) {
                    end--;
                } else {
                    start++;
                }
            }

        }
        return answer;
    }
}
