public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] pathArr = path.split(" ");
            String dir = pathArr[0] + '/';
            for (int i = 1; i < pathArr.length; i++) {
                int start = pathArr[i].indexOf('(');
                String fileName = dir + pathArr[i].substring(0, start);
                String content = pathArr[i].substring(start + 1, pathArr[i].length() - 1);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fileName);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }
        return res;
    }
}