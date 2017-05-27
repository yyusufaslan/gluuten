package com.gluuten.repository;

import com.gluuten.entities.Comment;
import com.gluuten.entities.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by yusufaslan on 25.05.2017.
 */
public interface CommentRepository extends CrudRepository<Comment,Long> {

    List<Comment> findByCommentOfPostOrderByCommentDate(Post post);
   // List<Comment> findBy

//verilen kullanıcıya göre commentleri tarihe göre getir

}
