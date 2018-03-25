package org.spring.boot.security.practise.service;

import org.spring.boot.security.practise.entity.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> getBlogs();

    void deleteBlog(long id);
}
