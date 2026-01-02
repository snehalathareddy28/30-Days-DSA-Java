//minvalue in  each subarray with treemap
import java.util.*;
class classroom22{
public static int[] minsub(int a[],int n,int k){
int arr[] = new int[n-k+1];
int min = 0;
TreeMap<Integer,Integer> tm = new TreeMap<>();
for(int i=0;i<k;i++){
tm.put(a[i],tm.getOrDefault(a[i],0)+1);
}
arr[0] = tm.firstKey();
for(int i=1;i<n-k+1;i++){
tm.put(a[i+k-1],tm.getOrDefault(a[i+k-1],0)+1);
tm.put(a[i-1],tm.get(a[i-1])-1);
if(tm.get(a[i-1])==0){
tm.remove(a[i-1]);
}
arr[i] = tm.firstKey();
}
return arr;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter size of your array");
int n = sc.nextInt();
int arr[] = new int[n];
System.out.println("enter elements array");
for(int i=0;i<n;i++){
arr[i] = sc.nextInt();
}
int result[] = minsub(arr,n,3);
System.out.println("min values:"+ Arrays.toString(result));
}
}