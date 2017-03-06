public class Kaverit {

  public static int[] visited;
  public static int[] friendSet;

  public static void main(String[] args) {
    IO io = new IO();

    int n = nextInt();

    int[][] table = new int[n][n];

    for (int i = 0; i<n; i++) {
      for (int j = 0; j<n; j++) {
        table[i][j] = io.nextInt();
      }
    }




    io.closet();
  }
}
