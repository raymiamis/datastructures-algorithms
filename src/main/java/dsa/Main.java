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

        int[] foundPositions = new int[text.length()];
        int[] index = {-1};

        StringSearch.boyerMooreSearch(text, pattern, foundPositions, index);

        for (int foundIndex : foundPositions) {
            if (foundIndex != 0) {
                System.out.println(foundIndex);
            }
        }
    }
}
