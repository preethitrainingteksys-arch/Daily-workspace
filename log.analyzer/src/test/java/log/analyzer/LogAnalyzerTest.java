package log.analyzer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerTest {
    @Test
    void testAnalyzeLogs_withValidLogs() {
        String data = """
                INFO: Application started
                ERROR: Null pointer
                INFO: Processing request
                WARN: Low memory
                ERROR: Failed operation
                """;
        BufferedReader reader = new BufferedReader(new StringReader(data));
        Map<String, Integer> result = LogAnalyzer.analyzeLogs(reader);
        assertEquals(2, result.get("INFO"));
        assertEquals(2, result.get("ERROR"));
        assertEquals(1, result.get("WARN"));
    }
    @Test
    void testAnalyzeLogs_withEmptyFile() {
        String data = "";
        BufferedReader reader = new BufferedReader(new StringReader(data));
        Map<String, Integer> result = LogAnalyzer.analyzeLogs(reader);
        assertTrue(result.isEmpty());
    }
    @Test
    void testAnalyzeLogs_withOnlyOneLogLevel() {
        String data = """
                INFO: Start
                INFO: Continue
                INFO: End
                """;
        BufferedReader reader = new BufferedReader(new StringReader(data));
        Map<String, Integer> result = LogAnalyzer.analyzeLogs(reader);
        assertEquals(3, result.get("INFO"));
        assertEquals(1, result.size());
    }
    @Test
    void testAnalyzeLogs_withMalformedLines() {
        String data = """
                INFO: Valid log
                Invalid log line
                ERROR: Another log
                : Missing level
                """;
        BufferedReader reader = new BufferedReader(new StringReader(data));
        Map<String, Integer> result = LogAnalyzer.analyzeLogs(reader);
        assertEquals(1, result.get("INFO"));
        assertEquals(1, result.get("ERROR"));
    }
    @Test
    void testAnalyzeLogs_withExtraSpaces() {
        String data = """
                INFO   : Start
                  ERROR: Fail
                WARN    : Warning
                """;
        BufferedReader reader = new BufferedReader(new StringReader(data));
        Map<String, Integer> result = LogAnalyzer.analyzeLogs(reader);
        assertEquals(1, result.get("INFO"));
        assertEquals(1, result.get("ERROR"));
        assertEquals(1, result.get("WARN"));
    }
}