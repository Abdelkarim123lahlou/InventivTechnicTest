package com.inventiv.demo.web;

import com.inventiv.demo.dtos.CaseDtoRequest;
import com.inventiv.demo.dtos.CaseDtoResponse;
import com.inventiv.demo.services.CaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/cases")
public class CaseContreoller {
    private CaseService caseService;
// injection de la depandence service par constructeur
    public CaseContreoller(CaseService caseService) {
        this.caseService = caseService;
    }
    @GetMapping("/{id}")
    public CaseDtoResponse getCaseById(@PathVariable Long id){
       return caseService.getCaseById(id);
    }
    @PostMapping
    public CaseDtoResponse createCase(@RequestBody CaseDtoRequest caseData) {
        return caseService.addCase(caseData);
    }
    @PutMapping("/{id}")
    public CaseDtoResponse updateCase (@PathVariable Long caseId, @RequestBody CaseDtoRequest caseData){
        return caseService.updateCase(caseId,caseData);
    }
    @DeleteMapping("/{id}")
    public  void deleteCase (@PathVariable Long id){
        caseService.deleteCase(id);
    }
}
