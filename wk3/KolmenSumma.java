import java.util.Arrays;

public class KolmenSumma {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    double x = io.nextDouble();

    double[] arra = new double[n];

    for (int i = 0; i < n; i++) {
      arra[i] = io.nextDouble();
    }


    Arrays.sort(arra);


    System.out.println(Arrays.toString(arra));

    boolean found = false;
    double twoSum = 0;
    double tempSum = 0;

    int i = 0;
    int endPoint = n-1;

    boolean bfirst = false;

    while (i<endPoint) {
      System.out.println(i + " " + endPoint);

      twoSum = arra[i]+arra[endPoint];

      double toSearch = x - twoSum;



      int a = i+1;
      int end = endPoint-1;

      while(a <= end) {
        int k = (a+end) / 2;
        System.out.println(arra[i]+ " " + arra[endPoint]+ " "+arra[k]);
        if(arra[i]+arra[endPoint]+arra[k] == x) {
          io.print(String.format("%d",(long)arra[i]) + " " + String.format("%d",(long)arra[k]) + " " + String.format("%d",(long)arra[endPoint]));
          found = true;
          break;
        }
        if(arra[i]+arra[endPoint]+arra[k]>x) {
          end = k-1;
        }
        else {
          a = k+1;
        }
      }
      if(found) {
        break;
      }

      if(toSearch > twoSum) {
        i++;
      }
      else if (toSearch < twoSum) {
        endPoint--;
      }
      //double endMinusSum = arra[i] + arra[endPoint-1];
      //double beginPlusSum = arra[i+1] + arra[endPoint];




    }
    io.close();
  }
}
