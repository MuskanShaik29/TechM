public class ReverseBits {
    public static void main(String[] args) {
        int num = 5; // Binary: 0000 0101
        int reversedNum = Integer.reverse(num) >>> (32 - 8); // Reverse and adjust for 8-bit
        
        System.out.println("Original Number: " + num);
        System.out.println("Reversed Binary: " + Integer.toBinaryString(reversedNum));
        System.out.println("Equivalent Decimal: " + reversedNum);
    }
}
