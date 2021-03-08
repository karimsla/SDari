package tn.esprit.dari.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.dari.entities.Reclamation;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.ReclamationRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;


import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReclamationService implements IReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;
    @Autowired
    private UtilisateurRepository userRepo;




    @Override
    public Boolean Create(@Valid Reclamation reclamation, int userid) {

        if(userid!=0 && reclamation!=null ){
           // long id=(long)userid;
            Utilisateur user=userRepo.findById((long)userid).get();
            reclamation.setUser(user);
            reclamationRepository.save(reclamation);
            return true;

        }
        return false;

    }

    @Override
    public void Delete(int id) {
        reclamationRepository.deleteById(id);

    }

    @Override
    public void treat(int id, String treatement) {
        Reclamation reclamation=reclamationRepository.findById(id).orElse(null);
        if (reclamation != null && !reclamation.getState()) {
            reclamation.setTreatement(treatement);
            reclamation.setState(true);
            reclamationRepository.save(reclamation);
        }
    }

    @Override
    public Reclamation getOne(int id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reclamation> findAll() {
        return reclamationRepository.findAll(Sort.by(Sort.Direction.DESC, "dateTime"));
    }

    @Override
    public List<Reclamation> findNotTreated() {
        return reclamationRepository.findNotTreated();
    }

    @Override
    public List<Reclamation> findMyReclam(int id) {
        return reclamationRepository.findMyReclams(id);
    }

    @Override
    public List<Reclamation> filter(String filter) {
        return reclamationRepository.findByFilter(filter);
    }

    @Override
    public List<Reclamation> findBetweenDate(LocalDateTime start, LocalDateTime end) {
        return reclamationRepository.findBetweenDate(start,end);
    }

    @Override
    public List<Reclamation> findByType(String type) {
        return reclamationRepository.findByType(type);
    }
}
