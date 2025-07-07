public class MultipleArguments {
  public static void main(String[] args) {
    System.out.println(sumNumbers(2, 3, 4));
    System.out.println(sumNumbers(10));
    System.out.println(sumNumbers());
  }

  public static int sumNumbers(int... numbers) {
    int sum = 0;
    for (int n : numbers) {
      sum += n;
    }
    return sum;
  }
}
