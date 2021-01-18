package project3A;


import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.SequenceInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Password {

    public static boolean checkPassword() throws IOException {
        Scanner input = new Scanner(System.in);
        String ans = input.next();

        FileInputStream words = new FileInputStream("words.txt");
        FileInputStream passwords = new FileInputStream("passwords.txt");
        SequenceInputStream dictionary = new SequenceInputStream(words, passwords);
        BufferedReader reader = new BufferedReader(new InputStreamReader(dictionary));

        if (ans.length() < 5) {
            return false;
        }
        String line;
        int s1 = 0;
        int s2 = 0;

        while ((line = reader.readLine()) != null) {
            if (ans.equals(line)){
                return false;
            }
            if (ans.contains(line)) {
                s1 = ans.indexOf(line);
                s2 = ans.lastIndexOf(line);
            }

            try {
                if (Character.isDigit(ans.charAt(s1-1))){
                    return false;
                }
            }catch (StringIndexOutOfBoundsException e){
            }
            try {
                if (Character.isDigit(ans.charAt(s2+1))){
                    return false;
                }
            }catch (StringIndexOutOfBoundsException e){
            }

        }
        return true;
    }
}
