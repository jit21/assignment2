/*Question 1
Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
import java.util.Arrays;*/

public class  assignment2 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums); 
        
        int maxSum = 0;
        
        
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        int maxSum = arrayPairSum(nums);
        System.out.println("Maximized sum: " + maxSum);
    }
}
/* Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor. 

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice. 

Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.*/
import java.util.HashSet;
import java.util.Set;

public class assignment2 {
    public static int distributeCandies(int[] candyType) {
        int maxCandies = candyType.length / 2; 
        
        Set<Integer> uniqueCandies = new HashSet<>();
        
        
        for (int candy : candyType) {
            uniqueCandies.add(candy);
            
            
            if (uniqueCandies.size() == maxCandies) {
                return maxCandies;
            }
        }
        

        return uniqueCandies.size();
    }

    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 2, 3, 3};
        int maxCandies = distributeCandies(candyType);
        System.out.println("Maximum number of different types of candies Alice can eat: " + maxCandies);
    }
}
/*We define a harmonious array as an array where the difference between its maximum value
and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence
among all its possible subsequences.

A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements. */
import java.util.HashMap;
import java.util.Map;

public class assignment2 {
    public static int findLHS(int[] nums) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int longestSubsequenceLength = 0;
        
        
        for (int num : nums) {
            
            if (frequencyMap.containsKey(num + 1)) {
                int currentSubsequenceLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                
                
                longestSubsequenceLength = Math.max(longestSubsequenceLength, currentSubsequenceLength);
            }
        }
        
        return longestSubsequenceLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int longestSubsequenceLength = findLHS(nums);
        System.out.println("Length of the longest harmonious subsequence: " + longestSubsequenceLength);
    }
}
/*You have a long flowerbed in which some of the plots are planted, and some are not.
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise. */
public class assignment2 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0; 

        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                
                boolean prevEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean nextEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);

                
                if (prevEmpty && nextEmpty) {
                    flowerbed[i] = 1; 
                    count++; 

                    
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean canPlant = canPlaceFlowers(flowerbed, n);
        System.out.println("Can plant " + n + " flowers: " + canPlant);
    }
}
/*Given an integer array nums, find three numbers whose product is maximum and return the maximum product. */
import java.util.Arrays;
public class assignment2 {
    public static int maximumProduct(int[] nums) {
        int n = nums.length;

        
        Arrays.sort(nums);

        
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int maxProduct = maximumProduct(nums);
        System.out.println("Maximum product: " + maxProduct);
    }
}
/*An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is
monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise. */
public class assignment2 {
    public static boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

    
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }
        }

        
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        boolean isMonotonicArray = isMonotonic(nums);
        System.out.println("Is the array monotonic? " + isMonotonicArray);
    }
}
/*You are given an integer array nums and an integer k.

In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after applying the mentioned operation at most once for each index in it. */
import java.util.Arrays;

public class assignment2 {
    public static int minScore(int[] nums, int k) {
        int n = nums.length;

        // Sort the array in ascending order
        Arrays.sort(nums);

        // Get the initial score (difference between the maximum and minimum elements)
        int initialScore = nums[n - 1] - nums[0];

        // Iterate over the array excluding the first and last elements
        for (int i = 1; i < n - 1; i++) {
            int max = Math.max(nums[i] + k, nums[n - 1] - k); // Choose the maximum possible value
            int min = Math.min(nums[i] - k, nums[0] + k); // Choose the minimum possible value
            initialScore = Math.min(initialScore, max - min); // Update the minimum score
        }

        return initialScore;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 14};
        int k = 3;
        int minScore = minScore(nums, k);
        System.out.println("Minimum score: " + minScore);
    }
}






    

