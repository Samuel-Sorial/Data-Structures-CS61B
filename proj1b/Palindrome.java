public class Palindrome {

    /*
    @author: Samuel-Sorial
     */

    /*
    @param: String word to be converted to a chars deque.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (char c : word.toCharArray()) {
            result.addLast(c);
        }
        return result;
    }

    /*
    @param: String word to be checked.
    @return: boolean if it's palindrome or not.
     */
    public boolean isPalindrome(String word) {
        Deque<Character> charOfWord = wordToDeque(word);
        return isPalindromeHelper(charOfWord);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> charOfWord = wordToDeque(word);
        return isPalindromeHelper(charOfWord , cc);
    }

    private boolean isPalindromeHelper(Deque<Character> deque){
        if(deque.size() <= 1)
            return true;
        return deque.removeFirst() == deque.removeLast() && isPalindromeHelper(deque);
    }

    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc){
        if(deque.size() <= 1)
            return true;
        return cc.equalChars(deque.removeFirst(), deque.removeLast()) && isPalindromeHelper(deque, cc);
    }

}