public class Shock{
    public static int bang;
    public static Shock baby;
    public Shock(){
        this.bang = 100;
    }
    public Shock (int num){
        this.bang = num;
        baby = starter();
        this.bang += num;
    }
    public static Shock starter(){
        Shock gear = new Shock();
        return gear;
    }
    public static void shrink(Shock statik){
        statik.bang -=1;
    }
    public static void main(String[] args){
        Shock gear = new Shock(200);
        // Should give 300
        System.out.println(gear.bang);
        shrink(gear);
        shrink(starter());
        // Should give 99
        System.out.println(gear.bang);
    }
}