package org.example.EasyLevel;

import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.List.of;
import static java.util.stream.Collectors.*;

public class Easy {
    public static void main(String[] args) {
        // Separate odd and even numbers in a list of integers.
        evenAndOdd();

        // Remove duplicate elements from a list and array using Java 8 streams
        removingDuplicateFromList();
        removingDuplicateFromArray();

        //Find the frequency of each character in a string using Java 8 streams
        frequencyOfEachCharacter();

        //Find the frequency of each element in an array or a list
        frequencyOfEachElement();

        //Sort a given list of numbers reverse order
        reverseOrder();

        //Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
        stringsWithSufixAndPrefix();

        //Print the numbers from a given list of integers that are multiples of 5
        dividedByNumber();

        //Find the maximum and minimum of a list of integers
        maxAndMinValues();

        //Merge two unsorted arrays into a single sorted array using Java 8 streams
        sortedArray();

    }

    private static void sortedArray() {
        int[] randomNumbers = {12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int[] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};

        int[] sortedArray = IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2))
                .sorted()
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(sortedArray));
    }

    private static void maxAndMinValues() {
        List<Integer> numbers = of(126, 432, 12, 64, 77, 85, 2, 80, 42, 446, 399, 43);
        Integer max = numbers.stream()
                .max(Integer::compareTo)
                .get();
        System.out.println(max);

        Integer min = numbers.stream()
                .min(Integer::compareTo)
                .get();
        System.out.println(min);

        IntSummaryStatistics collect = numbers.stream()
                .collect(summarizingInt(Integer::intValue));
        System.out.println("max number : " + collect.getMax() + " min value " + collect.getMin());
    }

    private static void dividedByNumber() {
        List<Integer> numbers = of(125, 430, 12, 64, 77, 85, 2, 80, 42, 446, 399, 43);
        List<Integer> dividedByNumber = numbers.stream()
                .filter(num -> num % 5 == 0)
                .toList();
        System.out.println(dividedByNumber);
    }

    private static void stringsWithSufixAndPrefix() {
        List<String> languageList = of("java", "c", "spring Boot", "Mern", "python", "kafka", "dockers");
        String strings = languageList.stream()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(strings);
    }

    private static void reverseOrder() {
        List<Integer> numbers = of(126, 432, 12, 64, 77, 85, 2, 80, 42, 446, 399, 43);
        List<Integer> reversed = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(reversed);
    }

    private static void frequencyOfEachElement() {
        List<String> names = Arrays.asList("shiva", "mahi", "charan", "shiva", "jyothi", "bharath", "mahi", "naveen");
        Map<String, Long> frequencyElement = names.stream()
                .collect(Collectors.groupingBy(String::toString, counting()));
        System.out.println(frequencyElement);
    }

    private static void frequencyOfEachCharacter() {
        String str = "character";
        Map<Character, Long> frequencyOfCharacter = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencyOfCharacter);

        //another way
        Map<String, Long> characterFrequency = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), counting()));
        System.out.println(characterFrequency);

    }

    private static void removingDuplicateFromArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4};
        Stream<Integer> distinct = Arrays.stream(arr)
                .boxed()
                .distinct();
        distinct.forEach(System.out::println);
    }

    private static void removingDuplicateFromList() {
        List<Integer> numbers = of(1, 2, 3, 4, 5, 5, 6, 6, 7, 8, 9, 10);
        List<Integer> removingDuplicateFromList = numbers.stream()
                .distinct()
                .toList();
        System.out.println(removingDuplicateFromList);

        //using set
        Set<Integer> removingDuplicate = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println(removingDuplicate);
    }

    private static void evenAndOdd() {
        List<Integer> numbers = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect = numbers.stream()
                .collect(partitioningBy(num -> num % 2 == 0));
        System.out.println("Even numbers : " + collect.get(true));
        System.out.println("odd numbers : " + collect.get(false));
    }
}
