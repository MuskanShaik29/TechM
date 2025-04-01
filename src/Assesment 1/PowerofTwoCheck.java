public class PowerofTwoCheck {
    public static boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    public static void main(String[] args) {
        int num = 16; // Change this value to test

        if (isPowerOfTwo(num)) {
            System.out.println("Yes, it is a power of two");
        } else {
            System.out.println("No, it is not a power of two");
        }
    }
}
