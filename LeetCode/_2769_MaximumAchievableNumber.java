public class _2769_MaximumAchievableNumber {
    public static void main(String[] args) {
        System.out.println(theMaximumAchievableX(4, 1));
        System.out.println(theMaximumAchievableX(3, 2));
    }

    public static int theMaximumAchievableX(int num, int t) {
        if (t < 0) {
            return num;
        }

        return num + 2 * t;
    }
}