import java.util.*;
class FruitTransportation{
static class Edge{
String to;
int weight;
Edge(String to,int weight){
this.to = to;
this.weight = weight;
}
}
static Map<String,List<Edge>> graph = new HashMap<>();
static void addEdge(String from,String to,int weight){
graph.putIfAbsent(from,new ArrayList<>());
graph.putIfAbsent(to,new ArrayList<>());
graph.get(from).add(new Edge(to,weight));
graph.get(to).add(new Edge(from,weight));
}

static void shortestPath(String source,String destination){
Map<String,Integer> distance = new HashMap<>();
Map<String,String> parent = new HashMap<>();
PriorityQueue<String> pq =
                new PriorityQueue<>(Comparator.comparingInt(distance::get));

for(String node : graph.keySet()){
distance.put(node,Integer.MAX_VALUE);
}
distance.put(source,0);
pq.add(source);

while(!pq.isEmpty()){
String current = pq.poll();
for(Edge edge : graph.get(current)){
int newDist = distance.get(current)+edge.weight;

if (newDist < distance.get(edge.to)) {
distance.put(edge.to, newDist);
parent.put(edge.to, current);
pq.add(edge.to);
}
}
}
System.out.println("Shortest Distance: " +
distance.get(destination) + " km");
System.out.print("Path: ");
printPath(parent, destination);
}
static void printPath(Map<String, String> parent, String dest) {
if (!parent.containsKey(dest)) {
System.out.print(dest);
return;
}
printPath(parent, parent.get(dest));
System.out.print(" -> " + dest);
}
public static void main(String[] args) {
addEdge("FruitFarm", "CollectionCenter", 5);
addEdge("FruitFarm", "ColdStorage", 9);
addEdge("CollectionCenter", "DistributionHub", 6);
addEdge("ColdStorage", "DistributionHub", 4);
addEdge("DistributionHub", "CityMarket", 7);
addEdge("ColdStorage", "CityMarket", 12);
Scanner sc = new Scanner(System.in);
System.out.println("Routes available for fruits:");
System.out.println("Apples, Bananas, Mangoes, Oranges");
System.out.println("\nAvailable Locations:");
System.out.println("FruitFarm, CollectionCenter, ColdStorage, DistributionHub, CityMarket");
System.out.print("Enter Fruit Name: ");
String fruit = sc.next();
System.out.print("Enter Source: ");
String source = sc.next();
System.out.print("Enter Destination: ");
String destination = sc.next();
System.out.println("\nFruit: " + fruit);
shortestPath(source, destination);
}
}
