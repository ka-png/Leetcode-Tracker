class Solution {
    public int rob(int[] nums) {
        int rob1 = 0; // Max money up to house i-2
        int rob2 = 0; // Max money up to house i-1

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}   