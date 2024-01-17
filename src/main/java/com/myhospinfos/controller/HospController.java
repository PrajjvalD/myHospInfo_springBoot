package com.myhospinfos.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.myhospinfos.modal.HospMaster;
import com.myhospinfos.service.HospService;
import com.myhospinfos.shared.ApiResponse;
import com.myhospinfos.shared.HospCodeGenerator;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hosp")
@CrossOrigin("http://localhost:4200")
@Validated
public class HospController {
	
	 static final org.slf4j.Logger log = 
		        LoggerFactory.getLogger(HospController.class);

    private final HospService hospMasterService;

    @Autowired
    public HospController(HospService hospMasterService) {
        this.hospMasterService = hospMasterService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> saveHospMaster(@Valid @RequestBody HospMaster hospMaster) {
        try {
            hospMaster.setCreatedBy("Admin");
            hospMaster.setCreatedDate(new Date());
            hospMaster.setModifiedDate(new Date());
            hospMaster.setModifiedBy("Admin");
            hospMaster.setHospCode(HospCodeGenerator.generateHospCode());
            hospMaster.getHospInfoDtls().setHospMaster(hospMaster);
            hospMaster.getHospCommunicationDtls().setHospMaster(hospMaster);       
            hospMasterService.saveHospMaster(hospMaster);            
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            // You might want to return an error response here
        }

        String successMessage = "Hospital created successfully with HospCode: " + hospMaster.getHospCode();
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(HttpStatus.CREATED.value());
        response.setData(successMessage);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<HospMaster>> getAllHospMasters() {
        return ResponseEntity.ok().body(hospMasterService.getAllHospMasters());
    }

    @GetMapping(path = "/search/{status}")
    public ResponseEntity<List<HospMaster>> getHospMasterByStatus(@PathVariable String status) {
        return ResponseEntity.ok().body(hospMasterService.getHospMasterByStatus(status));
    }
    
    @GetMapping(path = "/{HospId}")
    public ResponseEntity<List<HospMaster>> getHospMasterById(@PathVariable Long HospId) {
        return ResponseEntity.ok().body(hospMasterService.getHospMasterById(HospId));
    }

    @PutMapping(value = "/update/{hospId}", consumes = "application/json")
    public ResponseEntity<String> updateHospMaster( @PathVariable Long hospId,@Valid @RequestBody HospMaster hospMaster) {
    	String response = hospMasterService.updateHospMaster(hospId, hospMaster);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteHospMaster(@PathVariable Long id) {
        hospMasterService.deleteHospMaster(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Data Deleted with HospId: " + id);
        return ResponseEntity.ok(response);
    }

    
}


