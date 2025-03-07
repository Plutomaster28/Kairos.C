package test;

import source.kairos;
import java.util.*;

public class kairosTest {

    public static void main(String[] args) {
        testPrintf();
        testCapitalize();
        testIsNullOrEmpty();
        testJoin();
        testListOf();
        testMapOf();
        testWrapChecked();
    }

    public static void testPrintf() {
        kairos.printf("Testing printf:\n");
        kairos.printf("Hello, %s!\n", "world");
        kairos.printf("\nNo arguments provided");
    }

    public static void testCapitalize() {
        kairos.println("Testing capitalize:");
        kairos.println(kairos.capitalize("hello")); // Expected: Hello
        kairos.println(kairos.capitalize("HELLO")); // Expected: Hello
        kairos.println(kairos.capitalize("hElLo")); // Expected: Hello
        kairos.println(kairos.capitalize("")); // Expected: (empty string)
        kairos.println(kairos.capitalize(null)); // Expected: null
        kairos.println("\nBleeeeeh");
    }

    public static void testIsNullOrEmpty() {
        kairos.println("Testing isNullOrEmpty:");
        kairos.println(kairos.isNullOrEmpty(null)); // Expected: true
        kairos.println(kairos.isNullOrEmpty("")); // Expected: true
        kairos.println(kairos.isNullOrEmpty("hello")); // Expected: false
        kairos.println();
    }

    public static void testJoin() {
        kairos.println("Testing join:");
        kairos.println(kairos.join(",", "a", "b", "c")); // Expected: a,b,c
        kairos.println(kairos.join("-", "a", "b", "c")); // Expected: a-b-c
        kairos.println(kairos.join(",", "a")); // Expected: a
        kairos.println(kairos.join(",", new String[0])); // Expected: (empty string)
        kairos.println("\nBleeeeeh");
    }

    public static void testListOf() {
        kairos.println("Testing listOf:");
        List<String> list = kairos.listOf("a", "b", "c");
        kairos.println(list); // Expected: [a, b, c]
        kairos.println();
    }

    public static void testMapOf() {
        kairos.println("Testing mapOf:");
        @SuppressWarnings("unchecked")
        Map<String, Integer> map = kairos.mapOf("a", 1, new Map.Entry[]{
            new AbstractMap.SimpleEntry<>("b", 2),
            new AbstractMap.SimpleEntry<>("c", 3)
        });
        kairos.println(map); // Expected: {a=1, b=2, c=3}
        kairos.println();
    }

    public static void testWrapChecked() {
        kairos.println("Testing wrapChecked:");
        kairos.ThrowableFunction<String, Integer> func = Integer::parseInt;
        kairos.println(kairos.wrapChecked(func, "123")); // Expected: 123
        
        kairos.ThrowableFunction<String, Integer> funcWithException = s -> {
            throw new Exception("Test exception: " + s);
        };
        try {
            kairos.wrapChecked(funcWithException, "123");
        } catch (RuntimeException e) {
            kairos.println(e.getMessage()); // Expected: Test exception
        }
        kairos.println();
    }
}