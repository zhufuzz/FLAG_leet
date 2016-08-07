package facebook.leetcode;
import java.util.*;//Graph, Topological Sort
/*There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.For example, Given the following words in dictionary,[  "wrt",  "wrf",  "er",  "ett",  "rftt"] The correct order is: "wertf".Note: You may assume all letters are in lowercase.If the order is invalid, return an empty string.There may be multiple valid order of letters, return any one of them is fine.*/
//http://www.cnblogs.com/yrbbest/p/5023584.html
/*��⣺�����Ҳ�ǿ��˺ܾã�ԭ������������ⲻ��ȷ����������Topological Sorting���������˼�� - Words are sorted�� ��ÿ��Word�����letter˳��û��ʲô��ϵ���ͱ���"apple"����"banana"ǰ�棬��������"apple"�����"a"������"p"ǰ�档����֮ǰ���˲���ʱ�����ÿ�������ڲ���˳����edges��������Ǵ�ġ� ���ֶ��������׻������Լ���Ӣ�ﲻ�á�д��һ�������ͨ������������Ŀ���������Ժ�ͺúܶ��ˣ��Ժ����ԵĻ�ҲҪ�ཻ���๵ͨ���������Ū��������˷�ʱ�����⡣���⣬����ͼ��˵��ͼ�����ֱ�﷽ʽ, list of edges, ajacency matrix��ajacency listsһ��Ҫ���������Ū���ס�
Kahn's Algorithm: �Ȱ�����wordsת��ΪAdjacency Lists����list of edges��Ȼ��ʹ��Course Schedule II�ķ�������Topological Sorting����������ʹ��Kahn's Algorithm���ȼ���inDegree��Ȼ��ά��һ��Queue������BFS��
Time Complexity - O(VE)��Space Complexity - O(VE)*/
public class F_269_Alien_Dictionary {
    public String alienOrder(String[] words) {   // Topological sorting - Kahn's Algorithm
        if(words == null || words.length == 0) { return ""; }
        Map<Character, HashSet<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();        
        for(String s : words) {
            for(int i = 0; i < s.length(); i++) { char c = s.charAt(i); inDegree.put(c, 0); }
        }
       // find  (prevChar, curChar) pairs as edges
        for(int i = 1; i < words.length; i++) {             
            String prevStr = words[i - 1];       String curStr = words[i];
            int len = Math.min(prevStr.length(), curStr.length());
            for(int j = 0; j < len; j++) {
                char curChar = curStr.charAt(j);  char prevChar = prevStr.charAt(j);
                if(curChar == prevChar) {continue;
                } else {// find edges;
                    if(map.containsKey(prevChar)) {
                        if(!map.get(prevChar).contains(curChar)) {
                            map.get(prevChar).add(curChar); inDegree.put(curChar, inDegree.get(curChar) + 1);
                        }
                    } else {
                        HashSet<Character> tmpSet = new HashSet<>();   tmpSet.add(curChar);
                        map.put(prevChar, tmpSet);  inDegree.put(curChar, inDegree.get(curChar) + 1);
                    }
                    break;
                }
            }
        }        
        Queue<Character> queue = new LinkedList<>();
        for(char c : inDegree.keySet()) {if(inDegree.get(c) == 0) {queue.offer(c);} }        
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()) {
            char c = queue.poll();    res.append(c);
            if(map.containsKey(c)) {
                for(char l : map.get(c)) {
                    inDegree.put(l, inDegree.get(l) - 1);
                    if(inDegree.get(l) == 0) { queue.offer(l); }
                }
            }
        }        
        if(res.length() != inDegree.size()) { return "";  }        
        return res.toString();
    }
}