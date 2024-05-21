package ma.vet.vetementsgestion.service;

import ma.vet.vetementsgestion.entity.MyAccList;
import ma.vet.vetementsgestion.repository.MyAccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAccListService {

    @Autowired
    private MyAccRepository MyAcc;

    public void saveMyAcc(MyAccList acc) {MyAcc.save(acc);}
    public void deleteById(Long id) { MyAcc.deleteById(id);}
    public List<MyAccList> getAllMyAcc() {return MyAcc.findAll();}

}
