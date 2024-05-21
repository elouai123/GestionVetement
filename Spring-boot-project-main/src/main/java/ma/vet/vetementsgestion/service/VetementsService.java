package ma.vet.vetementsgestion.service;

import ma.vet.vetementsgestion.entity.Vetements;
import ma.vet.vetementsgestion.repository.VetementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetementsService {

    @Autowired
    private VetementsRepository vRepo;
    public void save(Vetements v) {vRepo.save(v);}
    public List<Vetements> getAllVetements() { return vRepo.findAll();}
    public Vetements getVetementsById(Long id) { return vRepo.findById(id).get();}
    public void deleteById(Long id) {vRepo.deleteById(id);}
}
