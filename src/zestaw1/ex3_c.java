package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ex3_c {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();
        ArrayList<Double> listOfMinValues;
        ArrayList<Double> listOfMaxValues;

        File file = new File("dane/diabetes.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            listOfString.add(line);
        }

        listOfMinValues = minValuesOfAttributes(listOfString);
        System.out.println("Minimalne wartości dla kolejnych atrybutów:");
        int numberOfAtrForMin = 1;
        for (Double minn : listOfMinValues) {
            System.out.println("Atr" + numberOfAtrForMin + ": " + minn);
            numberOfAtrForMin++;
        }
        System.out.println();

        listOfMaxValues = maxValuesOfAttributes(listOfString);
        System.out.println("Maksymalne wartości dla kolejnych atrybutów:");
        int numberOfAtrForMax = 1;
        for (Double maxx : listOfMaxValues) {
            System.out.println("Atr" + numberOfAtrForMax + ": " + maxx);
            numberOfAtrForMax++;
        }
        System.out.println();
    }

    public static ArrayList<Double> minValuesOfAttributes(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMinValues = new ArrayList<Double>();

        for(int i=0; i<listOfString.get(0).length-1;i++){
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

        for(int i=0; i<listOfString.get(0).length-1;i++){
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
