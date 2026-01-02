import java.util.*;

public class LibraryManagementSystem {

static class Book {
int id;
String title;
String author;
boolean issued;

Book(int id,String title,String author){
this.id=id;
this.title=title;
this.author=author;
this.issued=false;
}
}

static class Student {
int studentId;
String name;
List<Book> issuedBooks=new ArrayList<>();

Student(int studentId,String name){
this.studentId=studentId;
this.name=name;
}
}

static Map<Integer,Book> books=new HashMap<>();
static Map<Integer,Student> students=new HashMap<>();
static Scanner sc=new Scanner(System.in);

public static void addBook(){
System.out.print("Enter Book ID: ");
int id=sc.nextInt();
sc.nextLine();
System.out.print("Enter Book Title: ");
String title=sc.nextLine();
System.out.print("Enter Author Name: ");
String author=sc.nextLine();
books.put(id,new Book(id,title,author));
System.out.println("Book added successfully");
}

public static void registerStudent(){
System.out.print("Enter Student ID: ");
int id=sc.nextInt();
sc.nextLine();
System.out.print("Enter Student Name: ");
String name=sc.nextLine();
students.put(id,new Student(id,name));
System.out.println("Student registered successfully");
}

public static void issueBook(){
System.out.print("Enter Book ID: ");
int bookId=sc.nextInt();
System.out.print("Enter Student ID: ");
int studentId=sc.nextInt();

Book book=books.get(bookId);
Student student=students.get(studentId);

if(book==null||student==null){
System.out.println("Invalid book or student ID");
return;
}

if(book.issued){
System.out.println("Book already issued");
return;
}

book.issued=true;
student.issuedBooks.add(book);
System.out.println("Book issued successfully");
}

public static void returnBook(){
System.out.print("Enter Book ID: ");
int bookId=sc.nextInt();
System.out.print("Enter Student ID: ");
int studentId=sc.nextInt();

Book book=books.get(bookId);
Student student=students.get(studentId);

if(book==null||student==null){
System.out.println("Invalid book or student ID");
return;
}

if(student.issuedBooks.remove(book)){
book.issued=false;
System.out.println("Book returned successfully");
}else{
System.out.println("Book was not issued to this student");
}
}

public static void displayBooks(){
System.out.println("\nLibrary Books:");
for(Book b:books.values()){
System.out.println(b.id+" | "+b.title+" | "+b.author+" | Issued: "+b.issued);
}
}

public static void menu(){
System.out.println("\n1.Add Book");
System.out.println("2.Register Student");
System.out.println("3.Issue Book");
System.out.println("4.Return Book");
System.out.println("5.Display Books");
System.out.println("6.Exit");
System.out.print("Enter choice: ");
}

public static void main(String[] args){

while(true){
menu();
int choice=sc.nextInt();

switch(choice){
case 1:addBook();break;
case 2:registerStudent();break;
case 3:issueBook();break;
case 4:returnBook();break;
case 5:displayBooks();break;
case 6:System.out.println("Exiting system");return;
default:System.out.println("Invalid choice");
}
}
}
}
