import java.util.*;
class StoryNode{
String text;
Map<String,StoryNode>choices;
StoryNode(String text){
this.text=text;choices=new LinkedHashMap<>();
}
void addChoice(String option,StoryNode node){
choices.put(option,node);
}
}
public class MultiGenreStory{
public static void playStory(StoryNode node,Scanner sc){
while(true){
System.out.println("\n"+node.text);
if(node.choices.isEmpty()){System.out.println("\n--- The End ---");
break;
}
System.out.println("\nChoices:");
int i=1;
List<String>keys=new ArrayList<>(node.choices.keySet());
for(String key:keys){System.out.println(i+". "+key);i++;}
System.out.print("Enter choice number: ");
int choice=sc.nextInt();
if(choice<1||choice>keys.size()){System.out.println("Invalid choice! Try again.");continue;}
node=node.choices.get(keys.get(choice-1));
}
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Choose a genre:");
System.out.println("1.Sad\n2.Happy\n3.Joke\n4.Mystery\n5.Thriller");
int genreChoice=sc.nextInt();
StoryNode start=null;
switch(genreChoice){
case 1:
start=new StoryNode("A lonely traveler walks through a deserted town.");
StoryNode meetStranger=new StoryNode("He meets a stranger who shares a sad story of loss.");
StoryNode reflection=new StoryNode("He reflects on life and feels a bittersweet sorrow.");
start.addChoice("Listen to the stranger",meetStranger);
meetStranger.addChoice("Contemplate alone",reflection);
break;
case 2:
start=new StoryNode("A child finds a puppy in the park.");
StoryNode play=new StoryNode("They play together happily for hours.");
StoryNode adopt=new StoryNode("The child adopts the puppy and they become best friends.");
start.addChoice("Play with puppy",play);
play.addChoice("Adopt the puppy",adopt);
break;
case 3:
start=new StoryNode("A programmer walks into a bar...");
StoryNode bartender=new StoryNode("The bartender says: 'Why so serious?'");
StoryNode punchline=new StoryNode("Programmer replies: 'I just lost my semicolon!");
start.addChoice("Continue story",bartender);
bartender.addChoice("Hear the punchline",punchline);
break;
case 4:
start=new StoryNode("A detective receives an anonymous tip about a hidden treasure.");
StoryNode search=new StoryNode("He searches the old mansion at midnight.");
StoryNode discovery=new StoryNode("He finds a secret room with mysterious clues leading to the treasure.");
start.addChoice("Investigate mansion",search);
search.addChoice("Follow clues",discovery);
break;
case 5:
start=new StoryNode("You wake up in a dark room with no memory of how you got there.");
StoryNode exploreRoom=new StoryNode("You hear footsteps and shadows moving.");
StoryNode escape=new StoryNode("You find a hidden exit and barely escape as alarms go off!");
start.addChoice("Explore the room",exploreRoom);
exploreRoom.addChoice("Try to escape",escape);
break;
default:
System.out.println("Invalid choice! Exiting...");
System.exit(0);
}
playStory(start,sc);
}
}
