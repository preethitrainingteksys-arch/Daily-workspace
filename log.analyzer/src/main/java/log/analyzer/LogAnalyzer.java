package log.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/system.log"))) {

            Map<String, Integer> result = analyzeLogs(reader);

            result.forEach((key, value) ->
                    System.out.println(key + ": " + value));

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static Map<String, Integer> analyzeLogs(BufferedReader reader) {

        Map<String, Integer> map = new HashMap<>();
        String line;

        try {
            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] logs = line.split(":");
                if (logs.length > 0) {
                    String logLevel = logs[0].trim();

                    map.put(logLevel, map.getOrDefault(logLevel, 0) + 1);

                  
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        return map;
    }
}