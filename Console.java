package kr.owens.alarm.util;

public class Console {

    private static boolean isPrintTag = false;

    private static final String TAG = "[OWEN]";
    private static final String START_TAG = "[OWEN] ";
    private static final String NEW_LINE = "\n";
    private static final String LINE_CHAR = "=";
    private static String LINES = null;

    private static final int LINE_LEN = 40;

    static {
        StringBuilder sb = new StringBuilder();
        int totalLen = LINE_LEN + 1;

        if (LINE_LEN % 2 != 0) {
            totalLen++;
        }

        for (int i = 0; i < totalLen; i++) {
            if (i == totalLen / 2) {
                sb.append(TAG);
                continue;
            }

            sb.append(LINE_CHAR);
        }

        LINES = sb.toString().intern();
    }

    public static void setTagOption(boolean option) {
        isPrintTag = option;
    }

    public static void startWithLines(String message) {
        System.out.println(LINES + NEW_LINE + message);
    }

    public static void startWithLines(String format, Object... objects) {
        System.out.println(LINES + NEW_LINE + String.format(format, objects));
    }

    public static void endWithLines(String message) {
        System.out.println(message + NEW_LINE + LINES);
    }

    public static void endWithLines(String format, Object... objects) {
        System.out.println(String.format(format, objects) + NEW_LINE + LINES);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void print(String format, Object... objects) {
        System.out.print(String.format(format, objects));
    }

    public static void println(String message) {
        if (isPrintTag) {
            System.out.println(START_TAG + message);
        } else {
            System.out.println(message);
        }
    }

    public static void println(String format, Object... objects) {
        if (isPrintTag) {
            System.out.println(START_TAG + String.format(format, objects));
        } else {
            System.out.println(String.format(format, objects));
        }
    }
}
