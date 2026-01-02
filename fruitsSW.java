//Fruits into basket using sliding window
import java.util.*;
class fruitsSW{
public static int count(int[] arr,int n){
Map<Integer,Integer> hs =new HashMap<>();
int l=0;
int maxfruit=0;
for(int i=0;i<n;i++){
hs.put(arr[i],hs.getOrDefault(arr[i],0)+1);
while(hs.size()>2){
hs.put(arr[l],hs.get(arr[l])-1);
if(hs.get(arr[l])==0){
hs.remove(arr[l]);
}
l++;
}
maxfruit=Math.max(maxfruit,i-l+1);
}
return maxfruit;
}
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("enter array size");
int n = sc.nextInt();
int arr[] = new int[n];
System.out.println("enter values into array");
for(int i=0;i<n;i++){
arr[i] = sc.nextInt(); 
}
System.out.println("the overall fruits we collected");
System.out.println(count(arr,n));

}
}