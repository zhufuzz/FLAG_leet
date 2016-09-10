package ch9J.chapter5_DP2;

//9Ch summer 2016
//大区间依赖于小区间
class _02Palindrome_Partitioning_II_2016{
	/*
	public int minCut(String s){

		//i依赖比较大的，j依赖比较小的，所以循环i从大往小，循环j从小往大
		for(int i = n - 1; i >= 0; i--){
			for(int j = i + 1; j < n; j++){
				f[i][j] = f[i + 1][j - 1] && s[i] == s[j];
			}
		}
	
		//f[i][j] <- f[i + 1][j - 1];
		
		//delta = j - i  区间长度
		//(0, n - 1)
		for(int delta = 1; delta < n; delta++){
			for(int i = 0; i < n; i++){
				int j = i + delta;
				f[i][j] = f[i + 1][j - 1] && s[i] == s[j];
			}
		}
	}
	*/
}
