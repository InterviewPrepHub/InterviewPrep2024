package com.series.InterviewPrep2024.Design;

import java.util.HashMap;
import java.util.Map;

public class FactorialUsingMemo {

    Map<Integer, Integer> map = new HashMap<>();
    public int fib(int n) {

        if (map.containsKey(n)){
            return map.get(n);
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int fibVal = fib(n-2) + fib(n-1);

        map.put(n, fibVal);

        return fibVal;

    }

    public static void main(String[] args) {
        FactorialUsingMemo f = new FactorialUsingMemo();
        System.out.println(f.fib(5));
    }
}
