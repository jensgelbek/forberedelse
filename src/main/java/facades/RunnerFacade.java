package facades;

import dtos.RenameMeDTO;
import dtos.Runner.RunnerDTO;
import entities.Runner;
import entities.renameme.RenameMe;
import entities.renameme.RenameMeRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class RunnerFacade  {

    private static RunnerFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private RunnerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RunnerFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RunnerFacade();
        }
        return instance;
    }

    //TODO Remove/Change this before use
    public long getRunnerCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long runnerCount = (long)em.createQuery("SELECT COUNT(r) FROM Runner r").getSingleResult();
            return runnerCount;
        }finally{  
            em.close();
        }
        
    }
    
    public Runner createRunner(Runner runner){
        EntityManager em = emf.createEntityManager();
        
        try{
        em.getTransaction().begin();
        em.persist(runner);
        em.getTransaction().commit();
        }
        finally{
            em.close();
        }
       
        return runner;
    }

   
}
