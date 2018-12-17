package com.hillel.elementary.javageeks.examples.threads.concurrent.directory_listener;

import java.io.File;
import java.io.FileFilter;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public class DirectoryLister extends Thread {
    private BlockingQueue<File> queue;
    private Set<String> knownFiles;
    private File directory;
    private String extension;

    public DirectoryLister(BlockingQueue<File> queue,
                           File directory, String extension) {
        this.queue = queue;
        this.directory = directory;
        this.extension = extension;
        this.knownFiles = new CopyOnWriteArraySet<>();
    }

    @Override
    public void run() {
        System.out.println("Listening to changes in " + directory);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                listDirectory(directory);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void listDirectory(File dir) throws InterruptedException {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(extension);
            }
        });

        if (files != null && files.length > 0) {
            for (File aFile : files) {
                if (knownFiles.contains(aFile.getName())) continue;
                if (aFile.isDirectory()) {
                    listDirectory(aFile);
                } else {
                    queue.put(aFile);
                    knownFiles.add(aFile.getName());
                }
            }
        }
    }
}
