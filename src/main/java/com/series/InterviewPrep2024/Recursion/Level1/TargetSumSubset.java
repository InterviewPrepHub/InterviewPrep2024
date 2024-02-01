package com.series.InterviewPrep2024.Recursion.Level1;

import java.util.HashSet;

public class TargetSumSubset {

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int target = 70;

        sumSubset(arr, 0, "", 0, target);
    }

    private static void sumSubset(int[] arr, int idx, String set, int sumOfSet, int target) {

        if (idx == arr.length) {
            if(sumOfSet == target) {
                System.out.println(set);
            }
            return;
        }

        sumSubset(arr, idx+1, set+" "+arr[idx], sumOfSet+arr[idx], target);
        sumSubset(arr, idx+1, set, sumOfSet, target);
    }
}
