package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ex3_e {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();

        File file = new File("dane/diabetes.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            listOfString.add(line);
        }

        listOfAllDifferentValues(listOfString);

    }

    public static void listOfAllDifferentValues(ArrayList<String[]> listOfString){
        ArrayList<String> listOfDifferentValues = new ArrayList<String>();

        int k = 0;
        int different = 0;
        int nAtr = 1;
        for (int i = 0; i < listOfString.get(0).length-1; i++) {
            for (String[] str : listOfString) {
                if (k == 0) {
                    listOfDifferentValues.add(str[i]);
                } else {
                    for (int j = 0; j < listOfDifferentValues.size(); j++) {
                        if (!Double.valueOf(str[i]).equals(Double.valueOf(listOfDifferentValues.get(j)))) {
                            different++;
                        }
                    }
                }
                if (different == listOfDifferentValues.size()) {
                    listOfDifferentValues.add(str[i]);
                }
                different = 0;
                k++;
            }
            System.out.println("Lista wszystkich różnych wartości dla Atrybutu" + nAtr + ": ");
            for (String str : listOfDifferentValues) {
                System.out.print(str + " ");
            }
            System.out.println();
            nAtr++;
            listOfDifferentValues.clear();
        }
    }
}
