package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> changes = getChanges();

        Integer finalFrequency = addAll(changes);
        System.out.println("Result is: " + finalFrequency);
        Integer firstRepeated = findFirstRepeated(changes);
        System.out.println("First repeated is: " + firstRepeated);
    }

    private static List<Integer> getChanges() {
        List<Integer> changes = new ArrayList<>();

        Scanner scanner = new Scanner(Input.getInput());
        while (scanner.hasNextLine()) {
            String change = scanner.nextLine();
            changes.add(Integer.valueOf(change));
        }

        return changes;
    }

    private static Integer addAll(List<Integer> changes) {
        Integer frequency = 0;
        Set<Integer> reachedFrequencies = new HashSet<>();
        reachedFrequencies.add(frequency);

        for (Integer change : changes) {
            frequency = frequency + change;
        }

        return frequency;
    }

    private static Integer findFirstRepeated(List<Integer> changes) {
        Integer frequency = 0;

        Set<Integer> reachedFrequencies = new HashSet<>();
        reachedFrequencies.add(frequency);

        ListIterator<Integer> i = changes.listIterator();
        while (true) {
            if (!i.hasNext()) {
                i = changes.listIterator();
            }
            frequency = frequency + i.next();

            if (!reachedFrequencies.add(frequency)) {
                return frequency;
            }
        }
    }
}
