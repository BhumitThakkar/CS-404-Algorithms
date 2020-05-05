import java.util.Scanner;

public class Main_for_Pb_13 {

   public static void main(String [] args) {

      System.out.println("\nProblem 13\n");
   
      System.out.println("The counterfeit coin is coin # " + counterfeit(1, 1));
      System.out.println();
      System.out.println();
      System.out.println("The counterfeit coin is coin # " + counterfeit(1, 3));
      System.out.println();
      System.out.println();
      System.out.println("The counterfeit coin is coin # " + counterfeit(1, 9));
      System.out.println();
      System.out.println();
      System.out.println("The counterfeit coin is coin # " + counterfeit(1, 27));
      System.out.println();
      System.out.println();
   }
   
   public static int balance(int low1, int high1, int low2, int high2) {

      Scanner kbd = new Scanner(System.in);

      System.out.print("Enter 1, 2, or 0:  ");
      return kbd.nextInt();
   }
   
   public static int counterfeit(int low, int high) {
      return low;
   }

}


