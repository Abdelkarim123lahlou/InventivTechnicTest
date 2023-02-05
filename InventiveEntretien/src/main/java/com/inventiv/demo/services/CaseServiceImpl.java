package com.inventiv.demo.services;

import com.inventiv.demo.dtos.CaseDtoRequest;
import com.inventiv.demo.dtos.CaseDtoResponse;
import com.inventiv.demo.entities.Case;
import com.inventiv.demo.exceptions.CaseAlreadyExistsException;
import com.inventiv.demo.exceptions.ResourceNotFoundException;
import com.inventiv.demo.mappers.CaseMapper;
import com.inventiv.demo.repositories.CaseRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@Service
public class CaseServiceImpl implements  CaseService {
   private CaseMapper caseMapper;
   private CaseRepository caseRepository;
//Injection des dependances (repository et mapper) par costructeur
    public CaseServiceImpl(CaseMapper caseMapper, CaseRepository caseRepository) {
        this.caseMapper = caseMapper;
        this.caseRepository = caseRepository;
    }

    /***
     *
     * @param id
     * @return le Case de id passé en param
     */
    @Override
    public CaseDtoResponse getCaseById(Long id) {
        Optional<Case> casEntity = caseRepository.findById(id);
        if (!casEntity.isPresent()){
            throw new ResourceNotFoundException("Case not found with id: " + id);
        }
        return caseMapper.caseResponseFromCase(casEntity.get());
    }

    /***
     *
     * @param caseDtoRequest
     * @return l'objet case enregistré
     */
    @Override
    public CaseDtoResponse addCase(CaseDtoRequest caseDtoRequest) {
        try {
            Case savedCase = caseRepository.save(caseMapper.caseFromCaseRequestDto(caseDtoRequest));

            return caseMapper.caseResponseFromCase(savedCase);
        }catch(DataIntegrityViolationException e){
            throw new CaseAlreadyExistsException("A case with the same id already exists.");
        }

    }

    /***
     *
     * @param id
     * @param updatedCase
     * @return un objet case mise a jour suivant les attribut du case passé en param
     */
    @Override
    public CaseDtoResponse updateCase(Long id,CaseDtoRequest updatedCase) {
      Optional<Case> caseToUpdate = caseRepository.findById(id);

      if (!caseToUpdate.isPresent()){
            throw new ResourceNotFoundException("Case not found with id " + id);
        }else {
          caseToUpdate.get().setCaseId(updatedCase.getCaseId());
          caseToUpdate.get().setDescription(updatedCase.getDescription());
          caseToUpdate.get().setTitle(updatedCase.getTitle());
          caseToUpdate.get().setLastUpdateDate(updatedCase.getLastUpdateDate());
          caseToUpdate.get().setReationDate(updatedCase.getReationDate());
      }
        return caseMapper.caseResponseFromCase(caseToUpdate.get());
    }

    /***
     * le service qui supprime le case de l'id passé en param
     * @param id
     */
    @Override
    public void deleteCase(Long id) {
        Optional<Case> caseToUpdate = caseRepository.findById(id);
        if (!caseToUpdate.isPresent()){
            throw new ResourceNotFoundException("Case not found with id: " + id);
        }else {
            caseRepository.delete(caseToUpdate.get());
        }

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
