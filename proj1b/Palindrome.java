public class Palindrome {

    /*
    @author: Samuel-Sorial
     */

    /*
    @param: String word to be converted to a chars deque.
     */
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new LinkedListDeque<>();
        for(char c : word.toCharArray()){
            result.addLast(c);
        }
        return result;
    }
    /*
    @param: String word to be checked.
    @return: boolean if it's palindrome or not.
     */
    public boolean isPalindrome(String word){
        char[] wordChars = word.toCharArray();
        int wordLength = wordChars.length;
        if(wordLength==0 || wordLength==1)
            return true;
        for(int i=0; i<wordLength/2; i++){
            if(wordChars[i] != wordChars[wordLength-i-1])
                return false;
        }
        return true;
    }
}
