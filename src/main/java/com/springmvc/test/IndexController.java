package com.springmvc.test;

import com.springmvc.test.entity.News;
import com.springmvc.test.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("indexController")
public class IndexController {
    @Autowired(required = true)
    @Qualifier(value = "NewsService")
    private NewsService newsService;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        List<News> newsList = newsService.searchByPage(News.class, 1, 8, "order by created_at desc");
        request.setAttribute("newsList",newsList);
        return "index";
    }
}
