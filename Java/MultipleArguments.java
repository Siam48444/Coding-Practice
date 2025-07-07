public class MultipleArguments {
  public static void main(String[] args) {
    System.out.println(sumNumbers(2, 3, 4));
    System.out.println(sumNumbers(10));
    System.out.println(sumNumbers());

    System.out.println(findMax(5, 6, 4));
    System.out.println(findMax(-7, -5, 0));
  }

  public static int sumNumbers(int... numbers) {
    int sum = 0;
    for (int n : numbers) {
      sum += n;
    }
    return sum;
  }

  public static int findMax(int... numbers) {
    int max = Integer.MIN_VALUE;
    for (int n : numbers) {
      if (n > max) {
        max = n;
      }
    }
    return max;
  } 
}
