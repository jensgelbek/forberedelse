/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.Race.RaceDTO;
import dtos.Runner.RunnerDTO;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author PC
 */
@Entity
public class Runner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate bDay;
    
   
    @OneToMany(mappedBy = "runner",cascade = CascadeType.PERSIST)
    private List<Race> races=new ArrayList<>();

    public Runner() {
    }

    public Runner(Long id) {
        this.id = id;
    }

    public Runner(Long id, String name, LocalDate bDay, List<Race> races) {
        this.id = id;
        this.name = name;
        this.bDay = bDay;
        this.races = races;
    }

    public Runner(String name, LocalDate bDay) {
        this.name = name;
        this.bDay = bDay;
    }

    
    public Runner(RunnerDTO runnerDTO) {
        this.id = runnerDTO.getId();
        this.name = runnerDTO.getName();
        this.bDay = runnerDTO.getbDay();
        this.races = new ArrayList<>();
        for (RaceDTO racedto : runnerDTO.getRaces()) {
            this.races.add(new Race(racedto));
        }

    }
    

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

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
    
    public void addRace(Race race){
        if (race!=null) { 
            System.out.println(race);
            System.out.println(this);
            race.setRunner(this);
             System.out.println(race);
            System.out.println(this);
            this.races.add(race);
            System.out.println(race);
            System.out.println(this);
        }
    }

    
    @Override
    public String toString() {
        return "Runner{" + "id=" + id + ", name=" + name + ", bDay=" + bDay +  '}';
    }

    
   

   
}
