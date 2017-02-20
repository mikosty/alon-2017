import java.util.TreeSet;
import java.util.Arrays;

public class Omenat {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    double[] nums = new double[n];

    for (int i = 0; i<n; i++) {
      nums[i] = io.nextDouble();
    }
    TreeSet<Double> erotukset = new TreeSet<>();
    double[] sums = new double[3];
    double pienin = 1000000000;

    recurs(1, n, nums, nums[0], 0, 0, erotukset, sums, pienin);
    recurs(1, n, nums, 0, nums[0], 0, erotukset, sums, pienin);
    recurs(1, n, nums, 0, 0, nums[0], erotukset, sums, pienin);

    io.println((int)pienin);

    io.close();
  }
  public static void recurs(int i, int n, double[] nums, double a, double b, double c, TreeSet<Double> erotukset, double[] sums, double pienin) {
    if(i == n) {
      sums[0] = a;
      sums[1] = b;
      sums[2] = c;
      Arrays.sort(sums);
      double erotus = sums[2]-sums[0];
      System.out.println(erotus < pienin);
      if(erotus < pienin) {

        pienin = erotus;
        System.out.println(pienin);
      }
    }
    else{
      recurs(i+1, n, nums, a+nums[i], b, c, erotukset, sums, pienin);
      recurs(i+1, n, nums, a, b+nums[i], c, erotukset, sums, pienin);
      recurs(i+1, n, nums, a, b, c+nums[i], erotukset, sums, pienin);
    }
  }
}
