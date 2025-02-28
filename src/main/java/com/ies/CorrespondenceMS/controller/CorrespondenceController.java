package com.ies.CorrespondenceMS.controller;

import com.ies.CorrespondenceMS.DTO.CorrespondenceInfoDTO;
import com.ies.CorrespondenceMS.DTO.EligibilityDetailsDTO;
import com.ies.CorrespondenceMS.service.CorrespondenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/correspondence")
public class CorrespondenceController {

    @Autowired
    private CorrespondenceService correspondenceService;

    @GetMapping(value = "/generate-correspondence")
    public void generateCorrespondence(@RequestBody EligibilityDetailsDTO eligibilityDetailsDTO) {
        correspondenceService.generateCorrespondence(eligibilityDetailsDTO);
    }

    @PostMapping(value = "/get-correspondence-info")
    public ResponseEntity<List<CorrespondenceInfoDTO>> getCorrespondenceInfo(@RequestParam Integer caseNumber, @RequestParam String status) {
        return new ResponseEntity<>(correspondenceService.getCorrespondenceInfo(caseNumber, status), HttpStatus.OK);
    }

    @PostMapping(value = "/print-notices")
    public ResponseEntity<Boolean> printNotices(@RequestParam Integer noticeId) {
        return new ResponseEntity<>(correspondenceService.printNotices(noticeId), HttpStatus.OK);
    }
}
