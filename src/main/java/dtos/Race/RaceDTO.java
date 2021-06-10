/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos.Race;

import dtos.Runner.RunnerDTO;
import entities.Race;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class RaceDTO {

    private Long id;
    private Date date;
    private String name;
    private double distance;
    private String raceTime;
    private RunnerDTO runnerDTO;

    public RaceDTO(Date date, String name, double distance, String raceTime, RunnerDTO runnerDTO) {
        this.date = date;
        this.name = name;
        this.distance = distance;
        this.raceTime = raceTime;
        this.runnerDTO = runnerDTO;
    }
    
    

    public RaceDTO(Race race) {
        this.id = race.getId();
        this.date = race.getDate();
        this.name = race.getName();
        this.raceTime = race.getTime();
        this.distance = race.getDistance();
        
        
    }

    public static List<RaceDTO> getDtos(List<Race> races) {
        List<RaceDTO> raceDTOs = new ArrayList();
        races.forEach(race -> raceDTOs.add(new RaceDTO(race)));
        return raceDTOs;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    @Override
    public String toString() {
        return "RaceDTO{" + "id=" + id + ", date=" + date + ", name=" + name + ", distance=" + distance + ", raceTime=" + raceTime + '}';
    }

}
