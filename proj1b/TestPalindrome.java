import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        String notPalindrome = "Samuel";
        String realPalindrome = "racecar";
        String cornerCase = "";
        String anotherCornerCase = "a";

        assertTrue(palindrome.isPalindrome(realPalindrome));
        assertFalse(palindrome.isPalindrome(notPalindrome));
        assertTrue(palindrome.isPalindrome(cornerCase));
        assertTrue(palindrome.isPalindrome(anotherCornerCase));
    }
}