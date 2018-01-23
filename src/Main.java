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

        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 0) {
                count++;
            }
        }
        System.out.println("There are " + count + " number of students with perfect attendance");


        int sum = sumAbsences(absences);

        double avg = average(absences, sum);
        System.out.println("The Average is " + avg);

    }

    private static int sumAbsences(ArrayList<Integer> absences) {
        int sum = 0;
        for (int i = 0; i < absences.size(); i++) {
            sum = absences.get(i) + sum;
        }
        return sum;
    }

    private static double average(ArrayList<Integer> absences, int sum) {
        double avg = (double) sum / absences.size();
        return avg;
    }
}

