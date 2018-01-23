import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\nHello, Attendance App!\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome " + name + "!");

        ArrayList<Integer> absences = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < name.length(); i++) {
            int nums = rand.nextInt(11);
            absences.add(nums);
        }
        System.out.println("The elements are" + absences);
    }
}
