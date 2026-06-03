package com.bbanas.genochronica.family;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyService familyService;

    @GetMapping("/tree")
    public Family getFamilyTree() {
        return familyService.getFamilyTree();
    }
    

}