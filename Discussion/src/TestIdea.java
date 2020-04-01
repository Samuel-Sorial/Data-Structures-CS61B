public class TestIdea {

    public static void main(String[] args){
        Integer[] array = new Integer[5];
        for(int i =0; i<5; i++)
            array[i] = i;

        for(Integer i : array){
            if(i==2)
                i = 4;
        }
        for(Integer i : array)
            System.out.println(i);
    }

}
