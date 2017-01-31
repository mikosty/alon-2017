import java.util.*;
public class Maalaus {

  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int q = io.nextInt();

    Set<Interval> intervalLength = new TreeSet<Interval>(new intervalLengthComparator());
    Set<Interval> intervals = new TreeSe<Interval>(new intervalComparator());

    for (int i = 0; i < n ; i++ ) {
      int command = io.nextInt();
      int stick = io.nextInt();

      if(command == 1) {
        Interval newIn = new Interval(stick,stick,i);
        Interval findExisting = intervals.floor(newIn);
        if(findExisting == null) {
          set.add(newIn);
        }
        else {
          if(findExisting.getE() == stick+1 ) {
            intervals.remove(findExisting);
            Interval newActualIn = new Interval(findExisting.getB(), stick, i);
            intervals.add(newActualIn);
            intervalLength.add(newActualIn);

            Interval possibleCeil = intervals.ceil(newActualIn);

          }
        }
      }
    }
  }
}

class Interval {

  private begin;
  private end;
  private id;

  public Interval(int begin, int end, int id) {
    this.begin = begin;
    this.length = length;
  }

  public int getB() {
    return this.begin;
  }
  public int getE() {
    return this.end;
  }
  public int getL() {
    if(this.begin == this.end) {
      return 1;
    }
    else {
      return (this.end-this.begin)+1;
    }
  }

}

class intervalLengthComparator implements Comparator<Interval> {
  @Override
  public int compare(Interval i1, Interval i2) {
    return i1.getL().compareTo(i2.getL());
  }
}

class intervalComparator implements Comparator<Interval> {
  @Override
  public int compare(Interval i1, Interval i2) {
    return i1.getB().compareTo(i2.getB());
  }
}
