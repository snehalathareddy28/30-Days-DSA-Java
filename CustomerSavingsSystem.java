import java.util.*;
class Customer {
int id;
String name;
double monthlyAmount;
int totalMonths;
int paidMonths = 0;
double interestRate;
Customer(int id, String name, double monthlyAmount, int years, double interestRate) {
this.id = id;
this.name = name;
this.monthlyAmount = monthlyAmount;
this.totalMonths = years * 12;
this.interestRate = interestRate;
}
boolean payMonthly() {
if (paidMonths >= totalMonths) {
return false; 
}
paidMonths++;
return true;
}
void showDetails() {
double deposited = paidMonths * monthlyAmount;
double interest = (paidMonths == totalMonths)
? deposited * interestRate / 100: 0;
System.out.println("\n--- Customer Details ---");
System.out.println("ID: " + id);
System.out.println("Name: " + name);
System.out.println("Monthly Amount: ₹" + monthlyAmount);
System.out.println("Paid Months: " + paidMonths + "/" + totalMonths);
System.out.println("Total Deposited: ₹" + deposited);
if (paidMonths == totalMonths) {
System.out.println("Interest: ₹" + interest);
System.out.println("Maturity Amount: ₹" + (deposited + interest));
} else {
System.out.println("Plan Status: Active");
}
}
}
public class CustomerSavingsSystem {
static HashMap<Integer, Customer> customers = new HashMap<>();
static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
while (true) {
System.out.println("\n===== CUSTOMER SAVINGS MENU =====");
System.out.println("1. Register Customer");
System.out.println("2. Pay Monthly Amount");
System.out.println("3. Check Customer Details");
System.out.println("4. Exit");
System.out.print("Choose option: ");
int choice = sc.nextInt();
switch (choice) {
case 1 -> registerCustomer();
case 2 -> payAmount();
case 3 -> checkDetails();
case 4 -> {
System.out.println("Thank you!");
return;
}
default -> System.out.println("Invalid choice!");
}
}
}
static void registerCustomer() {
System.out.print("Enter ID: ");
int id = sc.nextInt();
if (customers.containsKey(id)) {
System.out.println("Customer already exists!");
return;
}
sc.nextLine();
System.out.print("Enter Name: ");
String name = sc.nextLine();
System.out.print("Monthly Amount: ");
double amt = sc.nextDouble();
System.out.print("Duration (years): ");
int years = sc.nextInt();
System.out.print("Interest Rate (%): ");
double rate = sc.nextDouble();
customers.put(id, new Customer(id, name, amt, years, rate));
System.out.println("Customer Registered Successfully!");
}
static void payAmount() {
System.out.print("Enter Customer ID: ");
int id = sc.nextInt();
Customer c = customers.get(id);
if (c == null) {
System.out.println("Customer not found!");
return;
}
if (c.payMonthly()) {
System.out.println("Payment successful for month " + c.paidMonths);
} else {
System.out.println(" Plan completed. Payment not accepted.");
}
}
static void checkDetails() {
System.out.print("Enter Customer ID: ");
int id = sc.nextInt();
Customer c = customers.get(id);
if (c == null) {
System.out.println("Customer not found!");
} else {
c.showDetails();
}
}
}
