
public class ExamPrep7 {

    /**
     * 1-
     * N^2
     * NlogN
     * N
     * 1
     * N^2
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
