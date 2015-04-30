package Third;

public class first {

	public static void main(String[] args) {
		String str1 = "AABCD";
		String str2 = "CDAA";
		System.out.println(isContain(str1,str2));
		System.out.println(isContainKMP("BBC ABCDAB ABCDABCDABDE","ABCDABD"));
	}
	
	/*��ѭ��չ���������������str1+str1;
	 * �޳ܵ�������java������
	 * */
	public static boolean isContain(String str1,String str2){
		String string  = str1 + str1;
		return string.contains(str2);
	}
	
	
	/*��ʵ�ֿ���kmp 
	 * */
	public static boolean isContainKMP(String str1,String str2){
		int n = getStringInfo(str2);
		int j;
		for(int i=0;i<str1.length();){
			j = 0;
			for(;j<str2.length();j++){
				if(str1.charAt(i+j) == str2.charAt(j)){
					if(j == str2.length() -1){
						return true;
					}else{
						continue;
					}
				}else{
					if(j < n){
						i = i + j + 1;
						break;
					}else{
						i = i + n;
						break;
					}
				}
			}
		}
		return false;
	}
	
	//kmp��ģʽ���ظ���Ϣ
	private static int getStringInfo(String str2){
		int i =1;
		for(;i<str2.length();i++){
			if(str2.charAt(0) == str2.charAt(i)){
				return i;
			}
		}
		return i;
	}
}
