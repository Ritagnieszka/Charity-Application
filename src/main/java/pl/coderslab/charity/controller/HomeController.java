package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @ModelAttribute
    public List<Institution> institutions() {
        return institutionRepository.findAll();
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("numberOfBags", donationRepository.quantityOfAllBags());
        model.addAttribute("numberOfDonations", donationRepository.quantityOfAllDonations());
        return "index";
    }
}
