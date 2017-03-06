
public class Unirytmi {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int m = io.nextInt();

    int[] sumT = new int[n+1];
    int sum = 1;
    int[] dp = new int[n+1];
    dp[1] = 1;
    sumT[1] = 1;

    int mo = 1000000007;

    for (int i = 2; i<n+1; i++) {

        if(i<=m) {
          dp[i] = (dp[i-1] * 2) % mo;
          sumT[i] = (sumT[i] + ((sum + dp[i]) % mo)) % mo;
          sum = (sum + dp[i]) % mo;
        }
        else {
          dp[i] = (sumT[i-1] - sumT[i-m-1]) % mo;
          sum = (sum + dp[i]) % mo;
          sumT[i] = (sum) % mo;
        }
    }

    if(dp[n] < 0) {
      io.println(dp[n] + mo);
    }
    else {
      io.println(dp[n]);
    }
    io.close();
  }


}
