import java.util.HashMap;

public class KolmenSumma2 {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();
    int x = io.nextInt();

    HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
    int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      int number = io.nextInt();
      array[i] = number;

      if(!nums.containsKey(number)) {
        nums.put(number, 1);
      }
      else {
        nums.put(number, nums.get(number)+1);
      }
    }

    System.out.println(nums);

    System.out.println(nums.containsKey(6));

    boolean found = false;
    for (int i = 0; i<n; i++) {
      for (int j = i+1; j<n ; j++) {
        System.out.println("i " + i + "j " + j);
        int twoSum = array[i] + array[j];
        System.out.println("twoSum " + twoSum);
        int toSearch = x - twoSum;
        System.out.println("toSearc " + toSearch);
        System.out.println(" ");
        if(nums.containsKey(toSearch)) {
          int thirdCount = nums.get(toSearch);
          if(toSearch == array[i] || toSearch == array[j]) {
            System.out.println("mitaa");
            if(nums.get(array[i]) == 1 || nums.get(array[j]) == 1) {
              continue;
            }
            else {
              System.out.println("Outoo");
              io.print(String.format("%d",(long)array[i]) + " " + String.format("%d",(long)array[j]) + " " + String.format("%d",(long)toSearch));
              found = true;
              break;
            }
          }
          else {
            io.print(String.format("%d",(long)array[i]) + " " + String.format("%d",(long)array[j]) + " " + String.format("%d",(long)toSearch));
            found = true;
            break;
          }
        }
      }
      if(found) {
        break;
      }
    }



    io.close();
  }
}
