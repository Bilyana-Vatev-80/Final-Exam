import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<name>[A-Za-z]{8,})\\]");

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);

            if(matcher.find()){
              String toEncode = matcher.group("name");
                System.out.print(matcher.group("command") + ":" );
                for (int j = 0; j < toEncode.length(); j++) {
                    if(Character.isAlphabetic(toEncode.charAt(j)) )
                    System.out.print(" " + (int)toEncode.charAt(j));
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }

        }

    }
}
//2
//!Send!:[IvanisHere]
//*Time@ : [Itis5amAlready]
//
//3
//go:[outside]
//!drive!:YourCarToACarWash
//!Watch!:[LordofTheRings]
//
//3
//!play!:[TheNewSong]
//!Ride!:[Bike]
//!Watch!:[LordofTheRings]