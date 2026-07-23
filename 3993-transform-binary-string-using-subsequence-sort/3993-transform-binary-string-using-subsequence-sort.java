import java.util.*;

class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();

        ArrayList<Integer> posS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') posS.add(i);
        }

        int totalOnes = posS.size();
        boolean[] ans = new boolean[strs.length];

        for (int k = 0; k < strs.length; k++) {
            String t = strs[k];

            int fixedOnes = 0;
            ArrayList<Integer> qPos = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                char c = t.charAt(i);
                if (c == '1') fixedOnes++;
                else if (c == '?') qPos.add(i);
            }

            int need = totalOnes - fixedOnes;

            if (need < 0 || need > qPos.size()) {
                ans[k] = false;
                continue;
            }

            ArrayList<Integer> posT = new ArrayList<>();

            // Fixed 1's
            for (int i = 0; i < n; i++) {
                if (t.charAt(i) == '1') {
                    posT.add(i);
                }
            }

            // Put 1's in the LAST "need" question marks
            for (int i = qPos.size() - need; i < qPos.size(); i++) {
                if (i >= 0) posT.add(qPos.get(i));
            }

            Collections.sort(posT);

            boolean ok = true;
            for (int i = 0; i < totalOnes; i++) {
                if (posT.get(i) < posS.get(i)) {
                    ok = false;
                    break;
                }
            }

            ans[k] = ok;
        }

        return ans;
    }
}