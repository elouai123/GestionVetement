package ma.vet.vetementsgestion.repository;

import ma.vet.vetementsgestion.entity.MyAccList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAccRepository extends JpaRepository<MyAccList, Long> {
}
