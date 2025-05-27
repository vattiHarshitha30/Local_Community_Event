
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}


import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        double result = 0;
        boolean valid = true;

        switch(op) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if(num2 != 0) result = num1 / num2;
                else {
                    System.out.println("Error: Division by zero!");
                    valid = false;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                valid = false;
        }
        if(valid)
            System.out.println("Result: " + result);
        sc.close();
    }
}


import java.util.Scanner;

public class EvenOddChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        if(num % 2 == 0)
            System.out.println(num + " is even.");
        else
            System.out.println(num + " is odd.");
        sc.close();
    }
}


import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is not a leap year.");
        sc.close();
    }
}


import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        for(int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        sc.close();
    }
}


public class DataTypeDemo {
    public static void main(String[] args) {
        int i = 10;
        float f = 5.5f;
        double d = 20.99;
        char c = 'A';
        boolean b = true;

        System.out.println("int: " + i);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + b);
    }
}


public class TypeCastingExample {
    public static void main(String[] args) {
        double d = 9.78;
        int i = (int) d;  
        System.out.println("Double value: " + d);
        System.out.println("After casting to int: " + i);

        int j = 42;
        double k = (double) j;  
        System.out.println("Int value: " + j);
        System.out.println("After casting to double: " + k);
    }
}


public class TypeCastingExample {
    public static void main(String[] args) {
        double d = 9.78;
        int i = (int) d;  
        System.out.println("Double value: " + d);
        System.out.println("After casting to int: " + i);

        int j = 42;
        double k = (double) j;  
        System.out.println("Int value: " + j);
        System.out.println("After casting to double: " + k);
    }
}


public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2: " + result);
    }
}


import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();
        char grade;

        if(marks >= 90) grade = 'A';
        else if(marks >= 80) grade = 'B';
        else if(marks >= 70) grade = 'C';
        else if(marks >= 60) grade = 'D';
        else grade = 'F';

        System.out.println("Grade: " + grade);
        sc.close();
    }
}


import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;
        int guess = 0;

        System.out.println("Guess a number between 1 and 100:");

        while(guess != target) {
            guess = sc.nextInt();
            if(guess < target) System.out.println("Too low, try again:");
            else if(guess > target) System.out.println("Too high, try again:");
            else System.out.println("Congratulations! You guessed it.");
        }
        sc.close();
    }
}


import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + n + " is " + factorial);
        sc.close();
    }
}


public class MethodOverloading {
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Add int: " + add(2, 3));
        System.out.println("Add double: " + add(2.5, 3.5));
        System.out.println("Add three ints: " + add(1, 2, 3));
    }
}


import java.util.Scanner;

public class RecursiveFibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci number at position " + n + " is " + fibonacci(n));
        sc.close();
    }
}


import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        double average = (double) sum / n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        sc.close();
    }
}


import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        StringBuilder reversed = new StringBuilder(input).reverse();
        System.out.println("Reversed string: " + reversed);
        sc.close();
    }
}


import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        if (isPalindrome(input))
            System.out.println("It's a palindrome.");
        else
            System.out.println("Not a palindrome.");
        sc.close();
    }
}


public class Car {
    String make;
    String model;
    int year;

    public void displayDetails() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.make = "Toyota";
        car1.model = "Corolla";
        car1.year = 2020;
        car1.displayDetails();
    }
}


class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        a.makeSound();
        d.makeSound();
    }
}


interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Playing Guitar");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing Piano");
    }

    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play();
        p.play();
    }
}


import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int a = sc.nextInt();
        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }

        sc.close();
    }
}


class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeChecker {
    public static void main(String[] args) {
        int age = 16;
        try {
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        } else {
            System.out.println("Valid age.");
        }
    }
}


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to write to file: ");
        String input = scanner.nextLine();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(input);
            System.out.println("Data written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}


import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;

        while (true) {
            System.out.print("Enter student name (or 'exit' to finish): ");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            names.add(name);
        }

        System.out.println("Student Names:");
        for (String n : names) {
            System.out.println(n);
        }
    }
}


import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            students.put(id, name);
        }
        System.out.print("Enter ID to retrieve name: ");
        int searchId = scanner.nextInt();
        String result = students.get(searchId);
        if (result != null) {
            System.out.println("Student Name: " + result);
        } else {
            System.out.println("Student not found.");
        }
    }
}


class MessagePrinter extends Thread {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - " + i);
        }
    }

    public static void main(String[] args) {
        MessagePrinter thread1 = new MessagePrinter("Thread 1");
        MessagePrinter thread2 = new MessagePrinter("Thread 2");

        thread1.start();
        thread2.start();
    }
}


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));

        System.out.println("Sorted Names:");
        names.forEach(System.out::println);
    }
}


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterEven {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);
    }
}


import java.util.List;
import java.util.stream.Collectors;
record Person(String name, int age) {}
public class RecordExample {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 22);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        List<Person> people = List.of(p1, p2, p3);
        List<Person> adults = people.stream()
            .filter(person -> person.age() >= 18)
            .collect(Collectors.toList());
        System.out.println("Adults:");
        adults.forEach(System.out::println);
    }
}


public class PatternMatchingSwitch {

    public static void printObjectType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer with value " + i;
            case String s -> "String with value \"" + s + "\"";
            case Double d -> "Double with value " + d;
            case null -> "Object is null";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        printObjectType(42);
        printObjectType("Hello");
        printObjectType(3.14);
        printObjectType(true);  // Unknown type
        printObjectType(null);
    }
}


CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT
);
INSERT INTO students (name, age) VALUES ('Alice', 20), ('Bob', 22);
import java.sql.*;

public class JdbcSelectExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Age: %d%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


import java.sql.*;

public class StudentDAO {
    private final Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }
    public void insertStudent(String name, int age) throws SQLException {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        }
    }
    public void updateStudentAge(int id, int newAge) throws SQLException {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newAge);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}


module com.utils {
    exports com.utils;
}
package com.utils;

public class Util {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}
module com.greetings {
    requires com.utils;
}
package com.greetings;

import com.utils.Util;

public class Main {
    public static void main(String[] args) {
        System.out.println(Util.greet("World"));
    }
}


import java.io.*;
import java.net.*;
public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            String fromClient, fromServer;
            while (true) {
                if ((fromClient = in.readLine()) != null) {
                    System.out.println("Client: " + fromClient);
                }
                System.out.print("Server: ");
                fromServer = keyboard.readLine();
                if (fromServer != null) {
                    out.write(fromServer);
                    out.newLine();
                    out.flush();
                }
                if ("bye".equalsIgnoreCase(fromServer) || "bye".equalsIgnoreCase(fromClient)) {
                    break;
                }
            }
        }
        clientSocket.close();
        serverSocket.close();
        System.out.println("Server closed.");
    }
}
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server.");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            String fromServer, fromUser;

            while (true) {
                System.out.print("Client: ");
                fromUser = keyboard.readLine();
                if (fromUser != null) {
                    out.write(fromUser);
                    out.newLine();
                    out.flush();
                }
                if ("bye".equalsIgnoreCase(fromUser)) break;

                if ((fromServer = in.readLine()) != null) {
                    System.out.println("Server: " + fromServer);
                    if ("bye".equalsIgnoreCase(fromServer)) break;
                }
            }
        }
        socket.close();
        System.out.println("Client closed.");
    }
}


import java.net.URI;
import java.net.http.*;
import java.io.IOException;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/octocat"))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: \n" + response.body());
    }
}


public class Sample {
    public int add(int a, int b) {
        return a + b;
    }
}


public class Simple {
    private String message;

    public Simple(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println("Message: " + message);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Simple simple = new Simple("Hello, World!");
        simple.display();
        int sum = simple.add(5, 10);
        System.out.println("Sum: " + sum);
    }
}


import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");

        System.out.println("Methods of " + clazz.getName() + ":");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName() + " with params " + java.util.Arrays.toString(m.getParameterTypes()));
        }
        Method substringMethod = clazz.getMethod("substring", int.class, int.class);
        String str = "Hello, Reflection!";
        String result = (String) substringMethod.invoke(str, 7, 16);
        System.out.println("Result of substring: " + result);
    }
}


import java.time.Duration;
import java.time.Instant;

public class VirtualThreadsExample {

    public static void main(String[] args) throws InterruptedException {
        int taskCount = 100_000;

        // Measure virtual threads
        Instant startVirtual = Instant.now();
        Thread[] vThreads = new Thread[taskCount];
        for (int i = 0; i < taskCount; i++) {
            vThreads[i] = Thread.startVirtualThread(() -> {
            });
        }
        for (Thread t : vThreads) {
            t.join();
        }
        Instant endVirtual = Instant.now();
        System.out.println("Virtual threads time: " + Duration.between(startVirtual, endVirtual).toMillis() + " ms");
        Instant startTraditional = Instant.now();
        Thread[] tThreads = new Thread[taskCount];
        for (int i = 0; i < taskCount; i++) {
            tThreads[i] = new Thread(() -> {
            });
            tThreads[i].start();
        }
        for (Thread t : tThreads) {
            t.join();
        }
        Instant endTraditional = Instant.now();
        System.out.println("Traditional threads time: " + Duration.between(startTraditional, endTraditional).toMillis() + " ms");
    }
}


import java.util.concurrent.*;
import java.util.*;

public class CallableExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int id = i;
            tasks.add(() -> {
                Thread.sleep(500);
                return "Result from task " + id;
            });
        }

        List<Future<String>> futures = executor.invokeAll(tasks);

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
}


