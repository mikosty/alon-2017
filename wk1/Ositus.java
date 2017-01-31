public class Ositus {
  public static void main(String[] main) {
    IO io = new IO();

    int n = io.nextInt();
    int k = io.nextInt();

    long[] nums = new long[n];

    long upper_bound = 0;
    //long[] test = {80, 67, 38, 68, 88, 11, 82, 18, 70, 48};
    //System.out.println(sumPossible(218,test,3) + " s");
    for (int i = 0; i < n; i++) {
      nums[i] = io.nextLong();
    }

    upper_bound = Long.MAX_VALUE;

    long x = -1;

    for (long b = upper_bound; b >= 1; b = b/2) {
      while(!sumPossible(x+b,nums,k)) {
        x+= b;
      }
    }

    io.print(x +1);
    io.close();
  }

  public static boolean sumPossible(long x, long[] nums, int k) {
    int splits = 0;
    long split_sum = 0;

    for (int i = 0; i < nums.length; i++) {

      if(nums[i] > x) {
        return false;
      }

      if(split_sum + nums[i] <= x) {
        split_sum += nums[i];
      }
      else {
        splits++;

        split_sum = nums[i];
      }

    }
    if(splits > k-1) {

      return false;
    }
    return true;
  }
}
