package com.ies.CorrespondenceMS.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CorrespondenceInfoDTO {

    private Integer id;

    private String planName;
    private String planStatus;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
    private Double benefitAmount;
    private String denialReason;

    private String noticeStatus;
    private String noticeGenerationDate;
    private String noticeS3Url;
    private Integer caseNumber;
}
