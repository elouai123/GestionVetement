package ma.vet.vetementsgestion.service;

import ma.vet.vetementsgestion.entity.Accessoire;
import ma.vet.vetementsgestion.repository.AccessoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoireService {

    @Autowired
    private AccessoireRepository ARepo;

    public void save(Accessoire a) {ARepo.save(a);}
    public List<Accessoire>getAllAccessoire() { return ARepo.findAll();}
    public Accessoire getAccessoireByID(Long id) {return ARepo.findById(id).get();}
    public void deleteById(Long id) {ARepo.deleteById(id);}
}
