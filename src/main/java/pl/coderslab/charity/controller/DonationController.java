package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;



@Controller
@RequiredArgsConstructor
@RequestMapping("/form")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @GetMapping
    public String formAction(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("institutionList", institutionRepository.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping
    public String formActionPost (@Valid Donation donation) {
        donationRepository.save(donation);
        return "form-confirmation";
    }

}
