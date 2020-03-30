public class Corgi extends Dog{
    
    public Corgi(){
        /* C1 */
    }
    public void bark(Corgi c){
        /* Method B*/
    }
    @Override
    public void bark(Dog d){
        /* Method C */
    }
    public void play(Dog d){
        /* Method D */
    }
    public void play(Corgi c){
        /* Method E */
    }
    /* Answers for each line:
    2: C1 D1
    3: C1 D1
    4: D1
    5: Compile-Error
    6: Runtime-Error
    8: Compile-Error
    9: Compile-Error
    10: D
    11: E
    12: C
    13: B
    14: C
    15: Compile-Error
    16: Runtime-Error
    */
}