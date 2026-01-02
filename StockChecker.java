import java.util.*;
class Item {
    int quantity;
    String imagePath;

    Item(int quantity, String imagePath) {
        this.quantity = quantity;
        this.imagePath = imagePath;
    }
}
public class StockChecker{
public static void Check(HashMap<String,Integer> arr,int n){
int TotalStock = 0;
for (Map.Entry<String,Integer> entry : arr.entrySet()) {
String itemName = entry.getKey();
int qty = entry.getValue();
TotalStock += qty;
if(qty==0){
System.out.println(itemName+" is out of Stock");
}
else if(qty<5){
System.out.println(itemName+" is low in Stock(qty:"+qty+")");
}
}
System.out.println("-------------------");
System.out.println("Total Inventory Stock :"+TotalStock);
}
public static void  main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter how many different stock you want to enter:");
int n = sc.nextInt();
sc.nextLine();
HashMap<String,Integer> stock = new HashMap<>();
for(int i=0;i<n;i++){
System.out.println("enter item name:");
String item = sc.nextLine();

System.out.print("enter quantity:");
int qty = sc.nextInt();
sc.nextLine();
stock.put(item,stock.getOrDefault(item,0)+qty);
}
System.out.println("============");
System.out.println("Final Stock List:"+stock);
Check(stock,n);
}
}