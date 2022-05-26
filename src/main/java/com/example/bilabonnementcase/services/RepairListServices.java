package com.example.bilabonnementcase.services;

import com.example.bilabonnementcase.models.Damage;
import com.example.bilabonnementcase.models.RepairList;
import com.example.bilabonnementcase.repositories.IRepository;
import com.example.bilabonnementcase.repositories.RepairListRepository;

//Author: Güler, Chris
public class RepairListServices {

    private final RepairListRepository repairListRepository = new RepairListRepository();
    private final IRepository<RepairList> repository;

    public RepairListServices(IRepository<RepairList> repairListRepository) {
        this.repository = repairListRepository;
    }

    public String createRepairList(RepairList repairList){

        if(repository.create(repairList) == true){
            return "redirect:/add-damage";
        }
        return "redirect:/error-page";
    }

    public String goToCreateRepairList(int carNumber){
        boolean goOn = isCarReady(carNumber);
        String returnSite = "";

        if(goOn == true){
            returnSite = "redirect:/create-repairlist";
        } else {
            returnSite = "redirect:/car-not-ready";
        }

        return returnSite;
    }

    public boolean isCarReady(int carNumber){

        boolean leasePeriodOver = repairListRepository.isLeasePeriodOver(carNumber);

        if(leasePeriodOver == true){
            repairListRepository.updateLeasePeriodStatus(leasePeriodOver, carNumber);
        }

        if (repairListRepository.isCarRented(carNumber) == true){
            return true;
        }

        return false;
    }

    public String addDamageToRepairList(Damage damage, int repairListId){

        if(repairListRepository.createDamage(damage, repairListId) == true){
            return "redirect:/createRepairListSuccessPage";
        }
        return "redirect:/error-page";
    }

    public int getRepairListId(int carNumber){
        return repairListRepository.getRepairListIdFromCarNumber(carNumber);
    }

    public RepairList showCarRepairlist(int carNumber){
        return repairListRepository.getRepairlistFromCar(carNumber);
    }

    public String checkIfCarHasRepairlist(int carNumber){
        if(repairListRepository.getRepairlistFromCar(carNumber) == null){
            return "redirect:/error-page";
        }
        return "redirect:/viewRepairlistByCar";
    }

    public Damage showCarDamages(int repairId){
        return repairListRepository.getDamagesFromCar(repairId);
    }

    public String updateRepairList(RepairList repairList){

        if(repository.update(repairList) == true){
            return "redirect:/updateRepairListSuccessPage";
        }
        return "redirect:/error-page";
    }

    public String deleteRepairList(int repairListId){

        if(repository.delete(repairListId) == true){
            return "redirect:/deleteRepairListSuccessPage";
        }
        return "redirect:/error-page";
    }

}
