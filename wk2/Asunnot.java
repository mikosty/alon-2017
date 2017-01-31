import java.util.*;

public class Asunnot {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int m = io.nextInt();

    TreeSet<Asunto> asunnot = new TreeSet<Asunto>(new hintaComp());
    TreeSet<Hakija> hakijat = new TreeSet<Hakija>(new hintaToiveComp());

    for (int i = 0; i < n ; i++ ) {
      double htoive = io.nextDouble();
      double ktoive = io.nextDouble();

      Hakija uus = new Hakija(htoive, ktoive, i);
      hakijat.add(uus);
    }

    for (int i = 0; i < m ; i++ ) {
      double hinta = io.nextDouble();
      double koko = io.nextDouble();

      Asunto uus = new Asunto(hinta, koko, i);
      asunnot.add(uus);
    }


    TreeSet<Asunto> tarjottavat = new TreeSet<Asunto>(new kokoComp());


    int annetut = 0;
    int i = 0;
    while (true) {
      if(hakijat.isEmpty() || (asunnot.isEmpty() && tarjottavat.isEmpty())) {
        break;
      }
      i++;
      Hakija h = hakijat.pollFirst();
      if(h == null) {
        break;
      }
      while(true) {
        if(asunnot.isEmpty()) {
          break;
        }
        Asunto mahd = asunnot.first();


        if(mahd.getH() <= h.getHtoive()) {
          tarjottavat.add(mahd);
          asunnot.pollFirst();
        }
        else {
          break;
        }
      }

      if(tarjottavat.isEmpty()) {
        continue;
      }
      Asunto tarjottava = tarjottavat.ceiling(new Asunto(1, h.getKt(), -1));
      if(tarjottava == null) {
        continue;
      }
      if(tarjottava.getK() >= h.getKt()) {
        annetut++;
        tarjottavat.remove(tarjottava);
      }
      else {
        tarjottavat.add(tarjottava);
        hakijat.add(h);
      }
    }

    io.println(annetut);
    io.close();
  }

}

class Hakija {
  private double htoive;
  private double ktoive;
  private int id;

  public Hakija(double htoive, double ktoive, int id) {
    this.htoive = htoive;
    this.ktoive = ktoive;
    this.id = id;
  }
  public double getHtoive() {
    return this.htoive;
  }
  public double getKt() {
    return ktoive;
  }
  public String toString() {
    return "hintatoive: " + this.htoive + " kokotoive: " + this.ktoive;
  }
  public int getId() {
    return this.id;
  }
}

class Asunto implements Comparable{
  private double hinta;
  private double koko;
  private int id;

  public Asunto(double hinta, double koko, int id) {
    this.hinta = hinta;
    this.koko = koko;
    this.id = id;
  }
  public double getH() {
    return this.hinta;
  }
  public double getK() {
    return this.koko;
  }
  public int getId() {
    return this.id;
  }
  @Override
  public boolean equals(Object a) {
    Asunto o = (Asunto) a;
    if(o.hashCode() == this.id) {
      return true;
    }
    return false;
  }
  @Override
  public int compareTo(Object a1) {
    Asunto a = (Asunto) a1;
    if(a.getId()== this.id) {
      return 0;
    }
    return 1;
  }
  @Override
  public int hashCode() {
    return this.id;
  }
  public String toString() {
    return "hinta: " + this.hinta + " koko: " + this.koko;
  }
}

class hintaComp implements Comparator<Asunto>{
    @Override
    public int compare(Asunto a1, Asunto a2) {
        if(a1.getH() < a2.getH()) return -1;
        if(a1.getH() > a2.getH()) return 1;
        if(a1.getId() == a2.getId()) {
          return 0;
        }
        else {
          return -1;
        }
    }
}
class hintaToiveComp implements Comparator<Hakija>{
    @Override
    public int compare(Hakija h1, Hakija h2) {
        if(h1.getHtoive() < h2.getHtoive()) return -1;
        if(h1.getHtoive() > h2.getHtoive()) return 1;
        if(h1.getId() == h2.getId()) {
          return 0;
        }
        else {
          return -1;
        }
    }
}

class kokoComp implements Comparator<Asunto>{
    @Override
    public int compare(Asunto a1, Asunto a2) {
      if(a1.getK() < a2.getK()) return -1;
      if(a1.getK() > a2.getK()) return 1;
      if(a1.getId() == a2.getId()) {
        return 0;
      }
      else {
        return -1;
      }
    }
}
