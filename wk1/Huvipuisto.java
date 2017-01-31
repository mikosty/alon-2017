import java.util.*;
public class Huvipuisto {
  public static void main(String args[]) {
    IO io = new IO();

    int n = io.nextInt();
    int x = io.nextInt();

    int[] kids = new int[n];

    for (int i = 0; i < n; i++) {
      kids[i] = io.nextInt();
    }
    Arrays.sort(kids);

    int baskets = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
      if(i + j ==n){
        break;
      }
      if(n-i-1 == j) {
        baskets++;
        break;
      }
      if(kids[n-i-1] + kids[j] <= x) {
        baskets++;
        j++;
      }
      else{
        baskets++;
      }
    }
    io.print(baskets);
    io.close();
  }
}
