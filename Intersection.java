class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count > 0) {
                ans.add(num);
                map.put(num, count - 1);
            }
        }
        int[] ret = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            ret[i++] = num;
        }
        return ret;
    }
}