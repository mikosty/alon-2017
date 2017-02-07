import java.util.TreeSet;

public class Iltalypsy {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int m = io.nextInt();

    TreeSet<Integer> set = new TreeSet<Integer>();

    int smallestByI = 1;

    for (int i = 1; i < m+1 ; i++ ) {
      int arC = io.nextInt();
      set.add(arC);
      for(int j = smallestByI; j < n; j++) {
        if(!set.contains(j)) {
          io.print(j);
          io.print(" ");
          smallestByI = j;
          break;
        }
      }
    }

    io.close();
  }
}
