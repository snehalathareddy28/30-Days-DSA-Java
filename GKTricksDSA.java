//Day10 of 30Days
import java.util.*;

public class GKTricksDSA{
static HashMap<String,ArrayList<String>> tricks=new HashMap<>();

static void loadData(){
ArrayList<String> geo=new ArrayList<>();
geo.add("7 Continents: A E A A E A A");
geo.add("Largest Continent: Asia");
geo.add("Indian rivers flowing east: M G K G");
tricks.put("Geography",geo);

ArrayList<String> math=new ArrayList<>();
math.add("Square of numbers ending with 5: n(n+1)25");
math.add("25% = 1/4 , 50% = 1/2");
math.add("Multiply by 9 using finger trick");
tricks.put("Math",math);

ArrayList<String> history=new ArrayList<>();
history.add("Mughal rulers order: B H A J S A");
history.add("1857: First War of Independence");
tricks.put("History",history);

ArrayList<String> science=new ArrayList<>();
science.add("Rainbow colors: VIBGYOR");
science.add("Distance = Speed x Time");
science.add("Planets order: My Very Educated Mother Just Served Us Nachos");
tricks.put("Science",science);

ArrayList<String> memory=new ArrayList<>();
memory.add("Chunk information to remember faster");
memory.add("Associate images with information");
memory.add("Teach others to retain better");
tricks.put("Memory",memory);
}

public static void main(String[] args){
loadData();
Scanner sc=new Scanner(System.in);
System.out.println("GENERAL KNOWLEDGE TRICKS USING DSA");
System.out.println("Enter a topic (Geography/Math/History/Science/Memory):");
String topic=sc.nextLine();
if(tricks.containsKey(topic)){
for(String t:tricks.get(topic))
System.out.println("- "+t);
}else{
System.out.println("Topic not found");
}
}
}
