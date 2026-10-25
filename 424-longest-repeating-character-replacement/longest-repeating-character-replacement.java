class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxCount = 0;
        int start = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            countMap.put(endChar, countMap.getOrDefault(endChar, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(endChar));

            if (end - start + 1 - maxCount > k) {
                char startChar = s.charAt(start);
                countMap.put(startChar, countMap.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}