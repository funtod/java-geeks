package com.hillel.elementary.javageeks.examples.threads.concurrent.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class LinkFinder implements Runnable {

    private String url;
    private LinkHandler linkHandler;

    private static long startTime = System.nanoTime();

    public LinkFinder(String url, LinkHandler handler) {
        this.url = url;
        this.linkHandler = handler;
    }

    @Override
    public void run() {
        crawl(url);
    }

    private void crawl(String url) {
        if (!linkHandler.visited(url)) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a");
                List<String> urls = new ArrayList<String>();

                for (Element link : links) {
                    String foundUrl = link.attr("abs:href").toLowerCase();

                    if (!foundUrl.isEmpty() && !linkHandler.visited(foundUrl)) {
                        urls.add(foundUrl);
                    }

                }
                linkHandler.addVisited(url);

                if (linkHandler.size() == 150) {
                    System.out.println("Time to visit 1500 distinct links = " + (System.nanoTime() - startTime));
                    System.exit(0);
                }

                for (String l : urls) {
                    linkHandler.queueLink(l);
                }

            } catch (Exception e) {
                //ignore all errors for now
            }
        }
    }


}
