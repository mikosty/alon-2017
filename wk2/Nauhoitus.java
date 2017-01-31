public class Nauhoitus {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int k = io.nextInt();



    for (int i = 0; i < 0 ; i++) {

    }
  }
}

class Ohjelma {
  private long begin;
  private long end;
  private int id;

  public Ohjelma(long begin, long end, int id) {
    this.begin = begin;
    this.end = end;
    this.id = id;
  }
  public long getB() {
    return this.begin;
  }
  public long getE() {
    return this.end;
  }
  public int getId() {
    return this.id;
  }
}
