package com.gluuten.entities;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 25.05.2017.
 */
@Entity
@Table(name = "messeages")
public class Messeage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String messeageBody;

    @Column(updatable = false,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date messeageDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "messeage_sender_id")
    private Person messeageSender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "messeage_recipient_id")
    private Person messeageRecipient;


    public Messeage(String messeageBody, Date messeageDate, Person messeageSender, Person messeageRecipient) {
        this.messeageBody = messeageBody;
        this.messeageDate = messeageDate;
        this.messeageSender = messeageSender;
        this.messeageRecipient = messeageRecipient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMesseageBody() {
        return messeageBody;
    }

    public void setMesseageBody(String messeageBody) {
        this.messeageBody = messeageBody;
    }

    public Date getMesseageDate() {
        return messeageDate;
    }

    public void setMesseageDate(Date messeageDate) {
        this.messeageDate = messeageDate;
    }

    public Person getMesseageSender() {
        return messeageSender;
    }

    public void setMesseageSender(Person messeageSender) {
        this.messeageSender = messeageSender;
    }

    public Person getMesseageRecipient() {
        return messeageRecipient;
    }

    public void setMesseageRecipient(Person messeageRecipient) {
        this.messeageRecipient = messeageRecipient;
    }
}
