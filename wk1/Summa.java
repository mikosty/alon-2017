public class Summa {
  public static void main(String args[]) {
    IO io = new IO();

    long n = io.nextLong();
    long sum = 0;
    for(int i = 0; i < n; i++) {
      long ith = io.nextLong();
      sum += ith;
      io.print(sum + " ");
    }
    io.close();
  }
}
