package com.gluuten.repository;

import com.gluuten.entities.Post;
import com.gluuten.entities.Person;
import javafx.geometry.Pos;
import org.springframework.data.repository.CrudRepository;

import javax.ws.rs.POST;
import java.util.List;

/**
 * Created by yusufaslan on 25.05.2017.
 */
public interface PostRepository extends CrudRepository<Post,Long> {

    List<Post> findAllOrderByPostDate();
    List<Post> findAllByPersonOOrderByPostDate(Person person);

    //verilen personun tüm post lerini postdatelerine göre getirecek
    //tüm postları tarihe göre getirecek
    //





}
