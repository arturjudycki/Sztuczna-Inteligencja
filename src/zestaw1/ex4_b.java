package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ex4_b {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();
        ArrayList<String[]> listOfString2 = new ArrayList<String[]>();
        ArrayList<String[]> listOfString3 = new ArrayList<String[]>();
        ArrayList<String[]> listOfString4 = new ArrayList<String[]>();
        ArrayList<String[]> firstInterval;
        ArrayList<String[]> secondInterval;
        ArrayList<String[]> thirdInterval;

        File file = new File("dane/diabetes.txt");
        File file2 = new File("dane/diabetes.txt");
        File file3 = new File("dane/diabetes.txt");
        File file4 = new File("dane/diabetes.txt");
        Scanner sc = new Scanner(file);
        Scanner sc2 = new Scanner(file2);
        Scanner sc3 = new Scanner(file3);
        Scanner sc4 = new Scanner(file4);

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            listOfString.add(line);
        }

        while (sc2.hasNextLine()) {
            String[] line2 = sc2.nextLine().split(" ");
            listOfString2.add(line2);
        }

        while (sc3.hasNextLine()) {
            String[] line3 = sc3.nextLine().split(" ");
            listOfString3.add(line3);
        }

        while (sc4.hasNextLine()) {
            String[] line4 = sc4.nextLine().split(" ");
            listOfString4.add(line4);
        }

        System.out.println("Wybrany system bez żadnych zmian");
        for (String[] str : listOfString) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Znormalizowane atrybuty numeryczne na przedział: <-1,1>");
        firstInterval = normalizationOnFirstInterval(listOfString2);
        for (String[] str : firstInterval) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Znormalizowane atrybuty numeryczne na przedział: <0,1>");
        secondInterval = normalizationOnSecondInterval(listOfString3);
        for (String[] str : secondInterval) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Znormalizowane atrybuty numeryczne na przedział: <-10,10>");
        thirdInterval = normalizationOnThirdInterval(listOfString4);
        for (String[] str : thirdInterval) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static ArrayList<String[]> normalizationOnFirstInterval(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMinValues = minValuesOfAttributes(listOfString);
        ArrayList<Double> listOfMaxValues = maxValuesOfAttributes(listOfString);

        int a = -1;
        int b = 1;

        for(int i=0;i<listOfString.get(0).length;i++){
            for(String[] str: listOfString){
                double equation = (((Double.valueOf(str[i])-listOfMinValues.get(i))*(b-a))/listOfMaxValues.get(i)-listOfMinValues.get(i))+a;
                str[i] = String.format("%.3f", equation);
            }
        }

        return listOfString;
    }

    public static ArrayList<String[]> normalizationOnSecondInterval(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMinValues = minValuesOfAttributes(listOfString);
        ArrayList<Double> listOfMaxValues = maxValuesOfAttributes(listOfString);

        int a = 0;
        int b = 1;

        for(int i=0;i<listOfString.get(0).length;i++){
            for(String[] str: listOfString){
                double equation = (((Double.valueOf(str[i])-listOfMinValues.get(i))*(b-a))/listOfMaxValues.get(i)-listOfMinValues.get(i))+a;
                str[i] = String.format("%.3f", equation);
            }
        }

        return listOfString;
    }

    public static ArrayList<String[]> normalizationOnThirdInterval(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMinValues = minValuesOfAttributes(listOfString);
        ArrayList<Double> listOfMaxValues = maxValuesOfAttributes(listOfString);

        int a = -10;
        int b = 10;

        for(int i=0;i<listOfString.get(0).length;i++){
            for(String[] str: listOfString){
                double equation = (((Double.valueOf(str[i])-listOfMinValues.get(i))*(b-a))/listOfMaxValues.get(i)-listOfMinValues.get(i))+a;
                str[i] = String.format("%.3f", equation);
            }
        }

        return listOfString;
    }

    public static ArrayList<Double> minValuesOfAttributes(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMinValues = new ArrayList<Double>();

        for(int i=0; i<listOfString.get(0).length;i++){
            double min = Double.valueOf(listOfString.get(0)[i]);
            for (String[] str : listOfString) {
                if (Double.valueOf(str[i])<min){
                    min=Double.valueOf(str[i]);
                }
            }
            listOfMinValues.add(min);
        }

        return listOfMinValues;
    }

    public static ArrayList<Double> maxValuesOfAttributes(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMaxValues = new ArrayList<Double>();

        for(int i=0; i<listOfString.get(0).length;i++){
            double max = Double.valueOf(listOfString.get(0)[i]);
            for (String[] str : listOfString) {
                if (Double.valueOf(str[i])>max){
                    max=Double.valueOf(str[i]);
                }
            }
            listOfMaxValues.add(max);
        }

        return listOfMaxValues;
    }
}
