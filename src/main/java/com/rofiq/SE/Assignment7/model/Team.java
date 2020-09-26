package com.rofiq.SE.Assignment7.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int rank;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToMany
    @JoinTable(name="TEAM_PERSON",
            joinColumns  ={@JoinColumn(name = "TEAM_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="PERSON_ID",referencedColumnName = "ID")})
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Person> contestants = new HashSet<>();

    @ManyToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Contest contest;


    @ManyToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Person coach;

    @OneToOne
    @JoinColumn(name = "oldTeam_id")
    private Team oldTeam;

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<Person> getContestants() {
        return contestants;
    }

    public void setContestants(Set<Person> contestants) {
        this.contestants = contestants;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

    public Team getOldTeam() {
        return oldTeam;
    }

    public void setOldTeam(Team oldTeam) {
        this.oldTeam = oldTeam;
    }
}
