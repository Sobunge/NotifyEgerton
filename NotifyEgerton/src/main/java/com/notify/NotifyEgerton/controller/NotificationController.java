package com.notify.NotifyEgerton.controller;

import com.notify.NotifyEgerton.model.Post;
import com.notify.NotifyEgerton.service.PostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    PostService postService;

    List<Post> posts = new ArrayList<>();

    @RequestMapping("group/{groupId}/all")
    public int getAllGroupNot(@PathVariable Long groupId) {

        posts = postService.getAllGroupPost(groupId);

        return posts.size();
    }
}
