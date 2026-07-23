import java.util.*;

class Solution {
   public int minimumGroups(String[] words) {
        HashSet<String> set = new HashSet<>();

        for (String w : words) {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 0; i < w.length(); i++) {
                if ((i & 1) == 0)
                    even.append(w.charAt(i));
                else
                    odd.append(w.charAt(i));
            }

            String key = minRotation(even.toString()) + "#" + minRotation(odd.toString());
            set.add(key);
        }

        return set.size();
    }

    private String minRotation(String s) {
        int n = s.length();
        if (n <= 1) return s;

        String ss = s + s;
        int i = 0, j = 1, k = 0;

        while (i < n && j < n && k < n) {
            char a = ss.charAt(i + k);
            char b = ss.charAt(j + k);

            if (a == b) {
                k++;
            } else if (a > b) {
                i = i + k + 1;
                if (i <= j) i = j + 1;
                k = 0;
            } else {
                j = j + k + 1;
                if (j <= i) j = i + 1;
                k = 0;
            }
        }

        int start = Math.min(i, j);
        return ss.substring(start, start + n);
    }
}