package Second;

/*二进制中1的个数
 * */
public class First {

	public static void main(String[] args) {
		byte b = 0B01010101;
		System.out.println(count_c(b));
		System.out.println(count_b(b));
		System.out.println(count_m(b));
	}
	
	/*二进制除以2后少一位
	 * 如果二进制余2 = 1则少的1位是1
	 * */
	
	public static int count_c(byte b){
		int num = 0;
		while(b>0){
			if(b %2 == 1){
				num++;
			}
			b = (byte) (b/2);
		}
		return num;
	}
	
	/*二进制右移一位
	 * 如果&00000001等于1 则为 1
	 * */
	
	public static int count_b(byte b){
		int num = 0;
		while(b>0){
			num += b & 0X01;
			b >>= 1;
		}
		return num;
	}
	
	/*01010101 & 01010100 = 01010100
	 * 01010100 & 01010011 = 01010000
	 * 01010000 & 01001111 = 01000000
	 * 01000000 & 00111111 = 00000000
	 * 也就是说b & b-1 就会把一个1变成零
	 * */
	
	public static int count_m(byte b){
		int num = 0;
		while(b>0){
			b &= (b-1);
			num++;
		}
		return num;
	}
	
}
