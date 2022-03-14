package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ex4_c {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();
        ArrayList<String[]> listOfString2 = new ArrayList<String[]>();
        ArrayList<String[]> listAfterStandarization;
        ArrayList<Double> listOfMean;
        ArrayList<Double> listOf;

        File file = new File("dane/diabetes.txt");
        File file2 = new File("dane/diabetes.txt");
        Scanner sc = new Scanner(file);
        Scanner sc2 = new Scanner(file2);

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            listOfString.add(line);
        }

        while (sc2.hasNextLine()) {
            String[] line2 = sc2.nextLine().split(" ");
            listOfString2.add(line2);
        }

        System.out.println("Wybrany system bez standaryzacji");
        for (String[] str : listOfString) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Wybrany system po standaryzacji");
        listAfterStandarization = standarization(listOfString2);
        for (String[] str : listAfterStandarization) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Średnia wartość atrybutów po standaryzacji");
        listOfMean = listOfMean(listAfterStandarization);
        for(Double number: listOfMean){
            System.out.print(number+" ");
        }
        System.out.println();
        System.out.println("Wartość odchylenia standardowego atrybutów po standaryzacji");
        listOf = valuesOfStandardDeviations(listAfterStandarization);
        for(Double number: listOf){
            System.out.print(number+" ");
        }

    }

    public static ArrayList<String[]> standarization(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMean = listOfMean(listOfString);
        ArrayList<Double> valuesOfStandardDeviations = valuesOfStandardDeviations(listOfString);

        for(int i=0;i<listOfString.get(0).length;i++){
            for(String[] str: listOfString){
                double result = (Double.valueOf(str[i])-listOfMean.get(i))/valuesOfStandardDeviations.get(i);
                str[i] = String.valueOf(result);
            }
        }

        return listOfString;
    }

    public static ArrayList<Double> listOfMean(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMean = new ArrayList<Double>();

        int n = listOfString.size();
        for(int i=0;i<listOfString.get(0).length;i++){
            double sum=0.0;
            for(String[] str: listOfString){
                sum+=Double.valueOf(str[i]);
            }
            double mean = sum/n;
            listOfMean.add(mean);
        }

        return listOfMean;
    }

    public static ArrayList<Double> valuesOfStandardDeviations(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfStandardDevations = new ArrayList<Double>();
        ArrayList<Double> listOfMean = listOfMean(listOfString);

        int n = listOfString.size();
        for(int i=0;i<listOfString.get(0).length;i++){
            double variance = 0.0;
            for(String[] str: listOfString){
                variance += Math.pow((Double.valueOf(str[i])-listOfMean.get(i)),2);
            }
            double standardDeviation = Math.sqrt(variance/n);
            listOfStandardDevations.add(standardDeviation);
        }

        return listOfStandardDevations;
    }
}
