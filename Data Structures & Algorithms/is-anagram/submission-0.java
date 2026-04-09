class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charArray1 = countExistences(s);
        int[] charArray2 = countExistences(t);

        return compareTwoString(charArray1, charArray2);
    }

    public boolean compareTwoString(int[] s, int[] d) {
        for (int i = 0; i < 26; ++i) {
            if (s[i] != d[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] countExistences(String s) {
        int[] charArray = new int[26];
        char letterA = 'a';
        for (int i = 0; i < s.length(); ++i) {
            charArray[s.charAt(i) - letterA]++;
        }
        return charArray;
    }
}
