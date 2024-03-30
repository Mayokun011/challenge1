import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTriplets {
    public List<List<Integer>>
    findUniqueTriplets(int[] nums, int target) {
        Arrays.sort(nums);
     List<List<Integer>> triplets = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];
            if (currentSum == target) { triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    return triplets;
}
public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    int target = 0; UniqueTriplets uniqueTriplets = new UniqueTriplets();
    List<List<Integer>> result = uniqueTriplets.findUniqueTriplets(nums, target);
    for (List<Integer> triplet : result) {
        System.out.println(triplet);
       }
   }

}

