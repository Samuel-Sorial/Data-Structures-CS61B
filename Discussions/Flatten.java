public class Flatten{

    /*
    Takes 2D arrray and return a single array with all contents
    {{1,2,3} , {5,6,7} , {8,9,10}} --> {1,2,3,4,5,6,7,8,9,10}
    */
    public static int[] flatten(int[][] x){
        int totalLength = 0;
        for(int[] arr : x){
            totalLength+= arr.length;
        }
        int[] a = new int[totalLength];
        int aIndex = 0;
        for(int[] arr : x){
            for(int i = 0; i<arr.length; i++){
                a[aIndex] = arr[i];
                aIndex++;
            }
        }
        return a;
    }

    public static void main(String[] args){
        int[][] x = {{1,2,3}, {4,5,6} , {7,8,9}};
        int[] y = flatten(x);
        for(int i : y)
            System.out.println(i);
    }
}