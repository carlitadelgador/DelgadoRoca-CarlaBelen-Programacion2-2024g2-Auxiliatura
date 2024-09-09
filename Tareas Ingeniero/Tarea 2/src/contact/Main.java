package contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import contact.Contact;
import contact.ContactManager;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        // Cargar contactos desde el archivo al inicio del programa
        String filename = "contacts.txt";
        manager.loadContactsFromFile(filename);

        while (!quit) {
            createMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    Contact contact = new Contact(name, age, email);
                    manager.addContact(contact);
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter email to search: ");
                    email = scanner.nextLine();
                    Contact foundContact = manager.searchContact(email);
                    if (foundContact != null) {
                        foundContact.print();
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter email to remove: ");
                    email = scanner.nextLine();
                    if (manager.removeContact(email)) {
                        System.out.println("Contact removed.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    manager.showAllContacts();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        // Guardar contactos en el archivo al salir del programa
        manager.saveContactsToFile(filename);

        scanner.close();
    }

    public static void createMenu() {
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Remove Contact");
        System.out.println("4. Show Contact");
        System.out.println("5. Quit");
    }
}