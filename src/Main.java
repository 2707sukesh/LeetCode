import java.util.*;

class Solution {
    class TrieNode{
        HashMap<String,TrieNode> nodeHashMap = new HashMap<>();
        char character ;
        boolean isEnd;
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        List<String> answer = new LinkedList<>();
        TrieNode root = new TrieNode();
        for(String path : folder){
            TrieNode rootCopy = root;
            int i = 0;
            for(String character : path.split("/")){
                TrieNode currentNode = rootCopy.nodeHashMap.get(character);
                if(currentNode != null && currentNode.isEnd)  break;
                else {
                    if(currentNode == null)
                        rootCopy.nodeHashMap.put(character,new TrieNode());
                    rootCopy = rootCopy.nodeHashMap.get(character);
                    i++;
                }
            }
            if(i == path.split("/").length){
                //which means all the characters are processed without encountering an end
                rootCopy.isEnd = true;
                answer.add(path);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] string = new String[]{"/a","/a/b/c","/a/b/d"};
        System.out.println( s.removeSubfolders(string));
    }
}