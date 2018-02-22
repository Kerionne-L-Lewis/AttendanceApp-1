
import java.util.*;

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
        System.out.println("The percentage of students who have fewer than 3 absences: " + pct);

        ArrayList<Integer> studentIndex = indexOfAbsence(absences, 1);
        System.out.println("List of Student indexes with 1 absence " + studentIndex);

        System.out.print("How many times does the course meet per week? ");
        ArrayList<Integer> indexFe = moreThanAbsences(absences);
        System.out.println("List of index of students with twice or more absences" + indexFe);
        double fePercentage = percentageOfFe(indexFe);
        System.out.printf("There are %.2f%% of students who FE the course", fePercentage);

        System.out.print("\nHow many times does the course meet per week? ");
        ArrayList<Integer> indexOfNonFe = nonFeAbsences(absences);


        double avgNonFe = nonFeAverage(indexOfNonFe);
        System.out.println("The list of students who did not FE the course" + indexFe +
                "\nHere is the average of that list " + avgNonFe);

        ArrayList<Integer> changeList = addToAbsences(absences);
        System.out.println("Changes " + changeList);

        Collections.sort(changeList);
        System.out.println("Sorted List " + changeList);

        Collections.shuffle(changeList);
        System.out.println("Shuffled List" + changeList);

        Set<Integer> unique = howMany(absences);
        System.out.println("Absence list" + absences + "has(" + unique.size() + ") unique absences");

        Map<Integer, Integer> duplicateCount = countCopies(absences);
        System.out.println("map" + duplicateCount);

        outputMap(absences);

        userSort(absences);

        userShuffle(absences);

        ArrayList<String> distinctNames = new ArrayList<>();
        distinctNames = initializeNames();
        System.out.println("\nThe distinct names are " + distinctNames);

        nameShuffle(distinctNames);

        ArrayList<String> secondListNames = newList(distinctNames, absences);
        System.out.println("\nList that has the same size as Absences list(" + secondListNames.size() +
                ")" + secondListNames);

        Boolean answer = allNamesUsedOnce(distinctNames);
        System.out.println("\nWere all 5 names used at least once? " + answer);


        ArrayList<String> perfectAttendance = namesForPerfectAttendance(absences, secondListNames);
        System.out.println("\nThe names of students with perfect attendance are: " + perfectAttendance);

        ArrayList<String> sameSizeStudentnames = namesSameSizeFeList(indexFe, distinctNames);

        ArrayList<String> userDefinedSet = userSet(indexFe, sameSizeStudentnames);
        System.out.println("\nThe names of students who FE'd" + userDefinedSet);

        int numberOFCoursesForName = howManyCourses(sameSizeStudentnames, "Joy");
        System.out.println("How many courses does Joy have? " + numberOFCoursesForName);
    }

    private static int howManyCourses(ArrayList<String> sameSizeStudentnames, String name) {
        int count = 0;
        for (int i = 0; i < sameSizeStudentnames.size(); i++) {
            if (sameSizeStudentnames.get(i).equals(name)) {
                count++;
            }
        }
        return count;
    }


    private static ArrayList<String> userSet(ArrayList<Integer> indexFe, ArrayList<String> sameSizeStudentnames) {
        ArrayList<String> feListofNames = new ArrayList<>();
        for (int i = 0; i < indexFe.size(); i++) {
            if (indexFe.get(i) > 2 && !(sameSizeStudentnames.get(i).equals(sameSizeStudentnames))) {
                feListofNames.add(sameSizeStudentnames.get(i));
            }
        }
        return feListofNames;
    }

    private static ArrayList<String> namesSameSizeFeList(ArrayList<Integer> indexFe, ArrayList<String> distinctNames) {
        ArrayList<String> feNames = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < indexFe.size(); i++) {
            int num = rand.nextInt(5);
            feNames.add(distinctNames.get(num));

        }
        return feNames;
    }


    private static ArrayList<String> namesForPerfectAttendance(ArrayList<Integer> absences, ArrayList<String> secondListNames) {
        ArrayList<String> perfectAttendance = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 0) {
                index = i;
                perfectAttendance.add(secondListNames.get(index));
            }
        }
        return perfectAttendance;
    }

    private static Boolean allNamesUsedOnce(ArrayList<String> distinctNames) {
        boolean answer = true;
        Random rand = new Random();
        for (int i = 0; i < distinctNames.size(); i++) {
            int num = rand.nextInt(5);
            if (distinctNames.get(num).equals(distinctNames.get(num))) {
                answer = false;
            }
        }
        return answer;
    }

    private static ArrayList<String> newList(ArrayList<String> distinctNames, ArrayList<Integer> absences) {
        ArrayList<String> newNames = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < absences.size(); i++) {
            int num = rand.nextInt(5);
            newNames.add(distinctNames.get(num));
        }
        return newNames;
    }

    private static void nameShuffle(ArrayList<String> distinctNames) {
        for (int i = 0; i < distinctNames.size(); i++) {
            for (int j = 0; j < distinctNames.size(); j++) {
                if (!(i % 2 == 0)) {
                    String temp = distinctNames.get(i);
                    distinctNames.set(i, distinctNames.get(j));
                    distinctNames.set(j, temp);
                }
            }
        }
        System.out.println("\nUser defined shuffle Names" + distinctNames);
    }

    private static ArrayList<String> initializeNames() {
        ArrayList<String> distinctNames = new ArrayList<>();
        distinctNames.add("Pauline");
        distinctNames.add("Joy");
        distinctNames.add("Heaven");
        distinctNames.add("Mindy");
        distinctNames.add("Rashad");

        return distinctNames;
    }

    public static void userShuffle(ArrayList<Integer> absences) {
        for (int i = 0; i < absences.size(); i++) {
            for (int j = 0; j < absences.size(); j++) {
                if (absences.get(i) % 2 == 0) {
                    int temp = absences.get(i);
                    absences.set(i, absences.get(j));
                    absences.set(j, temp);
                }
            }
        }
        System.out.println("\nUser defined shuffled " + absences);
    }

    public static void userSort(ArrayList<Integer> absences) {
        for (int i = 0; i < absences.size(); i++) {
            for (int j = 0; j < absences.size(); j++) {
                if (absences.get(i) < absences.get(j)) {
                    int temp = absences.get(i);
                    absences.set(i, absences.get(j));
                    absences.set(j, temp);
                }
            }
        }
        System.out.println("\nUser defined sort" + absences);
    }

    private static void outputMap(ArrayList<Integer> absences) {
        Map<Integer, Integer> duplicateCount = countCopies(absences);
        for (Map.Entry<Integer, Integer> dupe : duplicateCount.entrySet()) {
            int key = dupe.getKey();
            int value = dupe.getValue();
            System.out.println("the key is " + key + " and its value is " + value);
            System.out.print(key + "\t");
            stars(value);

        }
    }

    private static void stars(int duplicateCount) {
        for (int i = 0; i < duplicateCount; i++) {
            System.out.print("*");
        }
    }

    public static Map<Integer, Integer> countCopies(ArrayList<Integer> absences) {
        Map<Integer, Integer> countDupes = new HashMap<>();
        for (int i = 0; i < absences.size(); i++) {
            int dupe = absences.get(i);
            if (countDupes.containsKey(dupe)) {
                int count = countDupes.get(dupe);
                countDupes.put(dupe, count + 1);
            } else {
                countDupes.put(dupe, 1);
            }
        }
        return countDupes;
    }

    public static Set<Integer> howMany(ArrayList<Integer> absences) {
        Set<Integer> absenceList = new HashSet<>();
        for (int i = 0; i < absences.size(); i++) {
            absenceList.add(absences.get(i));
        }
        return absenceList;
    }

    private static ArrayList<Integer> addToAbsences(ArrayList<Integer> absences) {
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) > absences.get(0)) {
                absences.set(i, absences.get(i) + -3);
                if (absences.get(i) < 0) {
                    absences.set(i, 0);
                }
                if (absences.get(i) > 15) {
                    absences.set(i, 15);
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
        double percentage = sum / indexFe.size();
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

