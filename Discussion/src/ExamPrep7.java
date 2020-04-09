
public class ExamPrep7 {

    /**
     * 1-
     * N^2
     * NlogN
     * N
     * 1
     * N^2
     *
     *
     * 2-
     * N^2
     * N^2
     *
     *
     * 3-
     *                2        7
     *             1    3 5       8 9
     */

    public static void main(String[] args){
        int f = 0;
        for(int i = 1; i<= 10*10; i*=2){
            for(int j = 0; j<i; j++)
                f++;
        }
        System.out.println(f);
    }
}
