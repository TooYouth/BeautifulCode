package Second;

/*给定一个数的N,求N的阶乘的末尾有多少个0
 * 
 * */


public class Second {
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(first(n));
		System.out.println(second(n));
	}
	
	/*n! = n * (n-1) * ..... * 2 * 1;
	 * 循环每一个数，求它对5的贡献个数
	 * */
	public static int first(int n){
		int res = 0;
		for(int i =1 ;i<=n;i++){
			int j = i;
			while(j % 5 == 0){
				res++;
				j /= 5;
			}
		}
		return res;
	}
	
	/*z = n/5 + n/5^2 +......
	 * 统计可以先贡献一个5的数，之后在统计还可以贡献一个5的数。。。。
	 * */
	public static int  second(int n){
		int res = 0;
		while(n > 0){
			res += n/5;
			n = n/5;
		}
		return res;
	}
}
