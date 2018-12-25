package com.hillel.elementary.javageeks.examples.threads.concurrent.crawler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorWebCrawler implements LinkHandler {

    private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
    private String url;
    private ExecutorService execService;

    public ExecutorWebCrawler(String startingURL, int maxThreads) {
        this.url = startingURL;
        execService = Executors.newFixedThreadPool(maxThreads);
    }

    @Override
    public void queueLink(String link) throws Exception {
        startNewThread(link);
    }

    @Override
    public int size() {
        return visitedLinks.size();
    }

    @Override
    public void addVisited(String s) {
        visitedLinks.add(s);
    }

    @Override
    public boolean visited(String s) {
        return visitedLinks.contains(s);
    }

    private void startNewThread(String link) throws Exception {
        execService.execute(new LinkFinder(link, this));
    }

    public void startCrawling() throws Exception {
        startNewThread(this.url);
    }

    public static void main(String[] args) throws Exception {
        ExecutorWebCrawler webCrawler = new ExecutorWebCrawler("http://kpi.ua", 64);
        webCrawler.startCrawling();
    }

}