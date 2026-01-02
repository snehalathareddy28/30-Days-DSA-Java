import java.util.*;
class SubjectSelection{
public static void explainSubject(int choice){
switch(choice){
case 1:
 System.out.println("\nEducation Completed: 10th");
 System.out.println("Possible Next Paths:");
 System.out.println("1. Intermediate (MPC / BiPC / CEC / MEC)");
 System.out.println("2. Diploma (Engineering / Polytechnic)");
 System.out.println("3. ITI (Technical courses)");
 break;

 case 2:
 System.out.println("\nEducation Completed: Intermediate");
 System.out.println("Possible Next Paths:");
 System.out.println("1. Bachelor Degree (B.Tech / B.Sc / B.Com / BA)");
 System.out.println("2. Professional Courses");
 System.out.println("3. Competitive Exams");
break;

case 3:
System.out.println("\nEducation Completed: Diploma");
System.out.println("Possible Next Paths:");
System.out.println("1. Lateral Entry B.Tech");
System.out.println("2. Job in Technical Field");
System.out.println("3. Certification Courses");
break;

case 4:
System.out.println("\nEducation Completed: Bachelor Degree");
System.out.println("Possible Next Paths:");
System.out.println("1. Master Degree (M.Tech / MBA / MCA / M.Sc)");
System.out.println("2. Job / Placement");
System.out.println("3. Startup / Entrepreneurship");
break;
case 5:
System.out.println("\nEducation Completed: Master Degree");
System.out.println("Possible Next Paths:");
System.out.println("1. Job / Research");
System.out.println("2. PhD");
System.out.println("3. Teaching / Academics");
break;

default:
System.out.println("Invalid Selection");
}
}
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
 System.out.println("===== STUDENT CAREER GUIDANCE SYSTEM =====");
System.out.print("Enter Student Name: ");
String name = sc.nextLine();
System.out.print("Enter Age: ");
int age = sc.nextInt();

System.out.println("\nSelect Highest Education Completed:");
System.out.println("1. 10th");
System.out.println("2. Intermediate");
System.out.println("3. Diploma");
System.out.println("4. Bachelor Degree");
System.out.println("5. Master Degree");

System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

System.out.println("\n--------------------------------");
System.out.println("Student Name: " + name);
System.out.println("Age: " + age);

explainSubject(choice);
System.out.println("\nGuidance Generated Successfully");
sc.close();
}
}

