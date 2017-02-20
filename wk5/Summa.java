import java.util.HashMap;

public class Summa {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    double x = io.nextDouble();

    double[] numsOikea = new double[n/2];
    double[] numsVasen = new double[n/2];

    HashMap<Double, Integer> sums = new HashMap<>();

    for (int i = 0; i<n/2; i++) {
      numsVasen[i] = io.nextDouble();
    }

    for (int i = 0; i<n/2; i++) {
      numsOikea[i] = io.nextDouble();
    }

    // laske ekalle puoliskolle subsetsummien laskutapojen määrä
    for (int b = 0; b < (1<<n/2); b++) {
      double sum = 0;

      for (int i = 0; i<n/2; i++) {
        if((b&(1<<i)) > 0) {
          sum += numsOikea[i];
        }
      }
      if(!sums.containsKey(sum)) {
        sums.put(sum, 1);
      }
      else {
        sums.put(sum, sums.get(sum)+1);
      }
    }

    //kato toisesta puoliskosta subsetsummia ja tsekkaa hashmapista löytyykö vastine jotta summa = x
    int counter = 0;

    for (int b = 0; b < (1<<n/2); b++) {
      double sum = 0;

      for (int i = 0; i<n/2; i++) {
        if((b&(1<<i)) > 0) {
          sum += numsVasen[i];
        }
      }
      double etsittava = x-sum;
      if(sums.containsKey(etsittava)) {
        counter += sums.get(etsittava);
      }

    }

    io.println(counter);

    io.close();

  }
}
