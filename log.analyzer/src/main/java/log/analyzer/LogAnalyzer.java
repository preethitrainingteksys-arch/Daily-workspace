package log.analyzer;

import java.io.*;
import java.util.*;

public class LogAnalyzer {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        String fileName = "system.log";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Split log type and message
                String[] parts = line.split(":");

                if (parts.length > 0) {
                    String logType = parts[0].trim();

                    // Count occurrences
                    map.put(logType, map.getOrDefault(logType, 0) + 1);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Log file not found!");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print results
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}