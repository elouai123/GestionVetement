package ma.vet.vetementsgestion.controller;

import ma.vet.vetementsgestion.entity.Accessoire;
import ma.vet.vetementsgestion.entity.MyAccList;
import ma.vet.vetementsgestion.service.AccessoireService;
import ma.vet.vetementsgestion.service.MyAccListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class AccessoireController {

    @Autowired
    private AccessoireService service;
    @Autowired
    private MyAccListService myAccService;

    @GetMapping("/accessoire_register")
    public String AccessoireRegister() {return "accessoireRegister";}

    @GetMapping("/available_acc")
    public ModelAndView getAllAccessoire() {
        List<Accessoire>list=service.getAllAccessoire();
        return new ModelAndView("accessoireList","accessoire",list);
    }
    @PostMapping("/asave")
    public String addAccessoire(@ModelAttribute Accessoire a){
        service.save(a);
        return "redirect:/available_acc";
    }

    @GetMapping("/my_accessoire")
    public String getMyAcc(Model model){
        List<MyAccList>list=myAccService.getAllMyAcc();
        model.addAttribute("accessoire",list);
        return "myAccessoire";

    }

    @RequestMapping("myalist/{id}")
    public String getMyList(@PathVariable("id") Long id){
        Accessoire a = service.getAccessoireByID(id);
        MyAccList ma = new MyAccList(a.getId(),a.getNom(),a.getTaille(),a.getPrix(),a.getQuantite());
        myAccService.saveMyAcc(ma);
        return "redirect:/my_accessoire";
    }

    @RequestMapping("/editAccessoire/{id}")
    public String editAccessoire(@PathVariable("id") Long id, Model model){
        Accessoire a = service.getAccessoireByID(id);
        model.addAttribute("accessoire", a);
        return "accessoireEdit";
    }

    @RequestMapping("/deleteAccessoire/{id}")
    public String deleteAccessoire(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/available_acc";
    }
}
