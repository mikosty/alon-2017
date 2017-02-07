import java.util.Stack;
import java.util.HashMap;

public class Aita {
  public static void main(String[] args) {
    IO io = new IO();

    int n = io.nextInt();

    int[] aita = new int[n];
    HashMap<Integer, Integer> map = new HashMap();

    Stack<Integer> stack = new Stack();

    for (int i = 0; i<n; i++) {
      int number = io.nextInt();
      aita[i] = number;
    }

    int biggest = 0;

    for (int i = 0; i<n; i++) {
      if(stack.empty()) {
        stack.push(i);
      }
      else{
        int possNew = 0;
        int lautaCounter = 1;
        int viimenenRajTek = 0;
        while(aita[stack.peek()] > aita[i] ) {
          viimenenRajTek = stack.pop();
          lautaCounter++;
          if(stack.empty()) {
            stack.push(aita[i]);
            break;
          }
        }
        int possNew2 = aita[viimenenRajTek] * lautaCounter-1;
        possNew = lautaCounter * aita[i];
        if(possNew > possNew2) {
          if(possNew > biggest) {
            biggest =  possNew;
          }
        else {
          if(possNew2 > biggest) {
            biggest =  possNew2;
          }
        }
        }
      }
    }
    io.println(biggest);
    io.close();
  }


}
