package com.ies.CorrespondenceMS.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EligibilityDetailsDTO {

    private Integer id;
    private String planStatus;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private Double benefitAmount;
    private String denialReason;
    private Integer caseNumber;
    private String planName;
}
