package com.akulnews.parsnews.api;

import com.akulnews.parsnews.model.News;
import com.akulnews.parsnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
