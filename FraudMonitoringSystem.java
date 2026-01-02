import java.util.*;

public class FraudMonitoringSystem {

static class Transaction {
String userId;
int amount;

Transaction(String userId, int amount) {
this.userId = userId;
this.amount = amount;
}
}

static Map<String, List<Transaction>> transactionDB = new HashMap<>();

public static void addTransaction(String userId, int amount) {
transactionDB.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Transaction(userId, amount));
}

public static void detectFraud(String userId, int windowSize, int limit) {

List<Transaction> transactions = transactionDB.get(userId);
if (transactions == null || transactions.size() < windowSize) {
return;
}

Deque<Integer> window = new ArrayDeque<>();
int windowSum = 0;

for (Transaction tx : transactions) {
window.addLast(tx.amount);
windowSum += tx.amount;

if (window.size() > windowSize) {
windowSum -= window.removeFirst();
}

if (windowSum > limit) {
System.out.println("FRAUD ALERT");
System.out.println("User: " + userId);
System.out.println("Recent Transaction Sum: " + windowSum);
System.out.println("----------------------");
return;
}
}
}

public static void main(String[] args) {

addTransaction("USER101", 5000);
addTransaction("USER101", 8000);
addTransaction("USER101", 7000);
addTransaction("USER101", 4000);

addTransaction("USER202", 2000);
addTransaction("USER202", 3000);
addTransaction("USER202", 2500);

int windowSize = 3;
int riskLimit = 18000;

detectFraud("USER101", windowSize, riskLimit);
detectFraud("USER202", windowSize, riskLimit);
}
}
