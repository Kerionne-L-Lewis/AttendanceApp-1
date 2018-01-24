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

        int few =fewerAbsencesSum(absences);
        double pct = percentage(few);
        System.out.println("The percentage of students who have fewer than 3 absences " + pct);

        ArrayList<Integer> studentIndex=indexOfAbsence(absences);
        System.out.println("List of Student indexes with 1 absence "+ studentIndex);
    }

    private static ArrayList indexOfAbsence(ArrayList<Integer> absences) {
        ArrayList<Integer>listIndexes=new ArrayList<>();
        int stdIndex=0;
        for (int i = 0; i <absences.size() ; i++) {
            if (absences.get(i) == 1) {
                stdIndex = i;
                listIndexes.add(stdIndex);
            }
        }
        return listIndexes;
    }

    private static int fewerAbsencesSum(ArrayList<Integer> absences) {
        int sum=0;
        for (int i = 0; i <absences.size() ; i++) {
            if (absences.get(i)<3){
                sum=absences.get(i)+sum;
            }
        }
        return sum;
    }

    private static double percentage(int few) {
        double percentage =(few*100) /few;
        return percentage;
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

