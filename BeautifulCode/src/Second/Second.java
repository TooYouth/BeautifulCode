package Second;

/*����һ������N,��N�Ľ׳˵�ĩβ�ж��ٸ�0
 * 
 * */


public class Second {
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(first(n));
		System.out.println(second(n));
	}
	
	/*n! = n * (n-1) * ..... * 2 * 1;
	 * ѭ��ÿһ������������5�Ĺ��׸���
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
	 * ͳ�ƿ����ȹ���һ��5������֮����ͳ�ƻ����Թ���һ��5������������
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
