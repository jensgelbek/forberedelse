/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.Race.RaceDTO;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
public class Race implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String name;
    private double distance;
    private String raceTime;
    @ManyToOne
    private Runner runner;

    public Race() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Race other = (Race) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   

    public Race( Date date, String name, double distance, String raceTime, Runner runner) {
      
        this.date = date;
        this.name = name;
        this.distance = distance;
        this.raceTime = raceTime;
        this.runner = runner;
    }

    public Race(Date date, String name, double distance, String raceTime) {
        this.date = date;
        this.name = name;
        this.distance = distance;
        this.raceTime = raceTime;
    }

    
    
    public Race (RaceDTO raceDTO){
         this.date = raceDTO.getDate();
        this.name = raceDTO.getName();
        this.distance = raceDTO.getDistance();
        this.raceTime = raceDTO.getRaceTime();
    }
    
    public String getTime() {
        return raceTime;
    }

    public void setTime(String time) {
        this.raceTime = time;
    }

    
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    @Override
    public String toString() {
        return "Race{" + "id=" + id + ", date=" + date + ", name=" + name + ", distance=" + distance + ", raceTime=" + raceTime + '}';
    }

    

   
    
}
