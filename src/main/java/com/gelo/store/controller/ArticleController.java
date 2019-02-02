package com.gelo.store.controller;


import com.gelo.store.model.Article;
import com.gelo.store.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article")
    public String getArticleById(@RequestParam("id") String id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "article";
    }


    @RequestMapping("/all")
    public String allArticle(Model model){
        model.addAttribute("articles", articleService.getAllArticles());
        return "articles";
    }

    @RequestMapping("/{type}")
    public String getArticlesByType(Model model, @PathVariable("type") String articleType){
        List<Article> articles = articleService.getArticlesByType(articleType);
        if (articles == null || articles.isEmpty())
        model.addAttribute("articles", articles);
        return "articles";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getArticleByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model){
        model.addAttribute("articles", articleService.getArticleByFilter(filterParams));
        return "articles";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewArticleForm(Model model){
        Article newAreicle = new Article();
        model.addAttribute("newArticle", newAreicle);
        return "addArticle";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewArticleForm(@ModelAttribute("newArticle") Article newArticle, BindingResult result, HttpServletRequest request){
        String[] supressedFields = result.getSuppressedFields();
        if(supressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(supressedFields));
        }

        MultipartFile articleImage = newArticle.getArticleImage();
        String fileName = articleImage.getOriginalFilename();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (articleImage!=null && !articleImage.isEmpty()) {
            try {
                articleImage.transferTo(new File(rootDirectory+"resources\\images\\"+ newArticle.getId() + "." + articleService.getFileExtension(fileName) + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }


        articleService.addArticle(newArticle);
        return "redirect:/articles/";

    }

    @InitBinder
    public void initializeBinder(WebDataBinder binder){
        binder.setDisallowedFields();
        binder.setAllowedFields("id", "type", "manufacturer", "brand", "cost", "price", "style");
    }

}
