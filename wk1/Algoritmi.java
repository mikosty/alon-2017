public class Algoritmi {
  public static void main(String[] args) {
  	IO io = new IO();

  	long b = io.nextLong();

    while(true) {
      io.print(b + " ");

      if(b == 1) {
        break;
      }

      else if (b % 2 == 0) {
        b = b/2;
      }
      else {
        b = b*3+1;
      }
    }

  	io.close();
  }
}
