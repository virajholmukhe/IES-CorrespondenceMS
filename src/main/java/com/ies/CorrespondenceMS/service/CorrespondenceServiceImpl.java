package com.ies.CorrespondenceMS.service;

import com.ies.CorrespondenceMS.DTO.CorrespondenceInfoDTO;
import com.ies.CorrespondenceMS.DTO.EligibilityDetailsDTO;
import com.ies.CorrespondenceMS.entity.CorrespondenceEntity;
import com.ies.CorrespondenceMS.repository.CorrespondenceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorrespondenceServiceImpl implements CorrespondenceService{

    @Autowired
    private CorrespondenceRepository correspondenceRepository;

    public void generateCorrespondence(EligibilityDetailsDTO eligibilityDetailsDTO) {
        CorrespondenceEntity correspondenceEntity = new CorrespondenceEntity();
        correspondenceEntity.setCaseNumber(eligibilityDetailsDTO.getCaseNumber());
        correspondenceEntity.setPlanName(eligibilityDetailsDTO.getPlanName());
        correspondenceEntity.setPlanStatus(eligibilityDetailsDTO.getPlanStatus());
        correspondenceEntity.setPlanStartDate(eligibilityDetailsDTO.getPlanStartDate());
        correspondenceEntity.setPlanEndDate(eligibilityDetailsDTO.getPlanEndDate());
        correspondenceEntity.setBenefitAmount(eligibilityDetailsDTO.getBenefitAmount());
        correspondenceEntity.setDenialReason(eligibilityDetailsDTO.getDenialReason());
        correspondenceEntity.setNoticeStatus("PENDING");
        correspondenceRepository.save(correspondenceEntity);
    }

    @Override
    public List<CorrespondenceInfoDTO> getCorrespondenceInfo(Integer caseNumber, String status) {
        CorrespondenceEntity correspondenceEntity = new CorrespondenceEntity();
        correspondenceEntity.setCaseNumber(caseNumber);
        correspondenceEntity.setNoticeStatus(status);
        Example<CorrespondenceEntity> example = Example.of(correspondenceEntity);
        List<CorrespondenceEntity> correspondenceEntities = correspondenceRepository.findAll(example);
        if(correspondenceEntities.isEmpty()){
            return List.of();
        }else{
            List<CorrespondenceInfoDTO> correspondenceInfoDTOList = new ArrayList<>();
            for(CorrespondenceEntity entity : correspondenceEntities){
                CorrespondenceInfoDTO correspondenceInfoDTO = new CorrespondenceInfoDTO();
                BeanUtils.copyProperties(entity, correspondenceInfoDTO);
                correspondenceInfoDTOList.add(correspondenceInfoDTO);
            }
            return correspondenceInfoDTOList;
        }
    }

    @Override
    public boolean printNotices(Integer noticeId) {
        //generate notice(pdf)
        //upload to S3 bucket
        //update notice URL in DB
        //send notice in email as attachment
        return false;
    }
}
