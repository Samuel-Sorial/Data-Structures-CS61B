class D{
    public static void main(String[] args){
        //B a0 = new A(); Cant user A as b
        // a0.m1();
        // a0.m2(16);
        A b0 = new B();
        System.out.println(b0.x); // 5
        b0.m1(); // Am1-> 5
        b0.m2(); // Bm2-> 5
        //b0.m2(61); The compile time type is A which doesn't have m2 takes integer as a paramter.
        B b1 = new B();
        b1.m2(61); // Bm2y-> 61
        b1.m3(); // Bm3-> called
        A c0 = new C(); 
        c0.m2();
        //C c1 = (A) new C(); Can't store reference to A at a C variable. 
        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3();
        //c2.m4(); Had an error.
        c2.m5(); //Cm-> 6
        ((C) c0).m3();
        //(C) c0.m3(); Compile time
        b0.update();
        b0.m1();
    }
}