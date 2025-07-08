import java.util.*;

public class MultipleArguments {
  public static void main(String[] args) {
    System.out.println(sumNumbers(2, 3, 4));
    System.out.println(sumNumbers(10));
    System.out.println(sumNumbers());

    System.out.println(findMax(5, 6, 4));
    System.out.println(findMax(-7, -5, 0));

    System.out.println(average(4, 6, 9));
    System.out.println(average(1, 5));
  }

  public static int sumNumbers(int... numbers) {
    int sum = 0;
    for (int n : numbers) {
      sum += n;
    }
    return sum;
  }

  public static int findMax(int... numbers) {
    if (numbers.length == 0) {
      throw new IllegalArgumentException("Array is empty!");
    }

    int max = Integer.MIN_VALUE;
    for (int n : numbers) {
      if (n > max) {
        max = n;
      }
    }
    return max;
  }

  public static double average(int... numbers) {
    if (numbers.length == 0) {
      throw new IllegalArgumentException("Array is empty!");
    }

    double sum = sumNumbers(numbers);
    return sum / numbers.length;
  }
}
