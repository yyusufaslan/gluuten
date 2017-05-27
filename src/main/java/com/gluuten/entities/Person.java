package com.gluuten.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by yusufaslan on 25.05.2017.
 */
@Entity
@Table(name = "persons")
public class Person implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private String about;

    @Column
    private String city;

    @Column
    private String location;

    @Temporal(TemporalType.DATE)
    @Column
    private Date birthDate;

    @Convert(converter = GenderConverter.class)
    @Column
    private Gender gender; //= Gender.UNDEFINED;

    @Column(updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created =new Date();



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities().stream().map(r-> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public Person(String firstName, String lastName, String userName, String email, String password, String phone, String about, String city, String location, Date birthDate, Gender gender, Date created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.about = about;
        this.city = city;
        this.location = location;
        this.birthDate = birthDate;
        this.gender = gender;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
