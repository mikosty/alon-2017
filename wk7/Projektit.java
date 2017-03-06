import java.util.TreeSet;

public class Projektit {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();

    TreeSet<Projekti> alunMukaan = new TreeSet<>(new aComp());
    TreeSet<Projekti> lopunMukaan = new TreeSet<>(new bComp());

    for (int i = 0; i<n; i++) {
      int a = io.nextInt();
      int b = io.nextInt();
      int p = io.nextInt();

      Projekti uus = new Projekti(a,b,p);
      alunMukaan.add(uus);
      lopunMukaan.add(uus);
    }

    

    io.close();
  }


}

class Projekti {
  public int a;
  public int b;
  public int p;

  public Projekti(int a, int l, int p) {
    this.a = a;
    this.b = b;
    this.p = p;
  }

}

class aComp implements Comparator<Projekti> {
  @Override
  public int compare(Projekti p1, Projekti p2) {
    if(p1.a < p2.a) return -1;
    if(p1.a > p2.a) return 1;
    if(p1.a == p2.a) {
      return 0;
    }
    else {
      return -1;
    }
  }
}
class bComp implements Comparator<Projekti> {
  @Override
  public int compare(Projekti p1, Projekti p2) {
    if(p1.b < p2.b) return -1;
    if(p1.b > p2.b) return 1;
    if(p1.b == p2.b) {
      return 0;
    }
    else {
      return -1;
    }
  }
}
