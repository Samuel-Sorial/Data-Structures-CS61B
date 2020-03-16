public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
    
      for(int i =0; i<a.length; i++){
        if(i== a.length-1 || a[i]<0){
          System.out.println(a[i]);
          continue;
        }
        else{
          int sum = a[i];
          for(int j=i+1; (j-i)<=n && j<a.length; j++ )
            sum += a[j];
          System.out.println(sum);
        }
      }
    }
  
    public static void main(String[] args) {
      int[] a = {1, 2, -3, 4, 5, 4};
      int n = 3;
      windowPosSum(a, n);
  
      // Should print 4, 8, -3, 13, 9, 4
      System.out.println(java.util.Arrays.toString(a));
    }
  }