//count of zeros in substring brute force
import java.util.*;
class classroom17{
public static int[] find(String arr,int n,int k){
char c[] = arr.toCharArray();
int arr1[] = new int[n-k+1];
for(int i=0;i<n-k;i++){
int sum=0;
for(int j=i;j<i+k;j++){
if(c[j] == '0')
sum++;
}
arr1[i]=sum;
}
return arr1;
}
public static void main(String...args){
Scanner sc = new Scanner(System.in);
System.out.println("enter the string");
String arr = sc.nextLine();
int n = arr.length();
int result[] = find(arr,n,3);
System.out.println("distict value: "+Arrays.toString(result));
}
}

