import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RandomArrayGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the array:");
        int arrayLength = scanner.nextInt();

        System.out.println("Enter the maximum number for the array:");
        int maxNumber = scanner.nextInt();

        int[] generatedArray = generateRandomArray(arrayLength, maxNumber);
        printArray(generatedArray);

        System.out.println("Enter the filename to save the array:");
        String fileName = scanner.next();
        saveArrayToFile(generatedArray, fileName);
    }

    public static int[] generateRandomArray(int length, int maxNumber) {
        Random random = new Random();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(maxNumber + 1);
        }

        return array;
    }

    public static void printArray(int[] array) {
        System.out.println("Generated array:");
        for (int num : array) {
            System.out.println(num);
        }
    }

    public static void saveArrayToFile(int[] array, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int num : array) {
                writer.write(num + "\n");
            }
            System.out.println("Array saved to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error while saving to the file.");
        }
    }
}
