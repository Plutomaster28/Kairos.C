package test;
import source.kairos;

public class Main {
    public static void main(String[] args) {
        kairos.printf("Hello, %s! You have %d new messages.%n", "Alice", 5);
        
        kairos.printf("Enter your name: ");
        String name = kairos.readString();
        kairos.printf("Hello, %s!%n", name);
    }
}