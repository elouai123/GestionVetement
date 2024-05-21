package ma.vet.vetementsgestion.controller;

import ma.vet.vetementsgestion.entity.MyVetList;
import ma.vet.vetementsgestion.entity.Vetements;
import ma.vet.vetementsgestion.service.MyVetListService;
import ma.vet.vetementsgestion.service.VetementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VetementsController {

    @Autowired
    private VetementsService service;
    @Autowired
    private MyVetListService myVetService;

    @GetMapping("/")
    public String home() { return "home";}
    @GetMapping("/vetements_register")
    public String vetementsRegister() { return "vetementsRegister";}

    @GetMapping("/available_vet")
    public ModelAndView getAllVetements() {
        List<Vetements>list=service.getAllVetements();
        return new ModelAndView("vetementsList","vetements",list);
    }
    @PostMapping("/save")
    public String addVetements(@ModelAttribute Vetements v){
        service.save(v);
        return "redirect:/available_vet";
    }
    @GetMapping("/my_vetements")
    public String getMyVet(Model model){
        List<MyVetList>list=myVetService.getAllMyVet();
        model.addAttribute("vetements",list);
        return "myVetements";
    }
    @RequestMapping("myvlist/{id}")
    public String getMyList(@PathVariable("id") Long id){
        Vetements v =service.getVetementsById(id);
        MyVetList mv =new MyVetList(v.getId(),v.getNom(),v.getTaille(),v.getPrix(),v.getQuantite());
        myVetService.saveMyVet(mv);
        return "redirect:/my_vetements";
    }
    @RequestMapping("/editVetements/{id}")
    public String editVetements(@PathVariable("id") Long id,Model model){
        Vetements v = service.getVetementsById(id);
        model.addAttribute("vetements", v);
        return "vetementsEdit";
    }
    @RequestMapping("/deleteVetements/{id}")
    public String deleteVetements(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/available_vet";
    }
}
