package com.ies.CorrespondenceMS.service;

import com.ies.CorrespondenceMS.DTO.CorrespondenceInfoDTO;
import com.ies.CorrespondenceMS.DTO.EligibilityDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CorrespondenceService {

    public void generateCorrespondence(EligibilityDetailsDTO eligibilityDetailsDTO);
    public List<CorrespondenceInfoDTO> getCorrespondenceInfo(Integer caseNumber, String status);
    public boolean printNotices(Integer noticeId);
}
