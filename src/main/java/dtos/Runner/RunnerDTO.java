/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos.Runner;

import dtos.Race.RaceDTO;
import entities.Race;
import entities.Runner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
public class RunnerDTO {
    private Long id;
    private String name;
    private LocalDate bDay;
    private List<RaceDTO> racedtos=new ArrayList<>();

    public RunnerDTO(Long id, String name, LocalDate bDay,List<RaceDTO> racedtos) {
        this.id = id;
        this.name = name;
        this.bDay = bDay;
        this.racedtos=racedtos;
    }
    
    public RunnerDTO(Runner runner){
        this.id=runner.getId();
        this.name=runner.getName();
        this.bDay=runner.getbDay();
        this.racedtos=new ArrayList<>();
        for(Race race:runner.getRaces()){
            this.racedtos.add(new RaceDTO(race));
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

    public List<RaceDTO> getRaces() {
        return racedtos;
    }

    public void setRaces(List<RaceDTO> racedtos) {
        this.racedtos = racedtos;
    }

    @Override
    public String toString() {
        return "RunnerDTO{" + "id=" + id + ", name=" + name + ", bDay=" + bDay +  '}';
    }
    
    

}
