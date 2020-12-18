import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] commands = input.split("\\s+");

            switch (commands[0]) {

                case "Translate":
                    String change = commands[1];
                    String newChar = commands[2];
                    text = text.replaceAll(change, newChar);
                    System.out.println(text);
                    break;
                case "Includes":
                    String parts = commands[1];
                    if (text.contains(parts)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String start = commands[1];
                    if (text.startsWith(start)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String letter = commands[1];
                    System.out.println(text.lastIndexOf(letter) );
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(commands[1]);
                    int count = Integer.parseInt(commands[2]);
                    StringBuilder sb = new StringBuilder(text);
                    sb.delete(startIndex,startIndex + count);
                    text = sb.toString();

                    System.out.println(text);
                    break;

            }
            input = scanner.nextLine();
        }
    }
}
