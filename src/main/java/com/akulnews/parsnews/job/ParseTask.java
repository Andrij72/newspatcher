package com.akulnews.parsnews.job;

import com.akulnews.parsnews.model.News;
import com.akulnews.parsnews.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class ParseTask {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 10000)
    public void parseNewNews() throws IOException {
        String url = "https://news.ycombinator.com/news?p=3";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Google Chrome")
                    .timeout(5000)
                    .referrer("http://google.com")
                    .get();
            Elements news = doc.getElementsByClass("titlelink");
            for (Element el : news) {
                String titleLink = el.ownText();
                if (!newsService.isExist(titleLink)) {
                    News obj = new News();
                    obj.setTitle(titleLink);
                    newsService.save(obj);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
