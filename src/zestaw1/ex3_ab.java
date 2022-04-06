package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ex3_ab {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();

        File file = new File("dane/diabetes.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            listOfString.add(line);
        }
        System.out.println("Symbole klas decyzyjnych:");
        for (String[] str : listOfString) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int k = 0;
        int different = 0;
        ArrayList<String> listOfDifferentValues = new ArrayList<String>();
        for (String[] str : listOfString) {
                System.out.println(str[listOfString.get(0).length-1] + " ");
            if (k == 0) {
                listOfDifferentValues.add(str[listOfString.get(0).length-1]);
            } else {
                for (int j = 0; j < listOfDifferentValues.size(); j++) {
                    if (!Double.valueOf(str[listOfString.get(0).length-1]).equals(Double.valueOf(listOfDifferentValues.get(j)))) {
                        different++;
                    }
                }
            }
            if (different == listOfDifferentValues.size()) {
                listOfDifferentValues.add(str[listOfString.get(0).length-1]);
            }
            different = 0;
            k++;
        }

        System.out.println("Wielkość klas decyzyjnych: " + listOfDifferentValues.size());

        }

    }

