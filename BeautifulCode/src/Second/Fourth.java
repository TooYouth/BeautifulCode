package Second;
/*寻找1的个数
 * */
public class Fourth {

	public static void main(String[] args) {
		int n = 1000000000;
		long currentTime = System.currentTimeMillis();
		System.out.println(method1(n));
		System.out.println(System.currentTimeMillis() - currentTime);
		currentTime = System.currentTimeMillis();
		System.out.println(method2(n));
		System.out.println(System.currentTimeMillis() - currentTime);
	}
	//普通的循环判断
	private static int method1(int n){
		int count = 0;
		for(int i=1;i<=n;i++){
			int num = i;
			while(num!=0){
				count += (num%10 == 1)?1:0;
				num /=10;
			}
			
		}
		return count;
	}
	

	private static int method2(int n){
		int res = 0;
		int num = 1;
		while(n/num != 0){
			int currentNumLast = n - (n/num)*num;
			int currentNum = (n / num)%10;
			int currentNumTimes = n/(num*10);
			if(currentNum == 0){
				res += currentNumTimes * num;
			}else if(currentNum == 1){
				res += currentNumTimes * num + currentNumLast + 1;
			}else{
				res += (currentNumTimes+1) * num;
			}
			num *= 10;
		}
		return res;
	}
	
}
