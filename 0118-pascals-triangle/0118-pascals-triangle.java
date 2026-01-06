class Solution {
    private List<Integer> generateRow(int row){
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(ans);
        for(int i = 1; i < row; ++i){
            ans = ans * (row - i);
            ans = ans / i;
            res.add(ans);
        }
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i = 1; i <= numRows; ++i){
            triangle.add(generateRow(i));
        }
        return triangle;
        // List<List<Integer>> triangle = new ArrayList();
        // for(int i = 0; i < numRows; ++i){
        //     List<Integer> row = new ArrayList();
        //     for(int j = 0; j <= i; ++j){
        //         if(j == 0 || j == i){
        //             row.add(1);
        //         }
        //         else{
        //             List<Integer> prev = triangle.get(i - 1);
        //             row.add(prev.get(j) + prev.get(j - 1));
        //         }
        //     }
        //     triangle.add(row);
        // }
        // return triangle;
    }
}