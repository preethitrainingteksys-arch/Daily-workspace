package log.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/system.log"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] logs = line.split(":");
                if (logs.length > 0) {
                    String logLevel = logs[0].trim();
                    map.put(logLevel, map.get(logLevel) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}