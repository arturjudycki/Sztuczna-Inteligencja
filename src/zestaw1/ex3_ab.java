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

        System.out.println("Wielkość klas decyzyjnych: " + listOfString.get(0).length);

        }
    }

