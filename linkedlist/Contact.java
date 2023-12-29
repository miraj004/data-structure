package linkedlist;

public class Contact {
    int id;
    String phone;
    String name;
    Contact next;

    private static int counter;
    public Contact(String name, String phone) {
        this.id = ++counter;
        this.name = name;
        this.phone = phone;
        this.next = null;
    }

}
