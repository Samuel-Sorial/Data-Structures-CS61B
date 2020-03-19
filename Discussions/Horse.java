public class Horse{
    Horse same;
    String jimmy;

    public Horse(String lee){
        jimmy = lee;
    }

    public Horse same(Horse horse){
        if(same !=null){
            Horse same = horse;
            same.same = horse;
            same = horse.same;
        }
        return same.same;
    }

    public static void main(String[] args){
        Horse horse = new Horse("you 've been");
        Horse cult = new Horse("horsed");
        cult.same = cult;
        cult = cult.same(horse);
        // Print horsed because the same at the same() after if is this.same not the same refered at the if block cause it's local
        System.out.println(cult.jimmy);
        // Print you 've been 
        System.out.println(horse.jimmy);
    }
}