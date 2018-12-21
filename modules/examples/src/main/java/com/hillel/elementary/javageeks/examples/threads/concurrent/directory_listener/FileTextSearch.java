package com.hillel.elementary.javageeks.examples.threads.concurrent.directory_listener;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileTextSearch {

    public static void main(String[] args) {
        String dirPath = Paths.get("/home/dev/tmp/1").toAbsolutePath().toString();
        String extension = ".txt";
        String keyword = "hello";

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(100);

        DirectoryLister lister = new DirectoryLister(queue, new File(dirPath), extension);
        lister.start();

        for (int i = 0; i < 10; i++) {
            FileParser parser = new FileParser(queue, keyword);
            parser.start();
        }
    }
}
