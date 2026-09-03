import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    books.add(new Book(id, title, author));

                    System.out.println("Book added successfully!");
                    break;

                case 2:

                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book book : books) {
                            book.displayBook();
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    boolean found = false;

                    for (Book book : books) {

                        if (book.bookId == id) {
                            book.displayBook();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    found = false;

                    for (Book book : books) {

                        if (book.bookId == id) {

                            found = true;

                            if (book.issued) {
                                System.out.println("Book is already issued!");
                            } else {
                                book.issued = true;
                                System.out.println("Book issued successfully!");
                            }

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    found = false;

                    for (Book book : books) {

                        if (book.bookId == id) {

                            found = true;

                            if (!book.issued) {
                                System.out.println("Book is already available!");
                            } else {
                                book.issued = false;
                                System.out.println("Book returned successfully!");
                            }

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    id = sc.nextInt();

                    found = false;

                    for (Book book : books) {

                        if (book.bookId == id) {
                            books.remove(book);
                            System.out.println("Book deleted successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }

                    break;

                case 7:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}