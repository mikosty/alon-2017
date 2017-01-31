public class Entry implements Comparable {
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

    if((e.getF().equals(this.firstName))) {
      return this.surname.compareTo(e.getS());
    }
    return this.firstName.compareTo(e.getF());
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.surname + " " + this.number;
  }
}
