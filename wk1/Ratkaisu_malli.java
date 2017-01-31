public class Ratkaisu {
  public static void main(String[] args) {
  	IO io = new IO();

  	int b = io.nextInt();


  	io.println(b);

  	io.close();
  }
  public static void algo(int n) {
    IO io = new IO();
    if (n % 2 == 0) {
      io.println(n);
      algo(n/2);
    }
    else {
      io.println(n);
      algo(n*3+1);
    }
  }
}
