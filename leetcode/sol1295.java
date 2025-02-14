import java.util.*;

class sol1295 {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i =0;i<nums.length;i++){
            if(even(nums[i])){
            count++;
            }

        }
        return count;
        
    }
    static boolean even(int num){
        int noOfDigits = digits(num);
       
        return  noOfDigits%2==0;
        
    }
    static int digits(int num){
        int count = 0;
        while(num>0){
            count++;
            num=num/10;

        }
        return count ;
    }
    public static void main(String[] args){
        System.out.print("enter the size of the array");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("enter the array");
        for(int i=0;i<n;i++){
            nums[i]= sc.nextInt();
        }
        System.out.println("Array is :");
        for(int i=0;i<n;i++){
           System.out.print(nums[i]);
        }
    }
}