import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class Merkkijonot {
  public static void main(String[] args) {
  IO io = new IO();

  String string = io.next();

  char[] merkit = string.toCharArray();
  Arrays.sort(merkit);

  int[] merkkiCount = new int[130];

  double nFactorial = 1;

  for (int i = 0; i<merkit.length; i++) {
    merkkiCount[merkit[i]]++;
    nFactorial *= i+1;
  }

  double divisor = 1;

  for (int i = 0; i<merkkiCount.length; i++) {
    if(merkkiCount[i]>0) {
      double temp = 1;
      for (int j = 1; j <= merkkiCount[i]; j++) {
        temp *= j;
      }
      divisor *= temp;
    }
  }

  io.println((int) (nFactorial / divisor));

  recurs(merkit, 0, new ArrayList<Character>(), string.length(), io, new boolean[merkit.length], new HashSet<Integer>());


  io.close();
  }
  public static void recurs(char[] merkit, int k, ArrayList<Character> v, int n, IO io, boolean[] p, HashSet<Integer> printed) {

    if(v.size() == n) {
      String outP = "";
      for (Character c : v) {
        outP += c;
      }
      if(!printed.contains(outP.hashCode())) {
        printed.add(outP.hashCode());
        io.println(outP);
      }
    }
    else {
      for (int i = 0; i<n; i++) {
        if(p[i]) {
          continue;
        }

        p[i] = true;
        v.add(merkit[i]);
        recurs(merkit, i, v, n, io, p, printed);
        p[i] = false;
        v.remove(v.size()-1);
      }
    }
  }
}
