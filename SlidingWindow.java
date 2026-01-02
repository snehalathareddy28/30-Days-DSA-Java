//variable sliding window 
import java.util.*;
class SlidingWindow{
public static int check(int a[],int n,int target){
int res  = 0 ;
int csum = 0;
Map<Integer,Integer> hm = new HashMap<>();
for(int i=0;i<n;i++){
csum = csum+a[i];
if(csum == target){
res = i+1;
}
else if(hm.containsKey(csum-target)){
int len = i-hm.get(csum-target);
if(len>res){
res=len;
}
}
if(!hm.containsKey(csum)){
hm.put(csum,i);
}
}
return res;
}

public static void main(String...args){
int a[] = {-5,8,-14,2,4,12};
int n = a.length;
int k = -5;
System.out.println("count of longest subarray : "+check(a,n,k));
}
}