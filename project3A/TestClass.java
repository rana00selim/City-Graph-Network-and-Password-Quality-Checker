package project3A;

import java.io.IOException;
import java.util.Scanner;

import static project3A.Password.checkPassword;

public class TestClass {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------Password Checker-------------\n\n"
                + "A good password needs to be;\n"
                + "* at least 5 characters long,\n"
                + "* not a word in the english dictionary or mostly used password dictionary,\n"
                + "* not a word in the dictionary followed/prefixed by a digit 0-9 (e.g. hello5, 5hello).\n");

        int opt = 0;
        while (opt != 2){
            System.out.println("1) Check a password \n" +
                    "2) Exit");
            opt = input.nextInt();
            if (opt == 1){
                System.out.println("_______________________________________________________");
                System.out.print("Enter your password: ");
                if (checkPassword()){
                    System.out.println("Good password :)\n");
                } else {
                    System.out.println("Bad password :( \n");
                }
            }else if (opt < 1 || opt > 2){
                System.out.println("Invalid option");
            }
        }
        System.out.println("Exiting...");
    }
}
