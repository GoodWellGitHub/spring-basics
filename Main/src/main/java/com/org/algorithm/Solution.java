package com.org.algorithm;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 4, 5, 7, 8,1,2};
        int result = solution.minNumberInRotateArray(arr);
        System.out.println(result);
    }

    public int minNumberInRotateArray(int[] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1 || array[0] <= array[length - 1]) {
            return array[0];
        }

        int result = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] < array[i - 1]) {
                result = array[i];
                break;
            }
        }
        return result;
    }
}
