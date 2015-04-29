package Second;

/*��������1�ĸ���
 * */
public class First {

	public static void main(String[] args) {
		byte b = 0B01010101;
		System.out.println(count_c(b));
		System.out.println(count_b(b));
		System.out.println(count_m(b));
	}
	
	/*�����Ƴ���2����һλ
	 * �����������2 = 1���ٵ�1λ��1
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
	
	/*����������һλ
	 * ���&00000001����1 ��Ϊ 1
	 * */
	
	public static int count_b(byte b){
		int num = 0;
		while(b>0){
			num += b & 0X01;
			b >>= 1;
		}
		return num;
	}
	
	/*
	 * 
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
