package com.hillel.elementary.javageeks.examples.threads.concurrent.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class LinkFinderAction  extends RecursiveAction {

    private String url;
    private LinkHandler linkHandler;

    private static long startTime = System.nanoTime();

    public LinkFinderAction(String url, LinkHandler cr) {
        this.url = url;
        this.linkHandler = cr;
    }

    @Override
    public void compute() {
        if (!linkHandler.visited(url)) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a");
                List<RecursiveAction> actions = new ArrayList<RecursiveAction>();

                for (Element link : links) {
                    String foundUrl = link.attr("abs:href").toLowerCase();

                    if (!foundUrl.isEmpty() && !linkHandler.visited(foundUrl)) {
                        actions.add(new LinkFinderAction(foundUrl, linkHandler));
                    }

                }
                linkHandler.addVisited(url);

                if (linkHandler.size() == 1500) {
                    System.out.println("Time to visit 1500 distinct links = " + (System.nanoTime() - startTime));
                    System.exit(0);
                }

                //invoke recursively
                invokeAll(actions);
            } catch (Exception e) {
                //ignore 404, unknown protocol or other server errors
            }
        }
    }
}