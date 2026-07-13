class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String main = "123456789";
        String l = String.valueOf(low), h = String.valueOf(high);
        for(int i = l.length(); i <= h.length(); ++i){
            for(int j = 0; j + i <= 9; ++j){
                int num = Integer.parseInt(main.substring(j, j + i));
                if(num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
}