package First;

/*中国将帅问题
 * 共有81种情况
 * 采取的策略是一方动，另一方循环
 * i/9 相当于不懂
 * i%9 相当于循环
 * 最后都余3，判断是否在同一列
 * */
public class Second {
	
	public static void main(String[] args) {
		
		byte i = 81;
		while(i-- > 0){
			if(i/9%3 == i%9%3) continue;
			System.out.println("A = "+(i/9+1)+" B = "+(i%9+1));
		}
	}
}
