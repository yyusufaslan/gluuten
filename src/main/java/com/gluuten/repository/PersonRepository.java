package com.gluuten.repository;

import com.gluuten.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by yusufaslan on 25.05.2017.
 */
public interface PersonRepository extends PagingAndSortingRepository<Person,Long> {

    Person findByPhone (Long pohone);

    Person findByEmail(String email);

    Person findPeopleBy(@Param("searchTerm") String searchTerm, Pageable pageRequest);


    ///bunlar friend repositoryde
    Page<Person> findFriends(@Param("person") Person person,
                             @Param("searchTerm") String searchTerm,
                             Pageable pageRequest);

    Page<Person> findFriendOf(
            @Param("person") Person person,
            @Param("searchTerm") String searchTerm,
            Pageable pageRequest);
}
