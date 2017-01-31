import java.util.*;

public class Elokuvat {
  public static void main(String[] args) {
    IO io = new IO();
    TreeSet<Elokuva> set = new TreeSet();

    int n = io.nextInt();

    for (int i = 0; i < n ; i++) {
      long begins = io.nextLong();
      long ends = io.nextLong();
      Elokuva e = new Elokuva(begins, ends, i);
      set.add(e);
    }

    int counter = 1;

    Elokuva current = set.pollFirst();
    Elokuva temp = current;

    while(true) {

      if(current.getE() <= set.first().getB()) {
        counter++;
        current = set.pollFirst();
      }
      else {
        temp = set.pollFirst();
      }
      if(set.isEmpty()) {

        if(current.getE() <= temp.getB()) {
          counter++;
        }
        break;
      }


    }

    io.println(counter);
    io.close();
  }

}
class Elokuva implements Comparable {

  private long begins;
  private long ends;
  private int id;

  public Elokuva(long begins, long ends, int id) {
    this.begins = begins;
    this.ends = ends;
    this.id = id;
  }
  public long getE() {
    return this.ends;
  }
  public long getB() {
    return this.begins;
  }

  @Override
  public int compareTo(Object o) {
    Elokuva e = (Elokuva) o;

    if(this.ends < e.getE()) {
      return -1;
    }
    else if (this.ends == e.getE() && this.id == o.hashCode()) {
      return 0;
    }
    return 1;
  }
  public String toString() {
    return "b " + begins + " e: " + ends + " id: " + id;
  }

  @Override
  public boolean equals(Object obj)  {
    Elokuva e = (Elokuva) obj;

    if(obj.hashCode() == this.id) {
      return true;
    }
    return false;
  }
  @Override
  public int hashCode() {
    return id;
  }

}
