public class test {
    public static boolean isPowerOf2(final int n) {
        if (n <= 0)
            return false;
        if ((n & (n-1)) == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
        };
        for (int num : nums) {
            boolean result = isPowerOf2(num);
            System.out.println("num " + num + (result ? " is a power of 2" : " is NOT a power of 2"));
        }
    }
}