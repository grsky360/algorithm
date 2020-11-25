package ilio.algorithm.ms;

import java.util.*;

public class Main2 {

    public static int solution(int A, int B, int C, int D) {
        List<Integer> digests = Arrays.asList(A, B, C, D);
        Set<Integer> res = new HashSet<>();
        for (int i1 = 0; i1 < digests.size(); i1++) {
            int h1 = digests.get(i1);
            if (h1 > 2 || h1 < 0) {
                continue;
            }
            for (int i2 = 0; i2 < digests.size(); i2++) {
                if (i1 == i2) {
                    continue;
                }
                int h2 = digests.get(i2);
                if (!validHour(h1, h2)) {
                    continue;
                }
                for (int i3 = 0; i3 < digests.size(); i3++) {
                    if (i1 == i3 || i2 == i3) {
                        continue;
                    }
                    int m1 = digests.get(i3);
                    if (m1 < 0 || m1 > 59) {
                        continue;
                    }
                    for (int i4 = 0; i4 < digests.size(); i4++) {
                        if (i1 == i4 || i2 == i4 || i3 == i4) {
                            continue;
                        }
                        int m2 = digests.get(i4);
                        if (validMinute(m1, m2)) {
                            res.add(h1 * 1000 + h2 * 100 + m1 * 10 + m2);
                        }
                    }
                }
            }
        }
        System.out.println(res.size());
        System.out.println(res);
        return res.size();
    }

    private static boolean validHour(int a, int b) {
        int h = a * 10 + b;
        return h >= 0 && h <= 23;
    }

    private static boolean validMinute(int a, int b) {
        int m = a * 10 + b;
        return m >= 0 && m <= 59;
    }

    public static void main(String[] args) {
        solution(1, 8, 3, 2); // 6
        solution(2, 3, 3, 2); // 3
        solution(6, 2, 4, 7); // 0
        solution(1, 1, 1, 1); // 1
        solution(1, 1, 1, 2); // 4
        solution(1, 1, 5, 2); // 4
    }
}
