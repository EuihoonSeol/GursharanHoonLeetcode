class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
 
        HashSet<String>myset=new HashSet<>();
        for(String word:wordList){
            myset.add(word);
        }
        if(!myset.contains(endWord)){
            return 0;
        }
        
        Queue<String>myqueue=new LinkedList<>();
        myqueue.offer(beginWord);
        int level=1;
        while(!myqueue.isEmpty()){
            int currentSize=myqueue.size();
            for(int i=0;i<currentSize;i++){
               String myword=myqueue.poll();
                char[] mycharArray=myword.toCharArray();
                //hit -> ['h','i','t']
               /*
               j=0;original character ->h
               ait ->
                
                */
                for(int j=0;j<mycharArray.length;j++){
                    char originalChar=mycharArray[j];
                    for(char c='a';c<='z';c++){
                      if(mycharArray[j]==c){
                          continue;
                      }
                        mycharArray[j]=c;
                        String newWord=String.valueOf(mycharArray);
                        if(newWord.equals(endWord)){
                            return level+1;
                        }
                        if(myset.contains(newWord)){
                            myqueue.offer(newWord);
                            myset.remove(newWord);
                        }
                    }
                    
                    mycharArray[j]=originalChar;
                }
                
            }
                    level++;

            
        }
        
        
        return 0;
    }
}
/*
class Solution {
    public boolean isOneLetterDiff(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        
        int numOfDiff = 0;
        
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++numOfDiff;
                if (numOfDiff > 1) {
                    return false;
                }
            }
        }
        
        if (numOfDiff == 1) {
            return true;
        }
        return false;
    }
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || beginWord.length() != endWord.length() || beginWord.equals(endWord)) {
            return count;
        }

        // hashmap to store word and its one-letter-different-words
        HashMap<String, List<String>> hm = new HashMap<>();
        
        List<String> words = new LinkedList<>();
        for (String w : wordList) {
            if (isOneLetterDiff(beginWord, w)) {
                words.add(w);
            }
        }
        hm.put(beginWord, words);
        
        for (String w : wordList) {
            words = new LinkedList<>();
            
            for (String ow : wordList) {
                if (isOneLetterDiff(w, ow)) {
                    words.add(ow);
                }
            }
            hm.put(w, words);
        }
        
        /*
        for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.print(key);
            System.out.print(": [");
            for (String s : value) {
                System.out.print(" " + s + ",");
            }
            System.out.print("]");
            System.out.println();
        }
        */
        
        // bfs iteratively using a queue
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        
        q.add(beginWord);
        visited.add(beginWord);
        ++count;

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; ++i) {
                String temp = q.remove();
                // System.out.println(temp);
                List<String> ls = hm.get(temp);
                // System.out.println(ls);
                for (String e : ls) {
                    if (e.equals(endWord)) {
                        return count + 1;
                    }
                    else {
                        if (!visited.contains(e)) {
                            q.add(e);
                            visited.add(e);
                        }
                    }
                }
            }
            ++count;
        }
        
        count = 0;
        return count;
    }
}




/*
