package zestaw1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ex4_d {
    public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfString = new ArrayList<String[]>();

        Scanner sc = new Scanner(new File("dane/Churn_Modelling.csv"));
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            listOfString.add(line);
        }
        for (String[] str : listOfString) {
            for (int i = 0; i< str.length; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }

    }
}
