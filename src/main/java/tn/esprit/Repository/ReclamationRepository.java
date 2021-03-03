package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Reclamation;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {
}
