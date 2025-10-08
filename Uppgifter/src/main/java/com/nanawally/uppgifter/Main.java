package com.nanawally.uppgifter;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        RecordClass recordClass = new RecordClass("test");
        recordClass.getClass();

        List<String> names = List.of("Alice", "Bob", "Charlie");

        int day = 3;

        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Friday";
        };

        System.out.println(result);
    }
}
