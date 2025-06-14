package librarysystem;

import java.time.LocalDate;
import java.util.*;

abstract class Member {
    UUID memberID;
    String name, email, phone;
    int maxBooksAllowed;
    List<Book> currentlyIssuedBooks = new ArrayList<>();

    public Member(String name, String email, String phone) {
        this.memberID = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    abstract int getMaxAllowedDays();
    abstract String getMemberType();

    public boolean canIssueMoreBooks() {
        return currentlyIssuedBooks.size() < maxBooksAllowed;
    }
}

class StudentMember extends Member {
    public StudentMember(String name, String email, String phone) {
        super(name, email, phone);
        this.maxBooksAllowed = 3;
    }

    int getMaxAllowedDays() { return 14; }
    String getMemberType() { return "Student"; }
}

class Librarian extends Member {
    public Librarian(String name, String email, String phone) {
        super(name, email, phone);
        this.maxBooksAllowed = Integer.MAX_VALUE;
    }

    int getMaxAllowedDays() { return 0; }
    String getMemberType() { return "Librarian"; }

    public void addBook(Book book, List<Book> library) {
        library.add(book);
        System.out.println("Book added successfully.");
    }

    public void registerMember(Member member, List<Member> members) {
        members.add(member);
        System.out.println("Member registered successfully.");
    }
}

class Book {
    UUID bookID;
    String title, author, genre;
    boolean isIssued = false;
    Member issuedTo = null;
    LocalDate dueDate = null;
    Queue<Member> reservationQueue = new LinkedList<>();

    public Book(String title, String author, String genre) {
        this.bookID = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

	public Book(String title2, String author2, String genre2, String keyword) {
		// TODO Auto-generated constructor stub
	}
}

class LibraryService {
    List<Book> library = new ArrayList<>();
    List<Member> members = new ArrayList<>();

    public void issueBook(Book book, Member member) {
        if (!book.isIssued && member.canIssueMoreBooks()) {
            book.isIssued = true;
            book.issuedTo = member;
            book.dueDate = LocalDate.now().plusDays(member.getMaxAllowedDays());
            member.currentlyIssuedBooks.add(book);
            System.out.println("Book issued to " + member.name);
        } else {
            System.out.println("Cannot issue. Already issued or limit reached.");
        }
    }

    public void returnBook(Book book, Member member) {
        if (book.issuedTo != null && book.issuedTo.equals(member)) {
            member.currentlyIssuedBooks.remove(book);
            book.isIssued = false;
            book.issuedTo = null;
            book.dueDate = null;
            System.out.println("Book returned.");

            if (!book.reservationQueue.isEmpty()) {
                Member next = book.reservationQueue.poll();
                issueBook(book, next);
                System.out.println("Book assigned to next reserved member: " + next.name);
            }
        }
    }

    public void searchBooks(String keyword) {
        boolean found = false;
        for (Book b : library) {
            if (b.title.contains(keyword) || b.author.contains(keyword) || b.genre.contains(keyword)) {
                System.out.println("Found: " + b.title + " by " + b.author);
                found = true;
            }
        }
        if (!found) System.out.println("No books found.");
    }

    public void reserveBook(Book book, Member member) {
        if (book.isIssued) {
            book.reservationQueue.add(member);
            System.out.println("Book reserved.");
        } else {
            System.out.println("Book is available, no need to reserve.");
        }
    }

    public void viewIssuedBooks(Member member) {
        for (Book b : member.currentlyIssuedBooks) {
            System.out.println(b.title + " | Due: " + b.dueDate);
        }
    }

    public Member findMemberByName(String name) {
        for (Member m : members) {
            if (m.name.equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (Book b : library) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    public void viewAllBooks() {
        for (Book b : library) {
            System.out.println(b.title + " | " + (b.isIssued ? "Issued to " + b.issuedTo.name : "Available"));
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();
        Librarian librarian = new Librarian("Admin", "admin@lib.com", "9999999999");

        while (true) {
            System.out.println("\n----- LIBRARY MENU -----");
            System.out.println("1. Add Book");
            System.out.println("2. Register Student");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Reserve Book");
            System.out.println("7. View All Books");
            System.out.println("8. View Member's Issued Books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
               
                    librarian.addBook(new Book(title, author, genre), service.library);
                    break;

                case 2:
                    System.out.print("Student Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Email: ");
                    String sEmail = sc.nextLine();
                    System.out.print("Phone: ");
                    String sPhone = sc.nextLine();
                    StudentMember student = new StudentMember(sName, sEmail, sPhone);
                    librarian.registerMember(student, service.members);
                    break;

                case 3:
                    System.out.print("Member Name: ");
                    String mName = sc.nextLine();
                    Member member = service.findMemberByName(mName);
                    if (member == null) {
                        System.out.println("Member not found.");
                        break;
                    }
                    System.out.print("Book Title: ");
                    String t = sc.nextLine();
                    Book book = service.findBookByTitle(t);
                    if (book == null) {
                        System.out.println("Book not found.");
                        break;
                    }
                    service.issueBook(book, member);
                    break;

                case 4:
                    System.out.print("Member Name: ");
                    mName = sc.nextLine();
                    member = service.findMemberByName(mName);
                    if (member == null) {
                        System.out.println("Member not found.");
                        break;
                    }
                    System.out.print("Book Title: ");
                    t = sc.nextLine();
                    book = service.findBookByTitle(t);
                    if (book == null) {
                        System.out.println("Book not found.");
                        break;
                    }
                    service.returnBook(book, member);
                    break;

                case 5:
                    System.out.print("Book Title: ");
                    t = sc.nextLine();
                    book = service.findBookByTitle(t);
                    if (book == null) {
                        System.out.println("Book not found");
                    } else {
                        System.out.println("Book Available");
                    }
                    break;

                case 6:
                    System.out.print("Member Name: ");
                    mName = sc.nextLine();
                    member = service.findMemberByName(mName);
                    if (member == null) {
                        System.out.println("Member not found.");
                        break;
                    }
                    System.out.print("Book Title: ");
                    t = sc.nextLine();
                    book = service.findBookByTitle(t);
                    if (book == null) {
                        System.out.println("Book not found.");
                        break;
                    }
                    service.reserveBook(book, member);
                    break;

                case 7:
                    service.viewAllBooks();
                    break;

                case 8:
                    System.out.print("Member Name: ");
                    mName = sc.nextLine();
                    member = service.findMemberByName(mName);
                    if (member != null) {
                        service.viewIssuedBooks(member);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
