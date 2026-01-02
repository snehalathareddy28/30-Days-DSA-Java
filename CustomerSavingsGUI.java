                                                                                                                                                                                                                                                      import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

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

    String getDetails() {
        double deposited = paidMonths * monthlyAmount;
        String details =
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Monthly Amount: ₹" + monthlyAmount + "\n" +
                "Paid Months: " + paidMonths + "/" + totalMonths + "\n" +
                "Total Deposited: ₹" + deposited + "\n";

        if (paidMonths == totalMonths) {
            double interest = deposited * interestRate / 100;
            details += "Interest: ₹" + interest + "\n";
            details += "Maturity Amount: ₹" + (deposited + interest);
        } else {
            details += "Status: Active";
        }
        return details;
    }
}

public class CustomerSavingsGUI extends JFrame {

    HashMap<Integer, Customer> customers = new HashMap<>();

    JTextField idField, nameField, amountField, yearsField, rateField;
    JTextArea outputArea;

    public CustomerSavingsGUI() {

        setTitle("Customer Savings Management System");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        inputPanel.add(new JLabel("Customer ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Monthly Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Duration (Years):"));
        yearsField = new JTextField();
        inputPanel.add(yearsField);

        inputPanel.add(new JLabel("Interest Rate (%):"));
        rateField = new JTextField();
        inputPanel.add(rateField);

        JButton registerBtn = new JButton("Register Customer");
        JButton payBtn = new JButton("Pay Monthly Amount");
        JButton checkBtn = new JButton("Check Details");

        inputPanel.add(registerBtn);
        inputPanel.add(payBtn);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(checkBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Register Button
        registerBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            if (customers.containsKey(id)) {
                outputArea.setText("Customer already exists!");
                return;
            }

            String name = nameField.getText();
            double amt = Double.parseDouble(amountField.getText());
            int years = Integer.parseInt(yearsField.getText());
            double rate = Double.parseDouble(rateField.getText());

            customers.put(id, new Customer(id, name, amt, years, rate));
            outputArea.setText("Customer Registered Successfully!");
        });

        // Pay Button
        payBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Customer c = customers.get(id);

            if (c == null) {
                outputArea.setText("Customer not found!");
                return;
            }

            if (c.payMonthly()) {
                outputArea.setText("Payment successful for month: " + c.paidMonths);
            } else {
                outputArea.setText("❌ Plan completed. Payment not accepted.");
            }
        });

        // Check Details Button
        checkBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Customer c = customers.get(id);

            if (c == null) {
                outputArea.setText("Customer not found!");
            } else {
                outputArea.setText(c.getDetails());
            }
        });
    }

    public static void main(String[] args) {
        new CustomerSavingsGUI().setVisible(true);
    }
}
