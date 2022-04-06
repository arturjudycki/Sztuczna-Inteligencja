package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ex3_f {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();
        ArrayList<Double> listOfStandardDevations;

        File file = new File("dane/diabetes.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            listOfString.add(line);
        }

        listOfStandardDevations = valuesOfStandardDeviations(listOfString);
        int numberOfAtrForSD =1;
        for(Double number: listOfStandardDevations){
            System.out.println("Wartość odchylenia standardowego dla Atr"+numberOfAtrForSD+": "+number);
            numberOfAtrForSD++;
        }

    }

    public static ArrayList<Double> valuesOfStandardDeviations(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfStandardDevations = new ArrayList<Double>();

        int n = listOfString.size();
        for(int i=0;i<listOfString.get(0).length-1;i++){
            double sum=0.0;
            for(String[] str: listOfString){
                sum+=Double.valueOf(str[i]);
            }
            double mean = sum/n;
            double variance = 0.0;
            for(String[] str: listOfString){
                variance += Math.pow((Double.valueOf(str[i])-mean),2);
            }
            double standardDeviation = Math.sqrt(variance/n);
            listOfStandardDevations.add(standardDeviation);
        }

        return listOfStandardDevations;
    }
}
