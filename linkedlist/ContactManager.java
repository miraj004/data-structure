package linkedlist;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class ContactManager {

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. New Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search for contact");
            System.out.println("4. Contact lists");
            System.out.println("5. Exit");

            System.out.print("\n(You) >> ");
            int choice;
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch(MissingFormatArgumentException e) {
                choice = 0;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Contact Name:\n(You) >> ");
                    String name = input.nextLine();
                    System.out.print("Enter Contact Phone:\n(You) >> ");
                    String phone = input.nextLine();
                    contactList.addContact(name, phone);
                }
                case 2 -> {
                    System.out.print("Enter Contact ID to delete:\n(You) >> ");
                    int id = input.nextInt();
                    input.nextLine();
                    contactList.deleteContact(id);
                }
                case 3 -> {
                    System.out.print("Search contact:\n(You) >> ");
                    String searchedItem = input.nextLine();
                    ArrayList<Contact> contacts = contactList.searchContact(searchedItem);

                    if (!contacts.isEmpty()) {
                        System.out.println("----------------");
                        System.out.println("Founded, Contacts:");
                        System.out.println("-----------------------------");
                        for (Contact contact :
                                contactList.searchContact(searchedItem)) {
                            contactList.contactDetail(contact);
                        }
                    } else {
                        System.out.println("""
                                ==================
                                Contact Not Found!
                                ==================""");
                    }
                }
                case 4 -> {
                    System.out.println("Contact List: ");
                    contactList.printContacts();
                }
                case 5 -> {
                    System.out.println("Program execution terminated.");
                    System.exit(0);
                }
                default -> {
                    System.out.println("""
                            ========================
                            Invalid Option selected!
                            ========================""");
                }
            }

        }
    }
}
