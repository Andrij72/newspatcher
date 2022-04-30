package com.akulnews.parsnews.service;

import com.akulnews.parsnews.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    void save(News news);

    List<News> getAllNews();

    boolean isExist(String newsTitle);
}
