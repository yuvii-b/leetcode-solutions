class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, cnt1 = 0, cnt2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            if(ele1 == nums[i]) ++cnt1;
            else if(ele2 == nums[i]) ++cnt2;
            else if(cnt1 == 0){
                ele1 = nums[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0){
                ele2 = nums[i];
                cnt2 = 1;
            }
            else{
                --cnt1;
                --cnt2;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for(int i = 0; i < n; ++i){
            if(nums[i] == ele1) ++cnt1;
            else if(nums[i] == ele2) ++cnt2;
        }
        int expected = n / 3;
        if(cnt1 > expected) ans.add(ele1);
        if(cnt2 > expected) ans.add(ele2);
        return ans;
    }
}