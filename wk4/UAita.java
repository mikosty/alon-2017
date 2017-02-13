public class UAita {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int[] aita = new int[n];
    int[][] nk = new int[220][n];

    for (int i = 0; i<n; i++) {
      aita[i] = io.nextInt();
    }

    for (int i = 0; i<n; i++) {
      int current = aita[i];

      //ensimmäinen lauta
      if(i == 0) {
        if(current == 0) {
          for (int j = 0; j < 200; j++) {
            nk[j][i] = 1;
          }
        }
        else {
          nk[current][i] = 1;
        }
        continue;
      }

      if(current==0) {
        if(aita[i-1]==1) {
          nk[2][i] = nk[1][i-1];
        }
        else if(aita[i-1] != 0) {
          nk[aita[i-1]-1][i] = nk[aita[i-1]][i-1];
          nk[aita[i-1]+1][i] = nk[aita[i-1]][i-1]; /// "!!!"
        }
        else {
          nk[1][i] = nk[2][i-1];
          for (int j = 2; j<200; j++) {
            nk[j][i] = (nk[j-1][i-1] + nk[j+1][i-1]) % 1000000007;
          }
        }
      }
      else {
        nk[current][i] = (nk[current-1][i-1] + nk[current+1][i-1]) % 1000000007;
      }


    }

    if(aita[n-1] != 0) {
      io.println(nk[aita[n-1]][n-1]);
      //io.println(nk[aita[n-1]-1][n-1]+nk[aita[n-1]+1][n-1]);
     }
    else {
      int sum = 0;
      for (int i = 0; i < 220; i++) {
        sum = (sum + nk[i][n-1]) % 1000000007;
      }
      io.println(sum);
    }

    io.close();
  }


}
