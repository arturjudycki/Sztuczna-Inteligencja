package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ex4_a {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();
        ArrayList<String[]> listOfString2 = new ArrayList<String[]>();
        ArrayList<String[]> tenPerCentOfMissingValues;
        ArrayList<String[]> fixingWithMean;

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

        tenPerCentOfMissingValues = tenPerCentOfMissingValues(listOfString2);
        System.out.println("Dane, gdzie 10% wartości jest nieznanych");
        for (String[] str : tenPerCentOfMissingValues) {
            for (int j = 0; j < str.length-1; j++) {
                System.out.print(str[j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        fixingWithMean = fixingByMean(listOfString,tenPerCentOfMissingValues);
        System.out.println("Dane, gdzie wartości nieznane są zastąpione wartością średnią dla danego atrybutu numerycznego");
        for (String[] str : fixingWithMean) {
            for (int k = 0; k < str.length-1; k++) {
                System.out.print(str[k] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static ArrayList<String[]> tenPerCentOfMissingValues(ArrayList<String[]> listOfString){
        Random generator = new Random();

        long numberOfUnknownValues = Math.round((listOfString.size()*listOfString.get(0).length-1)*0.1);
        int i = 0;
        while (i != numberOfUnknownValues){
            int genNumber1 = generator.nextInt(768);
            int genNumber2 = generator.nextInt(8);
            if(!listOfString.get(genNumber1)[genNumber2].equals("?")){
                listOfString.get(genNumber1)[genNumber2] = "?";
                i++;
            }
        }

        return listOfString;
    }

    public static ArrayList<Double> listOfMean(ArrayList<String[]> listOfString){
        ArrayList<Double> listOfMean = new ArrayList<Double>();

        int n = listOfString.size();
        for(int i=0;i<listOfString.get(0).length-1;i++){
            double sum=0.0;
            for(String[] str: listOfString){
                sum+=Double.valueOf(str[i]);
            }
            double mean = sum/n;
            listOfMean.add(mean);
        }

        return listOfMean;
    }

    public static ArrayList<String[]> fixingByMean(ArrayList<String[]> listOfString,ArrayList<String[]> listOfString2){
        ArrayList<Double> listOfMean = listOfMean(listOfString);

        for(int i=0;i<listOfString2.get(0).length-1;i++){
            for(String[] str: listOfString2){
                if(str[i].equals("?")){
                    str[i] = String.format("%.3f", listOfMean.get(i));
                }
            }
        }

        return listOfString2;
    }

}
