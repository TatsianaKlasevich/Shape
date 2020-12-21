package com.klasevich.quadrangle.util.generator;

public class QuadrangleIdGenerator {
    private static int currentId = 0;

    public static int getCurrentId() {
        return currentId++;
    }
}
