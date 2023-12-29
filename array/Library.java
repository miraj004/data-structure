package array;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
    private Book[] books;
    public static int size = 0;
    private static final int DEFAULT_CAP = 10;
    private final Scanner input;

    public Library() {
        this.books = new Book[DEFAULT_CAP];
        input = new Scanner(System.in);
    }

    private void resize() {
        Book[] bookList = new Book[this.books.length + DEFAULT_CAP];
        int index = 0;
        for (Book book: this.books) {
            bookList[index] = book;
            index++;
        }
        this.books = bookList;
    }

    public void addBook() {


        Book lastBook = this.books[this.books.length - 1];
        if (lastBook != null) {
            resize();
        }

        System.out.print("Book Title:\n>> ");
        String title = input.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("""
                    =================
                    Title is required
                    =================""");
            return;
        }

        System.out.print("Book Author:\n>> ");
        String author = input.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("""
                    ==================
                    Author is required
                    ==================""");
            return;
        }

        this.books[size++] = new Book(title, author);
        System.out.println("""
                =======================
                Book Successfully Added
                =======================""");
    }

    public void listBooks() {
        StringBuilder list = new StringBuilder();
        int index = 1;
        for (Book book : this.books) {
            if (book == null)
                continue;
            list.append(index++).append(": ").append(book).append("\n");
        }
        if (list.length() == 0) {
            System.out.println("""
                    --------------
                    List is empty!
                    --------------""");
        } else {
            System.out.println(list);
        }
    }

    public void search() {
        try {
            while (true) {
                System.out.print("Search by Title[1], Author[2], or go to Main Menu[3]\n>> ");
                int response = input.nextInt();
                input.nextLine();
                switch (response) {
                    case 1 -> {
                        if (!findBook(Book.TITLE)) {
                            System.out.println("""
                                    ==============================
                                    Book Not Found! by given Title
                                    ==============================""");
                        }
                    }
                    case 2 -> {
                        if (!findBook(Book.AUTHOR)) {
                            System.out.println("""
                                    ===============================
                                    Book Not Found! by given Author
                                    ===============================""");
                        }
                    }
                    case 3 -> {
                        System.out.println("""
                                ---------------------------
                                       Exited Search
                                ---------------------------"""
                        );
                        return;
                    }
                    default -> {
                        System.out.println("""
                                -----------------------
                                      Invalid Choice
                                -----------------------""");
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("""
                    -----------------------
                          Invalid input
                    -----------------------""");
        }
    }


    public boolean findBook(int by) {
        System.out.print("Enter " + (by == Book.TITLE ? "Title" : "Author") + "\n>> ");
        String searchedItem = input.nextLine();
        for (Book book : this.books) {
            if (book == null)
                continue;
            String filter = (by == Book.TITLE ? book.getTitle() : book.getAuthor());
            if (filter.equalsIgnoreCase(searchedItem)) {
                System.out.println("\nBook Found, " + book + "\n");
                return true;
            }
        }
        return false;
    }






}
