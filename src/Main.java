import java.util.ArrayList;
import java.util.Collections;
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

        double avg = average(absences);
        System.out.println("The Average is " + avg);

        int few = fewerAbsencesSum(absences, 3);
        double pct = percentage(absences);
        System.out.println("The percentage of students who have fewer than 3 absences " + pct);

        ArrayList<Integer> studentIndex = indexOfAbsence(absences, 1);
        System.out.println("List of Student indexes with 1 absence " + studentIndex);

        System.out.print("How many times does the course meet per week? ");
        ArrayList<Integer> indexFe = moreThanAbsences(absences);
        System.out.println("List of index of students with twice or more absences" + indexFe);
        double fePercentage = percentageOfFe(indexFe);
        System.out.printf("There are %.2f%% of students who FE the course", fePercentage);

        System.out.println("\nHow many times does the course meet per week? ");
        ArrayList<Integer> indexOfNonFe = nonFeAbsences(absences);


        double avgNonFe = nonFeAverage(indexOfNonFe);
        System.out.println("The list of students who did not FE the course" + indexFe +
                "\n Here is the average of that list " + avgNonFe);

       ArrayList<Integer> changeList= addToAbsences(absences);
        System.out.println("This is the changed List "+ changeList);

        Collections.sort(changeList);
        System.out.println("Sorted List " + changeList);

        Collections.shuffle(changeList);
        System.out.println("Shuffled List"+ changeList);

    }

    private static ArrayList<Integer> addToAbsences(ArrayList<Integer> absences) {
        for (int i = 0; i <absences.size() ; i++) {
            if (absences.get(i)>absences.get(0)){
                absences.set(i, absences.get(i)+ -3);
                if (absences.get(i)<0){
                    absences.set(i,0);
                }
                 if (absences.get(i)>15){
                    absences.set(i,15);
                 }
            }
        }
        return absences;
    }

    private static double nonFeAverage(ArrayList<Integer> indexOfNonFe) {
        return sumAbsences(indexOfNonFe) / indexOfNonFe.size();
    }

    private static ArrayList<Integer> nonFeAbsences(ArrayList<Integer> absences) {
        ArrayList<Integer> indexOfNonFe = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int course = sc.nextInt();
        for (int i = 0; i < absences.size(); i++) {
            if (!(absences.get(i) > (course * 2))) {
                indexOfNonFe.add(i);
            }
        }
        return indexOfNonFe;
    }

    private static double percentageOfFe(ArrayList<Integer> indexFe) {
        int sum = sumAbsences(indexFe);
        double percentage = sum/ indexFe.size();
        return percentage;

    }

    private static ArrayList<Integer> moreThanAbsences(ArrayList<Integer> absences) {
        ArrayList<Integer> indexOfFe = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int course = sc.nextInt();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) > (course * 2)) {
                indexOfFe.add(i);
            }


        }
        return indexOfFe;
    }

    private static ArrayList indexOfAbsence(ArrayList<Integer> absences, int numOfAbsences) {
        ArrayList<Integer> listIndexes = new ArrayList<>();
        int stdIndex = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == numOfAbsences) {
                stdIndex = i;
                listIndexes.add(stdIndex);
            }
        }
        return listIndexes;
    }

    private static int fewerAbsencesSum(ArrayList<Integer> absences, int numOfAbsences) {
        int sum = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) < numOfAbsences) {
                sum = absences.get(i) + sum;
            }
        }
        return sum;
    }

    private static double percentage(ArrayList<Integer> absences) {
        int few = fewerAbsencesSum(absences, 3);
        double percentage = (few * 100) / absences.size();
        return percentage;
    }

    private static int sumAbsences(ArrayList<Integer> absences) {
        int sum = 0;
        for (int i = 0; i < absences.size(); i++) {
            sum = absences.get(i) + sum;
        }
        return sum;
    }

    private static double average(ArrayList<Integer> absences) {
        return (sumAbsences(absences)) / absences.size();


    }
}

