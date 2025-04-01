public class IntegerCompression {
    
    public static int encode(int num) {
        return (num << 1) ^ (num >> 31); 
    }

   
    public static int decode(int encodedNum) {
        return (encodedNum >>> 1) ^ -(encodedNum & 1);
    }

    public static void main(String[] args) {
        int original = 12345;  // Example number
        int encoded = encode(original);
        int decoded = decode(encoded);
        System.out.println("Original: " + original);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
    }
}

    

