package com.series.InterviewPrep2024.AppleInterviewQuestionBank.Trees;

import java.util.*;

public class BTVerticalOrderTraversal {

//            3
//        9       20
//            15      7

    public static void main(String[] args) {

        BTNode node = new BTNode(3);
        node.left = new BTNode(9);
        node.right = new BTNode(20);
        node.right.left = new BTNode(15);
        node.right.right = new BTNode(7);

        verticalOrderTraversal(node);
    }

    private static void verticalOrderTraversal(BTNode node) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        traversal(node, 0, map);

        for (Map.Entry<Integer, List<Integer>> map1 : map.entrySet()) {
            System.out.println(map1.getValue());
        }
    }

    private static void traversal(BTNode node, int hd, TreeMap<Integer, List<Integer>> map) {

        if (node == null){
            return;
        }

        List<Integer> get = map.get(hd);

        if (get == null) {
            get = new ArrayList<>();
            get.add(node.data);
        } else {
            get.add(node.data);
        }

        map.put(hd, get);

        traversal(node.left, hd-1, map);
        traversal(node.right, hd+1, map);

    }
}
