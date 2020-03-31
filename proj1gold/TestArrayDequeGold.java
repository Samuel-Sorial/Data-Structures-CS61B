import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque(){
            StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
            ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
            for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                student.addLast(i);
                solution.addLast(i);
            } else {
                student.addFirst(i);
                student.addFirst(i);
            }
        }
            assertEquals("Expected " + solution.get(0) + " found " + student.get(0),solution.removeFirst(),student.removeFirst());
            assertEquals("Expected " + solution.get(solution.size()-1) + " found " + student.get(student.size()-1),solution.removeLast(),student.removeLast());
    }
}
