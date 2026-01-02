import java.util.*;

public class TrafficSpikeDetector {

public static void detectSpike(int[] requests, int k, int threshold) {
int windowSum = 0;
for (int i = 0; i < k; i++) {
windowSum += requests[i];
}
if (windowSum > threshold) {
System.out.println("Spike detected in window ending at index " + (k - 1));
}
for (int i = k; i < requests.length; i++) {
windowSum = windowSum + requests[i] - requests[i - k];
if (windowSum > threshold) {
System.out.println("Spike detected in window ending at index " + i);
}
}
}
public static void main(String[] args) {
int[] requests = {20, 25, 30, 80, 90, 40, 35};
int k = 3;
int threshold = 100;
detectSpike(requests, k, threshold);
}
}
