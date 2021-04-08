package com.jetbrains;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    static final int ALPHABET_SIZE = 26;
    private final LinkedList<Integer>[] graph;

    public Graph() {
        graph = new LinkedList[ALPHABET_SIZE];
        for (int v = 0; v < ALPHABET_SIZE; v++) {
            graph[v] = new LinkedList<>();
        }
    }

    public void addEdge(char a, char b) {
        graph[a - 'a'].add(b - 'a');
    }

    private boolean dfs(int v, int[] color) {
        color[v] = 1;

        for (int u : graph[v]) {
            if (color[u] == 0) {
                if (dfs(u, color)) {
                    return true;
                }
            } else if (color[u] == 1) {
                return true;
            }
        }
        color[v] = 2;
        return false;
    }

    public boolean isCyclic() {
        int[] color = new int[ALPHABET_SIZE];

        for (int v = 0; v < ALPHABET_SIZE; v++) {
            if (dfs(v, color)) {
                return true;
            }
        }
        return false;
    }



    public void topSort() {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[ALPHABET_SIZE];
        for (int v = 0; v < ALPHABET_SIZE; v++) {
            visited[v] = false;
        }

        for (int v = 0; v < ALPHABET_SIZE; v++) {
            if (!visited[v]) {
                sortHelper(v, visited, stack);
            }
        }
        while (!stack.empty()) {
            System.out.print((char) ('a' + stack.pop()));
        }
    }

    private void sortHelper(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int u : graph[v]) {
            if (!visited[u]) {
                sortHelper(u, visited, stack);
            }
        }
        stack.push(v);
    }

}
