package com.gluuten.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yusufaslan on 25.05.2017.
 */
@Entity
@Table(name = "friends")
public class Friends implements Serializable{

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "friends",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    @JsonIgnore
    @Column
    private Set<Person> friends = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "friends",
            joinColumns = @JoinColumn(name = "friend_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    @JsonIgnore
    @Column
    private Set<Person> friendOf = new HashSet<>();

    public boolean hasFriend(Person friend)
    {
        return friends.contains(friend);
    }
    public void addFriend(Person friend)
    {
        friends.add(friend);
        friendOf.add(friend);

    }
    public void removeFriend(Person friend){
        friends.remove(friend);
        friendOf.remove(this);
        //friendOf.remove(this);
    }
    public boolean isFriendOf(Person person){
        return friendOf.contains(person);
    }


    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public Set<Person> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(Set<Person> friendOf) {
        this.friendOf = friendOf;
    }



    public Friends(Set<Person> friends, Set<Person> friendOf) {
        this.friends = friends;
        this.friendOf = friendOf;
    }
}
