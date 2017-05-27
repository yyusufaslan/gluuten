package com.gluuten.repository;

import com.gluuten.entities.Messeage;
import com.gluuten.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by yusufaslan on 25.05.2017.
 */
public interface MesseageRepository extends CrudRepository<Messeage,Long> {


    @Query("SELECT m " +
            "FROM Message m " +
            "WHERE m.messeageSender = :messeageSender AND m.messeageRecipient = :messeageRecipient " +
            "   OR m.messeageSender = :messeageRecipient AND m.messeageRecipient = :messeageSender " +
            "ORDER BY m.messeageDate DESC")
    List<Messeage> findByMesseageRecipientOrMesseageSenderOrderByMesseageDateDesc(
            @Param("messeageSender")Person messeageSender,
            @Param("messeageRecipient") Person messeageRecipient);


    @Query("SELECT m " +
            "FROM Message m " +
            "WHERE m.id IN (" +
            "   SELECT MAX(l.id) " +
            "   FROM Message l " +
            "   WHERE l.messeageSender = :person OR l.messeageRecipient = :person " +
            "   GROUP BY " +
            "       CASE " +
            "           WHEN l.messeageRecipient = :person THEN l.messeageSender " +
            "           WHEN l.messeageSender = :person THEN l.messeageRecipient " +
            "           ELSE :person " +
            "       END) " +
            "ORDER BY m.messeageDate DESC")
    List<Messeage> findLastMesseagesByPerson(@Param("person")Person person);


}
