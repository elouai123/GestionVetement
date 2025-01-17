package ma.vet.vetementsgestion.repository;

import ma.vet.vetementsgestion.entity.Accessoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoireRepository extends JpaRepository<Accessoire, Long> {
}
