package com.series.InterviewPrep2024.Recursion.Pepcoding_Level1;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<String> res = mazePath(1, 1, n, m);
        System.out.println(res.size());
    }

    private static ArrayList<String> mazePath(int sr, int sc, int dr, int dc) {

        if(sc == dc && sr == dr){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> hPaths = new ArrayList<>();
        ArrayList<String> vPaths = new ArrayList<>();

        if(sc < dc) {
            hPaths = mazePath(sr, sc+1, dr, dc);
        }

        if (sr < dr) {
            vPaths = mazePath(sr+1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for (String hPath : hPaths) {
            paths.add("h"+hPath);
        }

        for (String vPath : vPaths) {
            paths.add("v"+vPath);
        }

        return paths;
    }
}
