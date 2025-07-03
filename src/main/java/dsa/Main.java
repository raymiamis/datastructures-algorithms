package dsa;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String text = "abbbaaaababbababbbaabbababbabaababababbbabababa";
        String pattern = "babababa";

        int index = StringSearch.bruteForceSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern gefunden an Index: " + index);
        } else {
            System.out.println("Pattern nicht gefunden.");
        }
    }
}