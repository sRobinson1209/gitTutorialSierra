public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("The average is: " +
                average(numbers));
    }
    // Non-working average function (needs a fix)
    public static double average(int[] nums) {
        int sum = 0;
        for (int nums: num){
            sum += nums;
        }
        return (double) sum / (nums.length);
    }
}

