import java.util.*;

public class TrafficAnalyzer {

    public void analyze(List<TrafficLog> logs, int windowSize, int threshold) {
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += logs.get(i).requests;
        }

        checkSpike(windowSum, threshold, windowSize - 1);

        for (int i = windowSize; i < logs.size(); i++) {
            windowSum += logs.get(i).requests;
            windowSum -= logs.get(i - windowSize).requests;

            checkSpike(windowSum, threshold, i);
        }
    }

    private void checkSpike(int sum, int threshold, int index) {
        if (sum > threshold) {
            System.out.println("⚠ ALERT: Traffic spike at second " + index);
        }
    }
}
