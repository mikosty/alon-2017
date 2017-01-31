
public class Tilavuus {
  public static void main(String args[]) {
    IO io = new IO();

    double r = io.nextDouble();
    io.print(((double)4*Math.PI*Math.pow(r,3))/(double)3);
    io.close();
  }
}
