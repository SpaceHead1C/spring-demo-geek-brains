package ru.nd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.nd.model.Article;
import ru.nd.service.ArticleService;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private ArticleService service;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/blog")
    public String mainPage(Model model) {
        model.addAttribute("articles", service.getAll());

        return "main";
    }

    @RequestMapping(value = "/blog/editor")
    public String editorPage(Model model) {
        model.addAttribute("article", new Article());

        return "editor";
    }

    @RequestMapping(value = "/blog/editor/submit", method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute Article article) {
        service.save(article);

        return "redirect:../";
    }

    @RequestMapping(value = "/blog/login")
    public String loginPage() {
        return "login";
    }
}
