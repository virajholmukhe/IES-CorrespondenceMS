package com.ies.CorrespondenceMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class CorrespondenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
