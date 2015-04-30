package Third;

public class first {

	public static void main(String[] args) {
		String str1 = "AABCD";
		String str2 = "CDAA";
		System.out.println(isContain(str1,str2));
		System.out.println(isContainKMP("BBC ABCDAB ABCDABCDABDE","ABCDABD"));
	}
	
	/*将循环展开，包含所有情况str1+str1;
	 * 无耻的利用了java的优势
	 * */
	public static boolean isContain(String str1,String str2){
		String string  = str1 + str1;
		return string.contains(str2);
	}
	
	
	/*自实现快速kmp 
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
	
	//kmp的模式串重复信息
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
