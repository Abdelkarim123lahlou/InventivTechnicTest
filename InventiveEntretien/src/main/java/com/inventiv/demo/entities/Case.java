package com.inventiv.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "CaseTable")
public class Case {
           @Id
           private Long  caseId;

            private LocalDateTime reationDate;
            private LocalDateTime lastUpdateDate;
           private String title;
           private String description;

}
