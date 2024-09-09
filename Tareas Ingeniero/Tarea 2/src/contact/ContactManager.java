package contact;

import java.util.HashMap;
import java.io.BufferedWriter; // Para escribir en el archivo
import java.io.FileWriter; // Para escribir en el archivo
import java.io.IOException; // Para manejar excepciones de E/S
import java.io.BufferedReader; // Para leer desde el archivo
import java.io.FileReader; // Para leer desde el archivo

public class ContactManager {
    private HashMap<String, Contact> contacts;

    public ContactManager() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        this.contacts.put(contact.getEmail(), contact);
    }

    public Contact searchContact(String email) {
        return this.contacts.getOrDefault(email, null);
    }

    public Boolean removeContact(String email) {
        return this.contacts.remove(email) != null;
    }

    public void showAllContacts() {
        for (Contact contact : this.contacts.values()) {
            contact.print();
        }
    }

    // Guardar contactos en un archivo
    public void saveContactsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact contact : this.contacts.values()) {
                writer.write(contact.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar contactos desde un archivo
    public void loadContactsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contact contact = Contact.fromCSV(line);
                this.addContact(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}