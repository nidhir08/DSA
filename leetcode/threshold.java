//3066. Minimum Operations to Exceed Threshold Value II

import java.util.*;
public class threshold {
   
        static int[] minOperations(int[] nums, int k) {
            int x = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num < x) {  
                    y = x;  
                    x = num;  
                } else if (num > x && num < y) {  
                    y = num;  
                }
            }
        
            if (y == Integer.MAX_VALUE) {
                return new int[]{x, -1};  // Return -1 if no second min found
            }
            
            return new int[]{x, y};
        }
        // static int minimum(int[] nums,int k){
        //     minOperations(nums, 0);


        // }
        public static void main(String[] args) {
            int n;
            System.out.print("enter the size of the array");
            Scanner sc= new Scanner(System.in);
            n = sc.nextInt();
            int[] nums= new int[n];
            System.out.print("enter the array");
            for(int i=0;i<n;i++){
                nums[i]= sc.nextInt();
            }
            System.out.println("Array is :");
            for(int i=0;i<n;i++){
                System.out.print(nums[i]+" ");
                }
            System.out.println("enter the value of k");
            int k = sc.nextInt();
            int[] result = minOperations(nums, k);
            String rString = Arrays.toString(result);
            System.out.println("Minimum operations required are : "+rString);
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
    
            // Remove elements present in result array
            for (int res : result) {
                list.remove(Integer.valueOf(res)); // Remove by value, not index
            }
        
            int[] updatedNums = list.stream().mapToInt(i -> i).toArray();

        System.out.println("Updated nums array: " + Arrays.toString(updatedNums));
        System.out.println(rString);
        int ans = min(result)*2 + max(result);
        System.out.println("New element : "+ans);

        list.add(ans);
        int[] updatedNums2 = list.stream().mapToInt(i -> i).toArray();
        System.out.println("Updated nums array: " + Arrays.toString(updatedNums2));

        }

    static int min(int [] result){
        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<result.length;i++){
            if(minimum>result[i]){
                minimum = result[i];
                
            }
            
        }return minimum;
        
    }   
    static int max(int [] result){
        int maximum = Integer.MIN_VALUE;
        for(int i=0;i<result.length;i++){
            if(maximum<result[i]){
                maximum = result[i];
                
            }
            
        }return maximum;
        
    }  
}



//solution according to priority queue
// import java.util.PriorityQueue;

// public class Solution {
//     public int minOperations(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//         // Add all elements to the Min Heap
//         for (int num : nums) {
//             minHeap.add(num);
//         }

//         int operations = 0;

//         // Process until the smallest element is at least k
//         while (minHeap.size() > 1 && minHeap.peek() < k) {
//             int x = minHeap.poll();  // Smallest
//             int y = minHeap.poll();  // Second smallest

//             int newElement = (x * 2) + y;  // Apply the given formula
//             minHeap.add(newElement);

//             operations++;  // Increment operation count
//         }

//         // If the smallest element is still < k, return -1 (not possible)
//         return minHeap.peek() >= k ? operations : -1;
//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();

//         int[] nums = {2, 3, 10, 5, 1};
//         int k = 15;

//         int result = sol.minOperations(nums, k);
//         System.out.println("Minimum operations required: " + result);
//     }
// }


// //solution according to priority queue
// import java.util.PriorityQueue;

// public class Solution {
//     public int minOperations(int[] nums, int k) {
//         PriorityQueue<Long> minHeap = new PriorityQueue<>();

//         // Add all elements to the Min Heap (convert to long to handle large values)
//         for (int num : nums) {
//             minHeap.add((long) num);
//         }

//         int operations = 0;

//         // Process while the smallest element is still < k
//         while (minHeap.size() > 1 && minHeap.peek() < k) {
//             long x = minHeap.poll();  // Smallest
//             long y = minHeap.poll();  // Second smallest

//             long newElement = (x * 2) + y;  // Compute the new element
//             minHeap.add(newElement);

//             operations++;  // Increment operation count
//         }

//         // If we reach the end and still don't satisfy the condition, return -1
//         return minHeap.peek() >= k ? operations : -1;
//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();

//         int[] nums = {999999999, 999999999, 999999999};
//         int k = 1000000000;

//         int result = sol.minOperations(nums, k);
//         System.out.println("Minimum operations required: " + result);
//     }
// }
