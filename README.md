# Kairos Utility Library

## Overview

The Kairos Utility Library provides a set of helper methods for common tasks such as formatted output, input handling, string manipulation, collections, and exception wrapping. It is designed to simplify everyday programming tasks and improve productivity.

## Features

- **Formatted Output**: Simplified `printf` functionality.
- **Input Handling**: Convenient methods for reading input from the console.
- **String Manipulation**: Methods for string capitalization and joining.
- **Collections**: Helper methods to create lists and maps.
- **Exception Wrapping**: Utility for wrapping functions that throw checked exceptions.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 8 or higher installed. If not, download and install it from the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-downloads.html) or the [OpenJDK page](https://jdk.java.net/).

### Usage

1. **Import the Library**

   To use the Kairos library in your Java project, add the JAR file to your project’s classpath. You can do this in your IDE or manually through the command line.

2. **Example Usage**

   ```java
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
