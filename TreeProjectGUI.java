import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Student {
int roll;
String name;
int marks;
Student(int roll, String name, int marks) {
this.roll = roll;
this.name = name;
this.marks = marks;
}
}

class TreeNode {
Student data;
TreeNode left, right;
TreeNode(Student data) {
this.data = data;
}
}

class StudentBST {
TreeNode root;

void insert(Student s) {
root = insertRec(root, s);
}

TreeNode insertRec(TreeNode node, Student s) {
if (node == null)
return new TreeNode(s);

if (s.roll < node.data.roll)
node.left = insertRec(node.left, s);
else if (s.roll > node.data.roll)
node.right = insertRec(node.right, s);
return node;
}

Student search(int roll) {
TreeNode curr = root;
while (curr != null) {
if (roll == curr.data.roll)
return curr.data;
else if (roll < curr.data.roll)
curr = curr.left;
else
curr = curr.right;
}
return null;
}

void inorder(TreeNode node, StringBuilder sb) {
if (node == null) return;
inorder(node.left, sb);
sb.append("Roll: ").append(node.data.roll)
.append(", Name: ").append(node.data.name)
.append(", Marks: ").append(node.data.marks)
.append("\n");
inorder(node.right, sb);
}
}

public class TreeProjectGUI extends JFrame {
StudentBST bst = new StudentBST();
JTextArea output = new JTextArea(10, 30);

public TreeProjectGUI() {
setTitle("Student Result Management (Tree)");
setSize(400, 400);
setLayout(new FlowLayout());
setDefaultCloseOperation(EXIT_ON_CLOSE);

JTextField rollField = new JTextField(5);
JTextField nameField = new JTextField(8);
JTextField marksField = new JTextField(5);

JButton addBtn = new JButton("Add Student");
JButton searchBtn = new JButton("Search");
JButton displayBtn = new JButton("Display All");

add(new JLabel("Roll"));
add(rollField);
add(new JLabel("Name"));
add(nameField);
add(new JLabel("Marks"));
add(marksField);

add(addBtn);
add(searchBtn);
add(displayBtn);

output.setEditable(false);
add(new JScrollPane(output));

addBtn.addActionListener(e -> {
int roll = Integer.parseInt(rollField.getText());
String name = nameField.getText();
int marks = Integer.parseInt(marksField.getText());

bst.insert(new Student(roll, name, marks));
output.setText("Student Added!\n");
});

searchBtn.addActionListener(e -> {
int roll = Integer.parseInt(rollField.getText());
Student s = bst.search(roll);

if (s != null)
output.setText("Found:\n" + s.roll + " " + s.name + " " + s.marks);
else
output.setText("Student Not Found!");
});

displayBtn.addActionListener(e -> {
StringBuilder sb = new StringBuilder();
bst.inorder(bst.root, sb);
output.setText(sb.toString());
});

setVisible(true);
}

public static void main(String[] args) {
new TreeProjectGUI();
 }
}
