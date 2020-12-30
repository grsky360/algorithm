package ilio.algorithm.string;

public class Format {

    public static String format(String format, String... args) {
        if (args.length == 0) {
            return format;
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        char[] chs = format.toCharArray();
        boolean startFormat = false;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch != '%' && ch != 's') {
                if (startFormat) {
                    builder.append('%');
                    startFormat = false;
                }
                builder.append(ch);
                startFormat = false;
                continue;
            }
            if (startFormat) {
                if (ch == 's' && index < args.length) {
                    builder.append(args[index++]);
                    startFormat = false;
                } else if (ch == '%') {
                    builder.append('%');
                    startFormat = true;
                } else {
                    builder.append('%');
                    startFormat = false;
                }
                continue;
            }
            if (ch == '%') {
                startFormat = true;
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // ab arr kan %d %ab
        System.out.println(format("ab %s kan %%ss %ab", "arr", "d"));
        System.out.println(String.format("ab %s kan %%ss %ab", "arr", "d"));
    }
}
