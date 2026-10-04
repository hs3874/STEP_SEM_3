public class Q4 {
    public static void main(String[] args) {

        int[] nums = {3, 4, 6};
        int target = 20;

        int found = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    found = 1;
                }
            }
        }

        if (found == 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}