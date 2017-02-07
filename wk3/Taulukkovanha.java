import java.util.HashMap;

public class Taulukko {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int a = io.nextInt();
    int b = io.nextInt();

    int[] taulu = new int[n];
    boolean[] taulu_otettu = new boolean[n];

    for (int i = 0; i<n; i++) {
      taulu[i] = io.nextInt();
      taulu_otettu[i] = false;
    }

    int eka = 0;
    int toka = 0;

    int counterYli = 0;
    int counterAli = 0;

    HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();

    while(eka < n) {
      boolean ekaUpd = false;
      boolean tokaUpd = false;
      int number = taulu[0];
      if(toka < n) {
        number = taulu[toka];
      }

      System.out.println("eka: " + eka);
      System.out.println("toka: " + toka);


      System.out.println(number);
      System.out.println(nums);

      if(!taulu_otettu[toka]) {
        taulu_otettu[toka] = true;
        if(!nums.containsKey(number)) {
          nums.put(number, 1);
        }
        else {
          nums.put(number, nums.get(number)+1);
        }
      }

      int erikoisuus = nums.keySet().size();

      if(erikoisuus < a && toka != n-1) {
        toka++;
        continue;
      }
      if(erikoisuus < a && toka == n-1) {
        break;
      }

      if(erikoisuus > b) {
        number = taulu[eka];
        if(nums.get(number) == 1) {
          nums.remove(number);
        }
        else {
          nums.put(number, nums.get(number)-1);
        }
        eka++;
        continue;
      }
      else {
        counterAli++;
        if(toka !=n-1) {
          toka++;
          tokaUpd = true;
        }
        else {
          System.out.println(nums);
          System.out.println(eka+ " null");
          number = taulu[eka];
          if(nums.get(number) == 1) {
            nums.remove(number);
          }
          else {
            nums.put(number, nums.get(number)-1);
          }
          eka++;
          ekaUpd = true;
        }
      }

      if(erikoisuus > a) {
        counterYli++;
        counterAli++;
        if(toka != n-1 && !tokaUpd) {
          toka++;
        }
        else {
          if(!ekaUpd) {
            number = taulu[eka];
            if(nums.get(number) == 1) {
              nums.remove(number);
            }
            else {
              nums.put(number, nums.get(number)-1);
            }
            eka++;
          }
        }
      }


    }
    System.out.println(counterYli);
    System.out.println(counterAli);
    io.println(counterYli - counterAli);
    io.close();
  }
}
