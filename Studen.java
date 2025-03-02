
    import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Studen{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> studentGrades = new HashMap<>();
        
        System.out.println("Enter student name and grade (type 'exit' to stop):");

      
        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();
            
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter grade for " + name + ": ");
            double grade;
            try {
                grade = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric grade.");
                continue;
            }

            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade! Enter a value between 0 and 100.");
            } else {
                studentGrades.put(name, grade);
            }
        }

      
        if (studentGrades.isEmpty()) {
            System.out.println("No student data entered. Exiting...");
        } else {
        
            double average = calculateAverage(studentGrades);
            Map.Entry<String, Double> highest = findHighest(studentGrades);
            Map.Entry<String, Double> lowest = findLowest(studentGrades);

          
            System.out.println("\nGrade Statistics:");
            System.out.println("Total Students: " + studentGrades.size());
            System.out.printf("Average Grade: %.2f%n", average);
            System.out.println("Highest Grade: " + highest.getKey() + " - " + highest.getValue());
            System.out.println("Lowest Grade: " + lowest.getKey() + " - " + lowest.getValue());
        }

        scanner.close();
    }

  
    public static double calculateAverage(HashMap<String, Double> grades) {
        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

  
    public static Map.Entry<String, Double> findHighest(HashMap<String, Double> grades) {
        Map.Entry<String, Double> maxEntry = null;
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

    public static Map.Entry<String, Double> findLowest(HashMap<String, Double> grades) {
        Map.Entry<String, Double> minEntry = null;
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                minEntry = entry;
            }
        }
        return minEntry;
    }
}
    

