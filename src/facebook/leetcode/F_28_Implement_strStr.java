package facebook.leetcode;
//two pointers, String

/*Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.*/

//https://longwayjade.wordpress.com/2015/05/29/leetcode-two-pointers-kmp-rolling-hash-implement-strstr/

class F_28_Implement_strStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */

    public int strStr(String haystack, String needle) {
      
          for (int i = 0;; i++){   
            
              for (int j = 0;; j++){
                
                  if (j == needle.length()) return i;
                  
                  if (i + j == haystack.length()) return -1;
                  
                  if (needle.charAt(j) != haystack.charAt(j+i)) break;
              }
          }
      }
}