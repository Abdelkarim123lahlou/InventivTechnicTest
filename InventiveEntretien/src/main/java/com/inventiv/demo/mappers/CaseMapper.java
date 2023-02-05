package com.inventiv.demo.mappers;

import com.inventiv.demo.dtos.CaseDtoRequest;
import com.inventiv.demo.dtos.CaseDtoResponse;
import com.inventiv.demo.entities.Case;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CaseMapper {
    Case caseFromCaseRequestDto(CaseDtoRequest caseDtoRequest);
    CaseDtoResponse caseResponseFromCase(Case casEntiti);
}
