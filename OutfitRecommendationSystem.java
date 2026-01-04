import java.util.*;

public class OutfitRecommendationSystem {

public static void main(String[] args) {

Scanner sc=new Scanner(System.in);

HashMap<String,ArrayList<String>> outfits=new HashMap<>();

outfits.put("Party",new ArrayList<>(Arrays.asList("Gown","Cocktail Dress","Suit")));
outfits.put("Casual",new ArrayList<>(Arrays.asList("Jeans","T-Shirt","Sneakers")));
outfits.put("Traditional",new ArrayList<>(Arrays.asList("Saree","Kurta","Lehenga")));

int choice;

do{
System.out.println("\n--- Outfit Recommendation Menu ---");
System.out.println("1.Get Outfit Recommendation");
System.out.println("2.Add New Outfit");
System.out.println("3.Search Outfit");
System.out.println("4.Exit");
System.out.print("Enter choice: ");
choice=sc.nextInt();
sc.nextLine();

if(choice==1){

System.out.println("\nChoose Occasion:");
System.out.println("Party | Casual | Traditional");
String occasion=sc.nextLine();

if(outfits.containsKey(occasion)){
System.out.println("Recommended outfits:");
for(String item:outfits.get(occasion)){
System.out.println("- "+item);
}
}else{
System.out.println("No data available for this occasion.");
}
}

else if(choice==2){

System.out.print("Enter Occasion: ");
String occasion=sc.nextLine();

System.out.print("Enter Outfit Name: ");
String newOutfit=sc.nextLine();

outfits.putIfAbsent(occasion,new ArrayList<>());
outfits.get(occasion).add(newOutfit);

System.out.println("Outfit added successfully!");
}

else if(choice==3){

System.out.print("Enter outfit name to search: ");
String search=sc.nextLine();
boolean found=false;

for(String key:outfits.keySet()){
if(outfits.get(key).contains(search)){
System.out.println(search+" is suitable for "+key+" occasion.");
found=true;
}
}

if(!found){
System.out.println("Outfit not found.");
}
}

else if(choice==4){
System.out.println("Thank you for using the system!");
}

else{
System.out.println("Invalid choice.");
}

}while(choice!=4);

}
}
