//minvalue and maxvalue difference in  each subarray with treemap

import java.util.*;
class classroom33{
public static ArrayList<Integer> minsub(int a[],int n,int k){
ArrayList<Integer> arr = new ArrayList<>();
TreeMap<Integer,Integer> tm1 = new TreeMap<>();
TreeMap<Integer,Integer> tm2 = new TreeMap<>(Collections.reverseOrder());
for(int i=0;i<k;i++){
tm1.put(a[i],tm1.getOrDefault(a[i],0)+1);
tm2.put(a[i],tm2.getOrDefault(a[i],0)+1);
}
arr.add(tm2.firstKey()-tm1.firstKey());
for(int i=1;i<n-k+1;i++){
int in = a[i+k-1];
int out = a[i-1];
tm1.put(in,tm1.getOrDefault(in,0)+1);
tm1.put(out,tm1.get(out)-1);
tm2.put(in,tm2.getOrDefault(in,0)+1);
tm2.put(out,tm2.get(out)-1);
if(tm1.get(out)==0  && tm2.get(out)==0){
tm1.remove(out);
tm2.remove(out);
}
arr.add(tm2.firstKey()-tm1.firstKey());
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
ArrayList<Integer> result = minsub(arr,n,3);
System.out.println("min and max values:"+ result);
}
}