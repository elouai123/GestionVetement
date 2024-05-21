package ma.vet.vetementsgestion.repository;

import ma.vet.vetementsgestion.entity.MyVetList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyVetRepository extends JpaRepository<MyVetList, Long> {
}
