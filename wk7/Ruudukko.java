import java.util.Arrays;

public class Ruudukko {

  public static String[] ruud;
  public static int[][] dp;
  public static int n;
  public static int m;

  public static void main(String[] args) {
    IO io = new IO();

    n = io.nextInt();
    m = io.nextInt();

    ruud = new String[n];
    dp = new int[n][m];

    for (int i = 0; i<n; i++) {
      String rivi = io.next();
      ruud[i] = rivi;
    }
    boolean zero = false;
    if(ruud[0].charAt(0) == '*') {
      zero = true;
    }
    dp[0][0] = 1;

    for (int i = 0; i<n; i++) {
      for (int j = 0; j<m; j++) {

        int routes = 0;
        if(ruud[i].charAt(j) == '.') {
          if(legit(i-1, j)) {
            routes += (dp[i-1][j]) % 1000000007;
          }
          if(legit(i, j-1)) {
            routes += (dp[i][j-1]) % 1000000007;
          }
          if((i==0) && (j==0)) {
            routes = 1;
          }
          dp[i][j] = routes;
          continue;
        }
        dp[i][j] = 0;
      }
    }



    if(zero) {
      io.println(0);
    }
    else {
      io.println(dp[n-1][m-1] % 1000000007);
    }



    io.close();

  }

  public static void recu(int i, int j) {
    if(!legit(i, j)) {
      return;
    }
    else {
      int routes = 0;
      if(ruud[i].charAt(j) == '.') {
        if(legit(i-1, j)) {
          routes += (dp[i-1][j] % 1000007);
        }
        if(legit(i, j-1)) {
          routes += (dp[i][j-1] % 1000007);
        }
        dp[i][j] = routes;
      }
      else {
        dp[i][j] = 0;
      }
      recu(i, j+1);
      recu(i+1, j);
    }
  }

  public static boolean legit(int i, int j) {
    if((j < 0) ||(i < 0) || (i > n-1) || (j > m-1))  {
       return false;
    }
    return true;
  }
}
