import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program reads and writes to a file the sum of a set of ints.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-04-01
 */
@SuppressWarnings("HideUtilityClassConstructor")
public class Fibonacci {
  /** Constructor for the ReverseString class. */
  public Fibonacci() {
    // empty constructor
  }

  /**
   * Reads input from a file, reverses string, and write to an output file.
   *
   * @param args Command line arguments (unused).
   */
  public static void main(final String[] args) {
    try {
      // File paths
      String in = "Unit3/Unit3-03/Unit3-03-Java-Fibonacci/input.txt";
      String out = "Unit3/Unit3-03/Unit3-03-Java-Fibonacci/output.txt";
      File inputFile = new File(in);
      File outputFile = new File(out);

      // Initializing scanner and writer
      Scanner scanner = new Scanner(inputFile);
      FileWriter writer = new FileWriter(outputFile);

      // variables
      int fileLine;

      // loops until there is nothing to read
      while (scanner.hasNextLine()) {
        // reads a single line
        fileLine = scanner.nextInt();

        // call the recursive function
        int result = recFib(fileLine);

        // write to file
        writer.write(result + "\n");
      }
      // message to console confirming the process finished with no errors
      System.out.println("Successfully completed task!");

      // close scanner and writer
      scanner.close();
      writer.close();

      // file could not be found
    } catch (IOException e) {
      System.out.println("The file does not exists.");
    } catch (InputMismatchException e) {
      System.out.println("Invalid datatype found in input file.");
    }
  }

  /**
   * This function calculates the fibonacci pattern
   *
   * @param n index of fibonacci value
   * @return an integer value (the value of fibonacci at index n)
   */
  public static int recFib(int n) {
    // Base case n is 0 return 0
    if (n == 0) {
      return 0;

      // base case n = 1 return 1
    } else if (n == 1) {
      return 1;

      // call recursive and multiply result with n
    } else {
      return recFib(n - 1) + recFib(n - 2);
    }
  }
}
