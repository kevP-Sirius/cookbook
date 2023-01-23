package com.cookbook.app.Service.Comment;

import com.cookbook.app.Entity.Comment;
import com.cookbook.app.Repository.CommentRepository;

import java.util.List;

public class CommentService implements ICommentService{
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment createRecipe(Comment comment){
        return commentRepository.save(comment);
    }

    public boolean deleteRecipe(Comment comment){
        commentRepository.delete(comment);

        return true;
    }

}
