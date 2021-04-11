package com.jetbrains;
import javax.swing.Timer;

public class RegexCharSequence implements CharSequence {
    private final CharSequence inner;
    private static Timer timer;
    private static final int TIME_LIMIT = 5000;

    public RegexCharSequence(CharSequence inner) {
        super();
        this.inner = inner;
        timer = new Timer(TIME_LIMIT, e -> timer.stop());
        timer.start();
    }

    public char charAt(int index) {
        if (!timer.isRunning()) {
            throw new RuntimeException("Time limit exceeded: 5s");
        }
        return inner.charAt(index);
    }

    public int length() {
        return inner.length();
    }

    public CharSequence subSequence(int start, int end) {
        return new RegexCharSequence(inner.subSequence(start, end));
    }

    @Override
    public String toString() {
        return inner.toString();
    }
}
