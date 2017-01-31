import java.util.*;

public class Puhelinluettelo {
  public static void main(String args[]) {
    IO io = new IO();

    int n = io.nextInt();

    List<Entry> luettelo = new ArrayList();


    for(int i = 0; i < n; i++) {
      String first = io.next();
      String surname =  io.next();
      String number = io.next();
      Entry new_entry = new Entry(first, surname, number);
      luettelo.add(new_entry);
    }
    Collections.sort(luettelo);

    for (Entry e : luettelo ) {
      io.println(e);
    }

    io.close();
  }
}

class Entry implements Comparable {
  private String firstName;
  private String surname;
  private String number;

  public Entry(String firstName, String surname, String number) {
    this.firstName = firstName;
    this.surname = surname;
    this.number = number;
  }

  public String getF(){
    return this.firstName;
  }
  public String getS(){
    return this.surname;
  }


  @Override
  public int compareTo(Object o) {

    Entry e = (Entry) o;

    if((e.getS().equals(this.surname))) {
      return this.firstName.compareTo(e.getF());
    }
    return this.surname.compareTo(e.getS());
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.surname + " " + this.number;
  }
}
