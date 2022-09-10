import java.io.FileWriter;
import java.io.IOException;

public class makeCSV {
    public static void CSVprinter(long[] wasp, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);

        for (int j = 0; j < wasp.length; j++) {
            writer.append(String.valueOf(wasp[j]));
            writer.append("\n");
        }
        writer.close();
    }
    public static void main(String[] args) throws IOException {
        long[] testArr = new long[1000];
        for(int i = 0; i < testArr.length; i++) {
            testArr[i] = i;
        }
        CSVprinter(testArr, "test.csv");
    }
}
