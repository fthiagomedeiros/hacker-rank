import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] response = new int[] {0,0};

        Map<Integer, Integer> values = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            values.put(nums[index], index);
        }

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (values.containsKey(difference) && values.get(difference) != i) {
                response[0] = i;
                response[1] = values.get(difference);
                break;
            }
        }

        return response;
    }

}