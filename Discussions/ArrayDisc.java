public class ArrayDisc{


    public static int[] insert(int[] arr, int item, int position){
        int length = arr.length;
        int[] newArr = new int[length+1];
        System.arraycopy(arr,0,newArr,0, length);
        if(position > length){
            newArr[length] = item;
        }
        else{
            int temp = arr[position];
            newArr[position] = item;
            newArr[length] = temp;
        }
        return newArr;
    }

    public static void reverse(int[] arr){
        for(int i=0; i< arr.length / 2; i++){
            j = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public static void main(String[] args){
        int[] testing = {1,2,3,4,5};
        int[] resulting1 = ArrayDisc.insert(testing, 6 , 10);
        int[] resulting2 = ArrayDisc.insert(testing, 8, 2);
    }
}