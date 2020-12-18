import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Translate":
                    String firstChar = command[1];
                    String replacement = command[2];
                    text = text.replaceAll(firstChar,replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String string = command[1];
                    if(text.contains(string)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String otherString = command[1];
                    if(text.contains(otherString)){
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
                    String newChar = command[1];
                    System.out.println(text.lastIndexOf(newChar) );
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);
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
