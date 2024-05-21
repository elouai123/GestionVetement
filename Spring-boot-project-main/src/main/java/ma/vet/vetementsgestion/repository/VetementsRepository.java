package ma.vet.vetementsgestion.repository;

import ma.vet.vetementsgestion.entity.Vetements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetementsRepository extends JpaRepository<Vetements, Long> {
}
