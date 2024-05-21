package ma.vet.vetementsgestion.controller;

import ma.vet.vetementsgestion.service.MyVetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyVetListController {
    @Autowired
    private MyVetListService service;
    @RequestMapping("/deleteMyVList/{id}")
    public String deleteMyList(@PathVariable("id") long id){
        service.deleteById(id);
        return "redirect:/my_vetements";
    }
}
