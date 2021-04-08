package com.jetbrains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // read input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String userInput = sc.next();
            String[] parts = userInput.split("%");
            Person person = new Person(parts[0], Integer.parseInt(parts[1]));
            personList.add(person);
        }

        // sort by i in name%i
        personList.sort(Comparator.comparing(Person::getId));
        Graph graph = new Graph();
        for (int i = 0; i < personList.size() - 1; i++) {
            String name1 = personList.get(i).getName();
            String name2 = personList.get(i + 1).getName();
            // iterate through all names
            for (int len = 0; len < Math.min(name1.length(), name2.length()); len++) {
                // if different letter on the same position then add edge
                if (name1.charAt(len) != name2.charAt(len)) {
                    graph.addEdge(name1.charAt(len), name2.charAt(len));
                    break;
                }
            }
        }
        // there's no topological order if there is a cycle in graph
        if (graph.isCyclic()) {
            System.out.println("Impossible");
        } else {
            // find vertex permutation which satisfies edges (our new alphabet)
            graph.topSort();
        }

    }
}
