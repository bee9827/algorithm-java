import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> {
            if(Math.abs(o1) > Math.abs(o2)) {
                return Math.abs(o1) - Math.abs(o2);
            }else if(Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }else {
                return -1;
            }
        });

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Integer number = Integer.valueOf(br.readLine());
            if (number == 0) {
                if (pq.isEmpty()) {
                    sb.append("0").append(System.lineSeparator());
                } else {
                    sb.append(pq.poll()).append(System.lineSeparator());
                }
            }else {
                pq.add(number);
            }
        }

        System.out.println(sb);
    }

    private static void readInput() throws IOException {

    }
}
