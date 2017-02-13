
public class Bittijono {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int[] d = new int[n];
    d[0] = 2;

    int m = (int) Math.pow(10, 9);
    if(n!=1) {
      d[1] = 4;
      for (int i = 2; i < n; i++) {
        d[i] = (d[i-2] + d[i-1])  % (m + 7);
      }
    }

    io.println(d[n-1]);
    io.close();
  }

}
