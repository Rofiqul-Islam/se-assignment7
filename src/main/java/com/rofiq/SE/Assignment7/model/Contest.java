package com.rofiq.SE.Assignment7.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Contest {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int capacity;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationFrom;

    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationTo;

    @Column
    private boolean registrationAllowed;

    @OneToMany(mappedBy ="contest")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Team> attendingTeams = new HashSet<>();

    @ManyToMany
    @JoinTable(name="CONTEST_PERSON",
            joinColumns  ={@JoinColumn(name = "CONTEST_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="PERSON_ID",referencedColumnName = "ID")})
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Person> managers = new HashSet<>();

    @OneToMany(mappedBy = "superContest")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Contest> subContests = new HashSet<>();

    @ManyToOne
    @JoinColumn(name  ="superContest_id")
    private Contest superContest;

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getRegistrationFrom() {
        return registrationFrom;
    }

    public void setRegistrationFrom(Date registrationFrom) {
        this.registrationFrom = registrationFrom;
    }

    public Date getRegistrationTo() {
        return registrationTo;
    }

    public void setRegistrationTo(Date registrationTo) {
        this.registrationTo = registrationTo;
    }

    public boolean isRegistrationAllowed() {
        return registrationAllowed;
    }

    public void setRegistrationAllowed(boolean registrationAllowed) {
        this.registrationAllowed = registrationAllowed;
    }

    public Set<Team> getAttendingTeams() {
        return attendingTeams;
    }

    public void setAttendingTeams(Set<Team> attendingTeams) {
        this.attendingTeams = attendingTeams;
    }

    public Set<Person> getManagers() {
        return managers;
    }

    public void setManagers(Set<Person> managers) {
        this.managers = managers;
    }

    public Set<Contest> getSubContests() {
        return subContests;
    }

    public void setSubContests(Set<Contest> subContests) {
        this.subContests = subContests;
    }

    public Contest getSuperContest() {
        return superContest;
    }

    public void setSuperContest(Contest superContest) {
        this.superContest = superContest;
    }
}
