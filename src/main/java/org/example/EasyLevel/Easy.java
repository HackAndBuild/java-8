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

        //Merge two unsorted arrays into a single sorted array without duplicates
        sortedArrayWithoutDuplicates();

        //Get the three maximum and three minimum numbers from a given list of integers
        maxAndMin3Values();

        //Check if two strings are anagrams or not using Java 8 streams
        anagramOrNot();

        //Find the sum of all digits of a number in Java 8
        sum();

        //Find the second-largest and small numbers in an integer array
        secondLargeAndSmallNumbers();

        //Sort a list of strings according to the increasing order of their length
        sortTheLengthOfString();

        //Find the sum and average of all elements in an integer array
        sumAndAvg();

        //Find the common elements between two arrays
        commonElements();

        // Reverse each word of a string using Java 8 streams
        reverseString();

        //Find the sum of the first 10 natural numbers
        randomSum();

        // Reverse an integer array
        reversNumber();

        //Find the most repeated element in an array
        int[] elements = {2, 3, 1, 4, 4, 1, 4, 333, 3, 333, 2, 2, 2, 5, 222};


        //Check if a string is a palindrome using Java 8 streams
        palindrome();
    }

    private static void palindrome() {
        String str = "madam";
        String lowerCase = str.replaceAll("\\S+", "")
                .toLowerCase();
        boolean palindrome = IntStream.range(0, lowerCase.length() / 2)
                .noneMatch(ch -> lowerCase.charAt(ch) != lowerCase.charAt(lowerCase.length() - ch - 1));
        if (palindrome)
            System.out.println("palindrome");
        else
            System.out.println("not palindrome");
    }

    private static void reversNumber() {
        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> reverse = Arrays.stream(numberArray)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(reverse);
    }

    private static void randomSum() {
        int sum = IntStream.rangeClosed(1, 10)
                .sum();
        System.out.println(sum);
    }

    private static void reverseString() {
        String str = "java is good";
        String reverseString = Arrays.stream(str.split(" "))
                .map(ch -> new StringBuilder(ch).reverse().toString())
                .collect(joining(" "));
        System.out.println(reverseString);
    }

    private static void commonElements() {
        List<Integer> num = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers = of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = num.stream()
                .filter(numbers::contains)
                .toList();
        System.out.println(result);
    }

    private static void sumAndAvg() {
        List<Integer> numbers = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics collect = numbers.stream()
                .collect(summarizingInt(Integer::valueOf));
        System.out.println("sum of numbers : " + collect.getSum());
        System.out.println("avg of numbers : " + collect.getAverage());
    }

    private static void sortTheLengthOfString() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        List<String> words = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(words);
    }

    private static void secondLargeAndSmallNumbers() {
        List<Integer> random = Arrays.asList(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        Integer secondLargestNumber = random.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondLargestNumber);

        Integer secondSmallNumber = random.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondSmallNumber);
    }

    private static void sum() {
        List<Integer> random = Arrays.asList(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        Integer sum = random.stream()
                .reduce(Integer::sum)
                .get();
        System.out.println(sum);
    }

    private static void anagramOrNot() {
        String string1 = "listen";
        String string2 = "silent";

        String str = Arrays.stream(string1.split(""))
                .sorted()
                .collect(joining(""));
        String str1 = Arrays.stream(string2.split(""))
                .sorted()
                .collect(joining(""));
        if (str.equals(str1))
            System.out.println("anagram");
        else System.out.println("not anagram");
    }

    private static void maxAndMin3Values() {
        List<Integer> random = Arrays.asList(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> min3 = random.stream()
                .sorted()
                .distinct()
                .limit(3)
                .toList();
        System.out.println(min3);
        List<Integer> max3 = random.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(3)
                .toList();
        System.out.println(max3);
    }

    private static void sortedArrayWithoutDuplicates() {
        int[] random = {12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int[] random1 = {4, 3, 2, 5, 6, 78, 98, 53, 90};
        int[] sorted = IntStream.concat(Arrays.stream(random), Arrays.stream(random1))
                .sorted()
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(sorted));
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
