public class Main {
    public static void main (String[] args){
        int p = 3881;
        int q = 6359;

        // Calculate the product of p and q
        int n = p * q;

        // Create a number with the rightmost bit set to 1 and all other bits set to 0
        int m = 00001;

        // Determine the value of the 0th bit and 4th bit
        int bit0 = m & n;
        int bit4 = (m >> 4) & n;

        // Create a variable "mod" with a binary value of 11111 (in octal notation)
        int mod = 037;
        int modBinary = 11111;

        // Calculate the remainder of dividing n by mod and assign it to n
        n %= mod;

        // Print the value of n and its binary representation
        System.out.println("n = " + n + ", binary representation: " + Integer.toBinaryString(n));

        // Determine whether n is even or odd
        System.out.println(n % 2 == 0 ? "n is even" : "n is odd");

        // Calculate the xor of n and mod and assign it to "xor"
        int xor = n ^ mod;
        System.out.println(Integer.toBinaryString(xor));

        // find the value of the last four bits of xor
        int last4bits = xor & 1111; // method 1
        //int last4bits = xor % 16; // method 2
        System.out.println(last4bits);

        // print the value of the last four bits of xor
        System.out.print("The last four bits of xor are: ");
        switch (last4bits) {
            case 0x0:
                System.out.println("0000");
                break;
            case 0x1:
                System.out.println("0001");
                break;
            case 0x2:
                System.out.println("0010");
                break;
            case 0x3:
                System.out.println("0011");
                break;
            case 0x4:
                System.out.println("0100");
                break;
            case 0x5:
                System.out.println("0101");
                break;
            case 0x6:
                System.out.println("0110");
                break;
            case 0x7:
                System.out.println("0111");
                break;
            case 0x8:
                System.out.println("1000");
                break;
            case 0x9:
                System.out.println("1001");
                break;
            case 0xA:
                System.out.println("1010");
                break;
            case 0xB:
                System.out.println("1011");
                break;
            case 0xC:
                System.out.println("1100");
                break;
            case 0xD:
                System.out.println("1101");
                break;
            case 0xE:
                System.out.println("1110");
                break;
            case 0xF:
                System.out.println("1111");
                break;
        }

        // print the value of the last four bits of xor
        switch (last4bits) {
            case 0 -> System.out.println("Last four bits of XOR are 0000");
            case 1 -> System.out.println("Last four bits of XOR are 0001");
            case 2 -> System.out.println("Last four bits of XOR are 0010");
            case 3 -> System.out.println("Last four bits of XOR are 0011");
            case 4 -> System.out.println("Last four bits of XOR are 0100");
            case 5 -> System.out.println("Last four bits of XOR are 0101");
            case 6 -> System.out.println("Last four bits of XOR are 0110");
            case 7 -> System.out.println("Last four bits of XOR are 0111");
            case 8 -> System.out.println("Last four bits of XOR are 1000");
            case 9 -> System.out.println("Last four bits of XOR are 1001");
            case 10 -> System.out.println("Last four bits of XOR are 1010");
            case 11 -> System.out.println("Last four bits of XOR are 1011");
            case 12 -> System.out.println("Last four bits of XOR are 1100");
            case 13 -> System.out.println("Last four bits of XOR are 1101");
            case 14 -> System.out.println("Last four bits of XOR are 1110");
            case 15 -> System.out.println("Last four bits of XOR are 1111");
        }




    }
}
