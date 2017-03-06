
import java.util.Arrays;

public class Lampotila {
  public static int[] maSeg;
  public static int[] miSeg;

  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();

    int[] temps = new int[n];

    for (int i = 0; i<n; i++) {
      temps[i] = io.nextInt();
    }
    int N = roundToNearestP2(n);
    int segSize = (N * 2);

    maSeg = new int[segSize];
    miSeg = new int[segSize];

    int[] maxSeg = makeSeg(temps, true);
    int[] minSeg = makeSeg(temps, false);

    makeSegM(temps, 1, n-1, 0);






    System.out.println(Arrays.toString(temps));
    System.out.println(Arrays.toString(maxSeg));
    System.out.println(Arrays.toString(minSeg));


    int qN = io.nextInt();

    for (int i = 0; i<qN; i++) {
      int a = io.nextInt();
      int b = io.nextInt();

      a--;
      b--;

      io.print(q(minSeg, a, b, false, N) + " " + q(maxSeg, a, b, true, N) + "\n");
    }

    io.close();
  }

   public static int min(int a, int b, int k, int x, int y, int[] seg) {
     if (b < x || a > y) return Integer.MIN_VALUE;
     if (a <= x && y <= b) return seg[k];
     int d = (y+x)/2;
     return Math.min(min(a, b, 2*k, x, d, seg), min(a, b, 2*k+1, d+1, y, seg));
  }

  public static int q(int[] seg, int a, int b, boolean max, int N) {
    a += N;
    b += N;

    System.out.println(a + " a "  + b + " b " );


    int num = Integer.MAX_VALUE;
    if(max) {
      num = Integer.MIN_VALUE;
    }

    while(a <= b) {
      int temp = -1;
      if(a % 2 == 1) {
        if(max) {
          temp = a;
          a++;
          if(seg[temp] > num) {
            num = seg[temp];
            System.out.println(num);
          }
        }
        else {
          temp = a;
          a++;
          if(seg[temp] < num) {
            num = seg[temp];
            System.out.println(num);

          }
        }
      }
      if(b % 2 == 0) {
        if(max) {
          temp = b;
          b--;
          if(seg[temp] > num) {
            num = seg[temp];
            System.out.println(num);

          }
        }
        else {
          temp = b;
          b--;
          if(seg[temp] < num) {
            num = seg[temp];
            System.out.println(num);

          }
        }
      }
      a /= 2;
      b /= 2;
    }

    return num;
  }

  public static int makeSegM(int[] initial, int ss, int se, int si) {

    if(ss == se) {
      miSeg[si] = initial[ss];
      return initial[ss];
    }

    int mid = ss + (se - ss) / 2;
    miSeg[si] = Math.min(makeSegM(initial, ss, mid, si * 2), makeSegM(initial, mid+1, se, si*2+1));
    return miSeg[si];

  }

  public static int[] makeSeg(int[] initial, boolean maxSeg) {
    int segSize = (roundToNearestP2(initial.length) * 2) ;

    int[] seg = new int[segSize];

    for (int i = 0; i<initial.length; i++) {
      seg[i+(segSize/2)] = initial[i];
    }

    for (int i = segSize-1; i>2; i -=2) {
      if(maxSeg) {
        seg[(int) Math.floor(i/2)] = Math.max(seg[i-1], seg[i]);
      }
      else {
        seg[(int) Math.floor(i/2)] = Math.min(seg[i-1], seg[i]);
      }
    }
    return seg;
  }

  public static int roundToNearestP2(int x) {
    x = x - 1;
    x |= x >> 1;
    x |= x >> 2;
    x |= x >> 4;
    x |= x >> 8;
    x |= x >> 16;
    return x + 1;
  }
}
