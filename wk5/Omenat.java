import java.util.Arrays;

public class Omenat {
  public static double pienin;
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    double[] nums = new double[n];

    for (int i = 0; i<n; i++) {
      nums[i] = io.nextDouble();
    }
    double[] sums = new double[3];
    Omenat.pienin = Double.MAX_VALUE;

    recurs(1, n, nums, nums[0], 0, 0, sums);
    recurs(1, n, nums, 0, nums[0], 0, sums);
    recurs(1, n, nums, 0, 0, nums[0], sums);

    io.println((int)Omenat.pienin);

    io.close();
  }
  public static void recurs(int i, int n, double[] nums, double a, double b, double c, double[] sums) {
    if(i == n) {
      sums[0] = a;
      sums[1] = b;
      sums[2] = c;
      Arrays.sort(sums);
      double erotus = sums[2]-sums[0];
      if(erotus < Omenat.pienin) {
        Omenat.pienin = erotus;
      }
    }
    else{
      recurs(i+1, n, nums, a+nums[i], b, c, sums);
      recurs(i+1, n, nums, a, b+nums[i], c, sums);
      recurs(i+1, n, nums, a, b, c+nums[i], sums);
    }
  }
}
