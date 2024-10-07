public class Main {
    public static void main(String[] args) {
        Author tolkien = new Author("J.R.R. Tolkien");

        // Añadiendo libros usando el método addBook con un objeto Book
        Book book1 = new Book("El Hobbit", tolkien, 25.99);
        tolkien.addBook(book1);

        // Añadiendo libros usando el método sobrecargado addBook con título y precio
        tolkien.addBook("La Comunidad del Anillo", 30.99);
        tolkien.addBook("Las Dos Torres", 28.99);
        tolkien.addBook("El Retorno del Rey", 32.99);

        // Mostrar información de los libros del autor
        for (Book book : tolkien.getBooks()) {
            System.out.println(book.getInfo());
        }
    }
}