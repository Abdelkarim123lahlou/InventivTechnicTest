package com.inventiv.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CaseDtoRequest {


    private Long  caseId;

    private LocalDateTime reationDate;
    private LocalDateTime lastUpdateDate;
    private String title;
    private String description;

}
