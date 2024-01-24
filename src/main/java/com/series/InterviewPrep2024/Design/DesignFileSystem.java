package com.series.InterviewPrep2024.Design;

/*
The challenge is to create a virtual file system that can create new paths and assign values to them.
Each path follows a structure similar to file directories in operating systems, beginning with a / (e.g., /path),
and can have multiple nested levels (e.g., /path/to/resource). It's important to note that paths like
an empty string "" or a single slash / are not considered valid.

createPath: This method should create a new path with an associated value, returning true if successful.
The method can only succeed if the path does not already exist and only if the "parent" path (the path
minus the last component) already exists. If these conditions are not met, the method should return false.

get: This method should retrieve the value associated with an existing path. If the path does not exist,
the method should return -1.


 */
public class DesignFileSystem {

    public DesignFileSystem() {

    }

    public boolean createPath(String path, int value) {
        return false;
    }

    // Method to get the value of a given path in the file system.
    public int get(String path) {

        return -1;
    }


    public static void main(String[] args) {
        DesignFileSystem d = new DesignFileSystem();
        d.createPath("/a", 1);
        d.createPath("/a/b", 2);
        d.createPath("/a/b/c", 3);
        d.get("/a/b");
        d.createPath("/a/b/c", 4);
        d.get("/a/b/c");
        d.get("/d");
    }
}
