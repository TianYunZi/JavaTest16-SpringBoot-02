package org.spring.boot.security.practise.web;


import org.spring.boot.security.practise.entity.Blog;
import org.spring.boot.security.practise.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by fangzhipeng on 2017/5/15.
 */

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogs")
    public ModelAndView list(Model model) {

        List<Blog> list = blogService.getBlogs();
        model.addAttribute("blogsList", list);
        return new ModelAndView("blogs/list", "blogModel", model);
    }

    @GetMapping(value = "/admin/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        blogService.deleteBlog(id);
        model.addAttribute("blogsList", blogService.getBlogs());
        return new ModelAndView("blogs/list", "blogModel", model);
    }
}
