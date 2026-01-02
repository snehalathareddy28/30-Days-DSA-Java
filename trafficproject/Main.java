import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<TrafficLog> logs = Arrays.asList(
                new TrafficLog(20),
                new TrafficLog(25),
                new TrafficLog(30),
                new TrafficLog(80),
                new TrafficLog(90),
                new TrafficLog(40),
                new TrafficLog(35)
        );

        TrafficAnalyzer analyzer = new TrafficAnalyzer();
        analyzer.analyze(logs, 3, 100);
    }
}
