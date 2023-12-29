package linkedlist;

import java.util.ArrayList;

public class ContactList {
    Contact head;

    public void addContact(String name, String phone) {
        Contact newTask = new Contact(name, phone);
        newTask.next = head;
        head = newTask;
    }

    public ArrayList<Contact> searchContact(String contact) {
        Contact current = head;
        ArrayList<Contact> contacts = new ArrayList<>();
        while (current != null) {
            if (current.phone.equals(contact) ||
                    current.name.toLowerCase().equals(contact.toLowerCase().trim())
            ) {
                contacts.add(current);
            }
            current = current.next;
        }
        return contacts;
    }

    public void printContacts() {
        if (head == null) {
            System.out.println("""
                    ====================
                    Empty! Contact List.
                    ====================""");
            return;
        }
        Contact current = head;

        System.out.println("-----------------------------");

        while (current != null) {
            contactDetail(current);
            current = current.next;
        }
    }

    public void deleteContact(int id) {
        if (head == null) {
            System.out.println("""
                    ============================
                    Given Contact's ID Not Found!
                    ============================""");
            return;
        }

        if (head.id == id) {
            head = head.next;
            return;
        }

        Contact prev = head;
        Contact current = head;

        while (current.id != id) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }


    public void contactDetail(Contact contact) {
        System.out.println(
                "ID: " + contact.id + "\n" +
                        "Name: " + contact.name + "\n" +
                        "Phone: " + contact.phone + "\n" +
                        "-----------------------------"
        );
    }


}
