package com.example.bilabonnementcase.controllers;

import com.example.bilabonnementcase.models.Damage;
import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.repositories.RepairListRepository;
import com.example.bilabonnementcase.services.RepairListServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpSession;

//Author: Güler, Chris
@Controller
public class RepairListController {

    private RepairListServices repairListServices = new RepairListServices(new RepairListRepository());

    @GetMapping("/create-repair")
    public String createRepairList(){
        return "createPages/createRepairList";
    }

    @GetMapping("/create-repairlist")
    public String createRepairListStepTwo(){
        return "createPages/createRepairListStepTwo";
    }

    @GetMapping("/add-damage")
    public String addDamageToRepairList(){
        return "createPages/addDamagesToRepairList";
    }

    @GetMapping("/createRepairListSuccessPage")
    public String createRepairListSuccessPage(){
        return "successPages/createRepairListSuccessPage";
    }

    @GetMapping("/car-not-ready")
    public String carNorReady(){
        return "errorPages/carNotReadyForRepair";
    }

    @PostMapping("/createRepairList")
    public String startCreateRepairList(WebRequest dataFromForm, HttpSession session){
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));

        session.setAttribute("carNumber", carNumber);

        String returnSite = repairListServices.goToCreateRepairList(carNumber);

        return returnSite;
    }

    @PostMapping("create-repairlist")
    public String createRepairListStepTwo(WebRequest dataFromForm, HttpSession session){
        int repairListId = -1;

        String repairStart = dataFromForm.getParameter("repairStartDate");
        int carNumber = (int) session.getAttribute("carNumber");

        RepairList repairListToCreate = new RepairList(repairListId, repairStart, carNumber);

        String returnSite = repairListServices.createRepairList(repairListToCreate);

        return returnSite;
    }

    @PostMapping("add-damage")
    public String addDamageToRepairList(WebRequest dataFromForm, HttpSession session){
        int carNumber = (int) session.getAttribute("carNumber");

        int damageId = -1;
        String damageTitle = dataFromForm.getParameter("damageTitle");
        String damageDesc = dataFromForm.getParameter("damageDesc");
        int priceForDamageRepair = Integer.parseInt(dataFromForm.getParameter("priceForRepair"));
        int repairListId = repairListServices.getRepairListId(carNumber);

        Damage damage = new Damage(damageId, damageTitle, damageDesc, priceForDamageRepair, repairListId);

        String returnSite = repairListServices.addDamageToRepairList(damage, repairListId);

        return returnSite;
    }

    @GetMapping("/viewRepairlistByCar")
    public String viewRepairLists(Model model, HttpSession session){
        int carNumber = (int) session.getAttribute("carNumber");
        int repairId = (int) session.getAttribute("repairId");
        model.addAttribute("allRepairlists", repairListServices.showCarRepairlist(carNumber));
        model.addAttribute("allDamages", repairListServices.showCarDamages(repairId));
        return "viewPages/viewRepairlistByCar";
    }

    @GetMapping("/viewRepairLists")
    public String viewCarRepairlist(){
        return "viewPages/viewRepairLists";
    }

    @PostMapping("/viewRepairLists")
    public String viewCarRepairlist(WebRequest dataFromForm, HttpSession session){
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));
        int repairId = (repairListServices.getRepairListId(carNumber));

        session.setAttribute("carNumber", carNumber);
        session.setAttribute("repairId", repairId);

        String returnSite = repairListServices.checkIfCarHasRepairlist(carNumber);

        return returnSite;
    }

    @GetMapping("/update-repair")
    public String updateRepairList(){
        return "updatePages/updateRepairList";
    }

    @PostMapping("updateRepairList")
    public String updateRepairList(WebRequest dataFromForm){
        int repairListId = Integer.parseInt(dataFromForm.getParameter("repairID"));
        String repairStart = dataFromForm.getParameter("damagePeriod");
        int carNumber= Integer.parseInt(dataFromForm.getParameter("carNumber"));

        RepairList tempRepairList = new RepairList(repairListId, repairStart, carNumber);

        String returnSite = repairListServices.updateRepairList(tempRepairList);

        return returnSite;
    }

    @GetMapping("/updateRepairListSuccessPage")
    public String updateRepairListSuccessPage(){
        return "successPages/updateRepairListSuccessPage";
    }

    @GetMapping("/deleteRepairList")
    public String deleteRepairList(){
        return "deletePages/deleteRepairList";
    }

    @GetMapping("/deleteRepairListSuccessPage")
        public String deleteRepairListSuccessPage(){
            return "successPages/deleteRepairListSuccessPage";
        }


    @PostMapping("/deleteRepairList")
    public String deleteLeaseContract(WebRequest dataFromForm){
        int repairListId = Integer.parseInt(dataFromForm.getParameter("id"));

        String returnSite = repairListServices.deleteRepairList(repairListId);

        return returnSite;
    }

}
