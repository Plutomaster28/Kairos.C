package source;

import java.util.*;

/**
 * Utility class providing helper methods for common tasks such as formatted output, input handling, 
 * string manipulation, collections, and exception wrapping.
 */
public class kairos {

    /**
     * Prints formatted output to the console, similar to printf in C.
     * 
     * @param format The format string (following printf conventions).
     * @param args The arguments to be formatted and printed.
     */
    public static void printf(String format, Object... args) {
        if (format == null || format.isEmpty()) {
            System.out.println();
        } else {
            System.out.printf(format, args);
        }
    }

    /**
     * Prints a string to the console.
     * 
     * @param message The message to be printed.
     */
    public static void print(String message) {
        if (message == null) {
            System.out.print("");
        } else {
            System.out.print(message);
        }
    }

    /**
     * Prints a string to the console with a newline.
     * 
     * @param message The message to be printed.
     */
    public static void println(String message) {
        if (message == null) {
            System.out.println();
        } else {
            System.out.println(message);
        }
    }

    /**
     * Prints a newline to the console.
     */
    public static void println() {
        System.out.println();
    }

    /**
     * Prints a boolean to the console with a newline.
     * 
     * @param value The boolean value to be printed.
     */
    public static void println(boolean value) {
        System.out.println(value);
    }

    /**
     * Prints an integer to the console with a newline.
     * 
     * @param value The integer value to be printed.
     */
    public static void println(int value) {
        System.out.println(value);
    }

    /**
     * Prints a double to the console with a newline.
     * 
     * @param value The double value to be printed.
     */
    public static void println(double value) {
        System.out.println(value);
    }

    /**
     * Prints an object to the console with a newline.
     * 
     * @param value The object to be printed.
     */
    public static void println(Object value) {
        System.out.println(value);
    }

    // Scanner object used for reading user input from the console.
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Reads a line of text input from the user.
     * 
     * @return The input string entered by the user.
     */
    public static String readString() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer input from the user.
     * 
     * @return The integer value entered by the user.
     * @throws InputMismatchException if the input is not a valid integer.
     */
    public static int readInt() {
        return scanner.nextInt();
    }

    /**
     * Reads a double input from the user.
     * 
     * @return The double value entered by the user.
     * @throws InputMismatchException if the input is not a valid double.
     */
    public static double readDouble() {
        return scanner.nextDouble();
    }

    /**
     * Capitalizes the first letter of the input string and converts the rest to lowercase.
     * 
     * @param str The string to be capitalized.
     * @return The capitalized string, or the original string if it is null or empty.
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    /**
     * Checks whether a string is null or empty.
     * 
     * @param str The string to check.
     * @return true if the string is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Joins the given elements into a single string with the specified delimiter.
     * 
     * @param delimiter The delimiter that separates each element.
     * @param elements The elements to be joined.
     * @return A string formed by concatenating the elements with the delimiter.
     */
    public static String join(String delimiter, String... elements) {
        return String.join(delimiter, elements);
    }

    /**
     * Creates a list from a variable number of items.
     * 
     * @param <T> The type of the list items.
     * @param items The items to be added to the list.
     * @return A list containing the provided items.
     */
    @SafeVarargs
    public static <T> List<T> listOf(T... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    /**
     * Creates a map from a key-value pair and additional pairs. Pairs should be provided as Map.Entry objects.
     * 
     * @param <K> The type of keys in the map.
     * @param <V> The type of values in the map.
     * @param firstKey The first key.
     * @param firstValue The value corresponding to the first key.
     * @param entries Additional key-value pairs as Map.Entry objects.
     * @return A map containing the provided key-value pairs.
     */
    public static <K, V> Map<K, V> mapOf(K firstKey, V firstValue, Map.Entry<K, V>[] entries) {
        Map<K, V> map = new HashMap<>();
        map.put(firstKey, firstValue);
        for (Map.Entry<K, V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /**
     * Functional interface representing a function that can throw a checked exception.
     * 
     * @param <T> The input type of the function.
     * @param <R> The return type of the function.
     */
    @FunctionalInterface
    public interface ThrowableFunction<T, R> {
        R apply(T t) throws Exception;
    }

    /**
     * Wraps a function that throws a checked exception, converting it into a function that throws 
     * an unchecked exception (RuntimeException). This allows the calling code to avoid dealing 
     * with checked exceptions explicitly.
     * 
     * @param <T> The input type for the function.
     * @param <R> The return type for the function.
     * @param func The function that may throw a checked exception.
     * @param t The input to the function.
     * @return The result of the function.
     * @throws RuntimeException if the wrapped function throws a checked exception.
     */
    public static <T, R> R wrapChecked(ThrowableFunction<T, R> func, T t) {
        try {
            return func.apply(t);
        } catch (Exception e) {
            throw new RuntimeException(e); // Convert checked exception to unchecked
        }
    }
}
