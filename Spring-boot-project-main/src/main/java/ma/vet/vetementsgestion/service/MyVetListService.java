package ma.vet.vetementsgestion.service;

import ma.vet.vetementsgestion.entity.MyVetList;
import ma.vet.vetementsgestion.repository.MyVetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyVetListService {
    @Autowired
    private MyVetRepository myVet;
    public void saveMyVet(MyVetList vet) {myVet.save(vet);}
    public List<MyVetList> getAllMyVet() {return myVet.findAll();}
    public void deleteById(Long id) { myVet.deleteById(id);}
}
