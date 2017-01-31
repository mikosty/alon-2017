import java.util.*;

public class Kolikot {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    double[] coins = new double[n];
    for (int i = 0; i < n; i++ ) {
      coins[i] = io.nextDouble();
    }
    Arrays.sort(coins);

    double number = 1;
    int index = 0;

    if(coins[index] > number) {
      io.println(String.format("%d",(long)number));
    }
    else {
      while(true) {

        if(index == n-1) {
          number = number + coins[index];
          break;
        }

        double nextToCheck = number + coins[index];

        if(nextToCheck < coins[index+1]) {
          number = nextToCheck;
          break;
        }
        else {
          number = nextToCheck;
          index++;
        }
      }
      io.println(String.format("%d",(long)number));
    }

    io.close();
  }
}
