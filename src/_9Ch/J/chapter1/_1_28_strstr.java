package _9Ch.J.chapter1;

public class _1_28_strstr {
	public int strStr(String source, String target) {
		if (source == null || target == null){
			return -1;
		}
		for (int i = 0; i < source.length() - target.length() + 1; i++){
			int j = 0;
			for (j = i; j < target.length(); j++){
				if (source.charAt(i + j) != target.charAt(j)){
					break;
				}
			}
			if (j == target.length()) {
				return i;
			}
		}
		return -1;
	}
}
