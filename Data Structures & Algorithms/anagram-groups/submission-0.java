class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        } else if (strs.length == 1) {
            return Arrays.asList(Arrays.asList(strs[0]));
        }
        boolean[] isChecked = new boolean[strs.length];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; ++i) {
            if (isChecked[i]) {
                continue;
            }
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; ++j) {
                if (isAnagram(strs[i], strs[j])) {
                    temp.add(strs[j]);
                    isChecked[j] = true;
                }
            }
            result.add(temp);
            isChecked[i] = true;
        }
        return result;
    }

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
