package contact;

public class Contact {
    private String name;
    private Integer age;
    private String email;

    public Contact(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void print() {
    	System.out.println();
    	System.out.println("Name: " + this.getName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Age: " + this.getAge());
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Convertir un contacto a formato CSV
    public String toCSV() {
        return name + "," + age + "," + email;
    }

    // Crear un contacto desde una línea CSV
    public static Contact fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Contact(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}