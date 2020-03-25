public class QuikMaths{
    public static void multiplyBy3(int[] a){
        for(int x : a){
            x=x*3;
        }
    }
    public static void multiplyBy2(int[] a){
        int[] B = a;
        for(int i =0; i<B.length; i+=1){
            B[i] *=2;
        }
    }
    public static void swap(int A, int B){
        int temp = B;
        B=A;
        A=temp;
    }

    public static void main(String[] args){
        int[] arr;
        arr = new int[]{2,3,3,4};
        multiplyBy3(arr);
        // value of arr : 2,3,3,4 
        arr = new int[]{2,3,3,4};
        multiplyBy2(arr);
        //value of arr : 4,6,6,8
        int a = 6;
        int b = 7;
        swap(a,b);
        // value of a = 6, b = 7

        
    }
}