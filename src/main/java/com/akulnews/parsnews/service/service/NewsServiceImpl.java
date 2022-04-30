package com.akulnews.parsnews.service.service;

import com.akulnews.parsnews.model.News;
import com.akulnews.parsnews.repository.NewsRepository;
import com.akulnews.parsnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final
    NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> newsList = newsRepository.findAll();
        return newsList.stream()
                .filter(s -> s.getTitle()
                .equals(newsTitle))
                .findAny()
                .isPresent();
    }
}
