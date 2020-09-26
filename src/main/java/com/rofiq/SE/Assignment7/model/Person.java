package com.rofiq.SE.Assignment7.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String university;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthDate;


    @ManyToMany(mappedBy = "contestants")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Team> teams = new HashSet<>();

    @ManyToMany(mappedBy = "managers")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Contest> contests = new HashSet<>();

    @OneToMany(mappedBy = "coach")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Team> coachedTeams = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Team> getCoachedTeams() {
        return coachedTeams;
    }

    public void setCoachedTeams(Set<Team> coachedTeams) {
        this.coachedTeams = coachedTeams;
    }
}
