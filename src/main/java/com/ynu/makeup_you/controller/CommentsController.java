package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.entity.Comments;
import com.ynu.makeup_you.repository.PostMessageRepository;
import com.ynu.makeup_you.repository.UserRepository;
import com.ynu.makeup_you.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    private PostMessageRepository postMessageRepository;

    @Autowired
    private UserRepository userRepository;

    // 得到某用户的所有评论
    @GetMapping("/getCommentsByUID/{userid}")
    public List<Comments> getCommentsForUser(@PathVariable("userid") String id){
        return commentsService.getAllcommentsOfUser(id);
    }

    // 得到此帖子下的所有评论
    @GetMapping("/getCommentsByPID/{postid}")
    public List<Comments> getCommentsForPostmsg(@PathVariable("postid") String id){
        return commentsService.getAllCommentsOfPostmsg(id);
    }

    // 增加一条评论记录
    @PostMapping("/addRecord")
    public void addRecord(Comments comments) {
        commentsService.addRecord(comments);
    }

    // 删除一条记录
    @DeleteMapping("/deleteRecord/{uid,pid}")
    public void deleteRecord(@PathVariable("uid") String uid, @PathVariable("pid") String pid){
        commentsService.deleteRecord(uid,pid);
    }

}
