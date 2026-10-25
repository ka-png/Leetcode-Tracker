class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxCount = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int start=0;
        for(int end=0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar,0) + 1);

            maxCount = Math.max(maxCount, freqMap.get(endChar));
            while(end-start+1-maxCount > k) {
                char startChar = s.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar)-1);
                start++;
            }
            maxLength = Math.max(end-start+1, maxLength);
        }
        return maxLength;
    }
}