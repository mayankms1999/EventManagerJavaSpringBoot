package com.cn.cnEvent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "experience")
    private Long experience;

    @ManyToMany(mappedBy = "speakers")
    private List<Event> events;
    
    
//	   @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
//	   @JoinTable(name="speaker_id",joinColumns = @JoinColumn(name="speaker_id"),inverseJoinColumns = @JoinColumn(name="event_id"))
//	   @JsonManagedReference
//	    List<Event> events; //(Many To Many mapping)

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

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    @JsonIgnore
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
