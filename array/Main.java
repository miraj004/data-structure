package array;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();
        try {
            while (true) {
                System.out.println(
                        """
                                1. Book list
                                2. New Book
                                3. Search Book
                                4. Exit"""
                );
                System.out.print(">> ");

                int response = input.nextInt();
                switch (response) {
                    case 1 -> library.listBooks();
                    case 2 -> library.addBook();
                    case 3 -> library.search();
                    case 4 -> {
                        System.out.println("""
                                ========
                                Good Bye
                                ========""");
                        System.exit(0);
                    }
                    default -> System.out.println("""
                            ----------------
                            Option not exist
                            ----------------""");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("""
                    -------------
                    Invalid input
                    -------------""");
        }

    }




}
