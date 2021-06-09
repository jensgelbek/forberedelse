/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.Race.RaceDTO;
import entities.Race;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author PC
 */
public class RaceFacade {
    private static RaceFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private RaceFacade(){}
    
    public static RaceFacade getRaceFacade(EntityManagerFactory _emf){
        if (instance==null) {
            emf=_emf;
            instance= new RaceFacade();
        }
        return instance;
    }
    
    public RaceDTO getById(int id)throws WebApplicationException{
        EntityManager em=emf.createEntityManager();
        Race race=em.find(Race.class,id);
        return new RaceDTO(race);
    }
    
    public RaceDTO createRace(RaceDTO raceDTO)throws WebApplicationException{
        EntityManager em=emf.createEntityManager();
        Race race=new Race(raceDTO);
        try {
            em.getTransaction().begin();
            em.persist(race);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return (new RaceDTO(race));
    }
    
    public List<RaceDTO> getAll(){
        EntityManager em=emf.createEntityManager();
        List <Race> races=em.createQuery("SELECT r FROM Race r",Race.class).getResultList();
        return RaceDTO.getDtos(races);
    }
}


/*
@Override
    public RenameMeDTO getById(int id) throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        RenameMe renameMe = em.find(RenameMe.class, id);
        return new RenameMeDTO(renameMe);
    }

    @Override
    public List<RenameMeDTO> getAll() throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        List<RenameMe> renameMes = em.createQuery("SELECT r FROM RenameMe r", RenameMe.class).getResultList();
        return RenameMeDTO.getDtos(renameMes);
    }

    @Override
    public RenameMeDTO createRenameMe(RenameMeDTO renameMeDTO) throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        RenameMe renameMe = new RenameMe(renameMeDTO.getDummyStr1(), renameMeDTO.getDummyStr2());
        try {
            em.getTransaction().begin();
            em.persist(renameMe);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new RenameMeDTO(renameMe);
    }
*/