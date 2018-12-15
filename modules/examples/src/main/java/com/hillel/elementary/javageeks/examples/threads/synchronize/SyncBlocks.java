package com.hillel.elementary.javageeks.examples.threads.synchronize;

public class SyncBlocks {

    public synchronized static void abs(int[] values) {
        synchronized (values) { //доступ к массиву values блокируется со стороны других потоков
            for (int i = 0; i < values.length; i++) {
                if (values[i] < 0) values[i] = -values[i];
            }
        }
    }
}
