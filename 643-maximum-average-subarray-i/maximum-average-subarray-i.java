class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double currAvg=0, maxAvg=0;
        for(int i=0; i<k; i++) {
            currAvg += nums[i];
        }
        currAvg = (currAvg)/k;
        maxAvg = currAvg;

        for(int i=k; i<n; i++) {
            currAvg = currAvg*k;
            currAvg = currAvg - nums[i-k] + nums[i];
            currAvg = (currAvg)/k;

            maxAvg = Math.max(maxAvg, currAvg);
        }
        return maxAvg;
    }
}