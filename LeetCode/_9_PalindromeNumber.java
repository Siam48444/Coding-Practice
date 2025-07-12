class _9_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(27702));
    }


    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int lastDigit = x % 10;   // Get last digit of x
            reversedHalf = reversedHalf * 10 + lastDigit;   // Add last digit to reversedHalf
            x = x / 10;   // Remove last digit from x
        }

        // For even-length numbers: x == reversedHalf
        // For odd-length numbers: x == reversedHalf / 10 (middle digit doesn't matter)
        return (x == reversedHalf) || (x == reversedHalf / 10);
    }
}