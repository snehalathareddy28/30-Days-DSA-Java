//distict value count in subarray brut force
import java.util.*;
class classroom26{
public static int[] find(int a[],int n,int k){
int arr[] = new int[n-k+1];
HashMap<Integer,Integer> hm = new HashMap<>();
for(int i=0;i<k;i++){
hm.put(a[i],hm.getOrDefault(a[i],0)+1);
}
arr[0] = hm.size();

for(int i=1;i<n-k+1;i++){
hm.put(a[i-1],hm.get(a[i-1])-1);
if(hm.get(a[i-1]) == 0){
hm.remove(a[i-1]);
}
hm.put(a[i+k-1],hm.getOrDefault(a[i+k-1],0)+1);
arr[i] = hm.size();
}
return arr;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter size of array");
int n = sc.nextInt();
int a[] = new int[n];
System.out.println("enter the array of elements");
for(int i=0;i<n;i++){
a[i] = sc.nextInt();
}
int result[] = find(a,n,3);
System.out.println("distict value: "+Arrays.toString(result));
}
}

