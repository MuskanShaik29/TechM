class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "John Smith");
        book.display();
    }
}
