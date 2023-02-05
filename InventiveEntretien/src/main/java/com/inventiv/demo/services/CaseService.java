package com.inventiv.demo.services;

import com.inventiv.demo.dtos.CaseDtoRequest;
import com.inventiv.demo.dtos.CaseDtoResponse;

public interface CaseService {
    public CaseDtoResponse getCaseById(Long id);
    public CaseDtoResponse addCase(CaseDtoRequest caseDtoRequest);
    public CaseDtoResponse updateCase(Long id,CaseDtoRequest updatedCase);
    public void  deleteCase(Long id);
}
