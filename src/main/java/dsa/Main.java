package dsa;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the text to be searched within:");
        String text = scan.nextLine();
        System.out.println("Enter the pattern to be searched for:");
        String pattern = scan.nextLine();

        int index = StringSearch.bruteForceSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern gefunden an Index: " + index);
        } else {
            System.out.println("Pattern nicht gefunden.");
        }
    }
}
