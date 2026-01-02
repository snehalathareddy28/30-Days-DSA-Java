//minvalue and maxvalue in  each subarray with treemap

import java.util.*;
class classroom25{
public static ArrayList<ArrayList<Integer>> minsub(int a[],int n,int k){
ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
TreeMap<Integer,Integer> tm1 = new TreeMap<>();
TreeMap<Integer,Integer> tm2 = new TreeMap<>(Collections.reverseOrder());
for(int i=0;i<k;i++){
tm1.put(a[i],tm1.getOrDefault(a[i],0)+1);
tm2.put(a[i],tm2.getOrDefault(a[i],0)+1);
}
ArrayList<Integer> arr1 = new ArrayList<>();
arr1.add(tm1.firstKey());
arr1.add(tm2.firstKey());
arr.add(arr1);

for(int i=1;i<n-k+1;i++){
tm1.put(a[i+k-1],tm1.getOrDefault(a[i+k-1],0)+1);
tm1.put(a[i-1],tm1.get(a[i-1])-1);
tm2.put(a[i+k-1],tm2.getOrDefault(a[i+k-1],0)+1);
tm2.put(a[i-1],tm2.get(a[i-1])-1);
if(tm1.get(a[i-1])==0  && tm2.get(a[i-1])==0){
tm1.remove(a[i-1]);
tm2.remove(a[i-1]);
}
ArrayList<Integer> temp = new ArrayList<>();
temp.add(tm1.firstKey());
temp.add(tm2.firstKey());
arr.add(temp);
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
ArrayList<ArrayList<Integer>> result = minsub(arr,n,3);
System.out.println("min and max values:"+ result);
}
}