class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE, n = nums.length;
        for(int i = 0; i < n; ++i){
            if(cnt1 == 0 && nums[i] != ele2){
                cnt1 = 1;
                ele1 = nums[i];
            }else if(cnt2 == 0 && nums[i] != ele1){
                cnt2 = 1;
                ele2 = nums[i];
            }else if(nums[i] == ele1) ++cnt1;
            else if(nums[i] == ele2) ++cnt2;
            else{
                --cnt1;
                --cnt2;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for(int i = 0; i < n; ++i){
            if(nums[i] == ele1) ++cnt1;
            if(nums[i] == ele2) ++cnt2;
        }
        int expected = n / 3 + 1;
        if(cnt1 >= expected) res.add(ele1);
        if(cnt2 >= expected && ele1 != ele2) res.add(ele2);
        return res;
    }
}