import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class RandomArrayGeneratorTest {

    @Test
    void generateRandomArray() {
        int[] array = RandomArrayGenerator.generateRandomArray(5, 100);

        assertEquals(5, array.length);

        for (int num : array) {
            assertTrue(num >= 0 && num <= 100);
        }
    }

    @Test
    void printArray() {
        RandomArrayGenerator.printArray(new int[]{1, 2, 3});
    }

    @Test
    void saveArrayToFile() throws IOException {
        String fileName = "testOutput.txt";
        int[] array = {1, 2, 3};

        RandomArrayGenerator.saveArrayToFile(array, fileName);

        assertTrue(Files.exists(Path.of(fileName)));
        assertEquals("1\n2\n3\n", Files.readString(Path.of(fileName)));

        Files.deleteIfExists(Path.of(fileName));
    }
}
