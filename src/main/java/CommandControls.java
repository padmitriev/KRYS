
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class CommandControls {
    static String receiveCommand() {
        System.out.println("Command:");
        Scanner scan = new Scanner(System.in);
        String shortCommandInput = scan.nextLine();
        return shortCommandInput;
    }

    //  Returns the line with short command as an array
    static String[] findLineByCommand(String shortCommand) {
        String className = null;
        String methodToInvoke = null;
        String[] lineToWords = new String[3];

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("./src/main/resources/methods.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(shortCommand)) {
                    lineToWords = line.split(" ");
                    className = lineToWords[1];
                    methodToInvoke = lineToWords[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (className == null || methodToInvoke == null) {
            System.out.println("command not found");
        }
//        System.out.println("command: " + shortCommandInput);
//        System.out.println("className: " + className);
//        System.out.println("methodToInvoke: " + methodToInvoke);

        return lineToWords;
    }

    static void methodToInvoke(String[] line) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String className = line[1];
        String methodName = line[2];

        if (className != null || methodName != null) {
            Class<?> c = Class.forName(className);
            Method method = c.getDeclaredMethod(methodName);
            method.invoke(c);
        }
    }

    static void invokeMethod() throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, IllegalAccessException {
        methodToInvoke(findLineByCommand(receiveCommand()));
    }
}
