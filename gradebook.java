/* 
Name:Elizabeth Pursell
Date: 4/15/2022
CSE 007 Spring 2022
Produce Gradebook program that will create find the averages of an array of grades
IDE Used: Visual Studio Code
*/
import java.util.Arrays;
public class gradebook {
    public static void main(String[] args){
        int [] [] gradesArray = {{87, 96, 70},
                                {68, 87, 90},
                                {94, 100, 90},
                                {100, 81, 82},
                                {83, 65, 85},
                                {78, 87, 65},
                                {85, 75, 83},
                                {91, 94, 100},
                                {76, 72, 84},
                                {87, 93, 73}};
        double [] averageRowArray = averageStudent(gradesArray);
        double [] averageColArray = averageTestScore(gradesArray);
        double totalAverage = getClassAverage(gradesArray);
        printGrades(gradesArray, averageRowArray, averageColArray, totalAverage);
        sortGrades(gradesArray);
        printGrades(gradesArray, averageRowArray, averageColArray, totalAverage);
        printRowMemory(gradesArray);
    }
    public static double [] averageStudent(int [] [] list){
        double [] averages = new double [list.length];
        for(int row = 0; row < list.length; row++){
            double sum = 0;
            for(int col = 0; col < list[row].length; col++){
                sum = sum + list[row][col];
            }
            averages[row] = Math.round(sum / list[row].length * 100.0) / 100.0;
        }
        return averages;
    }
    public static double [] averageTestScore(int [] [] list){
        double [] examAverages = new double [list[0].length];
        for(int col = 0; col < examAverages.length; col++){
            double sum = 0;
            for(int row = 0; row < list.length; row++){
                sum = sum + list[row][col];
            }
            examAverages[col] = Math.round(sum / list.length * 100.0) / 100.0;
        }
        return examAverages;
    }
    public static double getClassAverage(int [] [] list){
        double classAverage = 0;
        double counter = 0;
        double sum = 0;
        for(int row = 0; row < list.length; row++){
            for(int col = 0; col < list[row].length; col++){
                sum = sum + list[row][col];
                counter++;
            }
        }
        classAverage = Math.round(sum / counter * 100.0) / 100.0;
        return classAverage;
    }
    public static void printGrades(int [] [] grades, double [] studentAverage, double [] examAverage, double classAverage){
        System.out.print("\t\tTest 1\tTest 2\tTest 3  Average");
        System.out.println();
        for(int row = 0; row < grades.length; row++){
            System.out.print("Student " + (row + 1));
            for(int col = 0; col < grades[row].length; col++){
                System.out.print("\t" + grades[row][col]);
            }
            System.out.println("      " + studentAverage[row]);
        }
        System.out.print("Average\t");
        for(int index = 0; index < examAverage.length; index++){
            System.out.print("\t" + examAverage[index]);
        }
        System.out.println("    " + classAverage);
    }
    public static void sortGrades(int [] [] list){
        for(int row = 0; row < list.length; row++){
            for(int i = 0; i < list[row].length - 1; i++){
                int indexMin = i;
                int min = list[row][i];
                for(int j = i + 1; j < list[row].length; j++){
                    if(min > list[row][j]){
                        min = list[row][j];
                        indexMin = j;
                    }
                }
                if(indexMin != i){
                    list[row][indexMin] = list[row][i];
                    list[row][i] = min;
                }
            }
        }
    }
    public static void printRowMemory(int [] [] list){
        for(int row = 0; row < list.length; row++){
            System.out.println(list[row]);
        }
    }
}