package ilio.algorithm.string;

import java.util.Map;

/**
 * @Author hyia
 * @Date 2020/09/28 15:48
 */
public class UTF8Verifier {

    public static boolean validUtf8(int... data) {
        if (data == null || data.length == 0) {
            return false;
        }

        int i = 0;
        while (i < data.length) {
            int count = 0;
            int offset = 0b10000000;
            while ((data[i] & offset) != 0) {
                offset >>= 1;
                count++;
            }

            if (count == 1 || count > 4 || i + count > data.length) {
                return false;
            }

            count += i;
            i++;
            while (i < count) {
                if ((data[i] & 0b10000000) != 0b10000000) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(validUtf8(10));
//        System.out.println(validUtf8(new int[]{248, 130, 130, 130}));//false
        System.out.println(validUtf8(new int[]{240, 162, 138, 147, 17}));
        System.out.println(validUtf8(new int[]{197, 130, 1}));
        System.out.println(validUtf8(new int[]{235, 140, 4}));
        System.out.println();
    }
}
