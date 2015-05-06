package Sort;

import java.util.Arrays;

/*快速排序算法
 * */
public class Quicksort<T> {
	 
	public static void main(String[] args) {
		int n = 1000;
		long current = System.currentTimeMillis();
		Arrays.sort(getData(n));
		System.out.println(System.currentTimeMillis() -current);
		current = System.currentTimeMillis();
		sort(getData(n),0,n-1);
		System.out.println(System.currentTimeMillis() -current);
	}
	
	public static Integer[] getData(int n){
		Integer data[] = new Integer[n];
		for(int i= n;i>0;i--){
			data[i-1] = i;
		}
		return data;
	}
	
	//最低端的快排，会爆栈，速度竟然比系统的慢了1000倍
	public static <T extends Comparable<? super T>> T[] sort(T[] t,int p,int r){
		int q;
		if(p < r){
			q = partition(t,p,r);
			sort(t,p,q-1);
			sort(t,q+1,r);
		}
		return t;
	}
	public static <T extends Comparable<? super T>> int partition(T[] t,int p,int r){
		T temp;
		T x = t[r];
		int i = p -1;
		for(int j = p;j<r-1;j++){
			if(t[j].compareTo(x) == 1){
				i++;
				temp = t[j];
				t[j] = t[i];
				t[i] = temp;
			}
		}
		temp = t[r];
		t[r] = t[i+1];
		t[i+1] = temp;
		return i+1;
	}
	
}
