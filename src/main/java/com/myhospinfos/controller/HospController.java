package com.myhospinfos.controller;

import org.slf4j.Logger;
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


import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hosp")
@CrossOrigin("http://localhost:4200")
@Validated
public class HospController {
	
    private static final Logger log = LoggerFactory.getLogger(HospController.class);
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
            
            String successMessage = "Hospital created successfully with HospCode: " + hospMaster.getHospCode();
            ApiResponse<String> response = new ApiResponse<>();
            response.setStatus(HttpStatus.CREATED.value());
            response.setData(successMessage);

            log.info("Hospital created successfully with HospCode: {}", hospMaster.getHospCode());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            log.error("Error creating hospital: {}", e.getLocalizedMessage());
            ApiResponse<String> response = new ApiResponse<>();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError("An error occurred while creating the hospital.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<HospMaster>> getAllHospMasters() {
        try {
            List<HospMaster> hospMasters = hospMasterService.getAllHospMasters();
            log.info("getAllHospMasters:: Retrieved data successfully");
            return ResponseEntity.ok().body(hospMasters);
        } catch (Exception e) {
            log.error("Error fetching all hospitals: {}", e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Collections.emptyList());
        }
    }

    @GetMapping(path = "/search/{status}")
    public ResponseEntity<List<HospMaster>> getHospMasterByStatus(@PathVariable String status) {
        try {
            List<HospMaster> hospMasters = hospMasterService.getHospMasterByStatus(status);
            log.info("getHospMasterByStatus:: Retrieved hospitals with status {}", status);
            return ResponseEntity.ok().body(hospMasters);
        } catch (Exception e) {
            log.error("Error fetching hospitals by status {}: {}", status, e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Collections.emptyList());
        }
    }

    @GetMapping(path = "/{HospId}")
    public ResponseEntity<List<HospMaster>> getHospMasterById(@PathVariable Long HospId) {
        try {
            List<HospMaster> hospMasters = hospMasterService.getHospMasterById(HospId);
            log.info("getHospMasterById:: Retrieved hospital with ID {}", HospId);
            return ResponseEntity.ok().body(hospMasters);
        } catch (Exception e) {
            log.error("Error fetching hospital by ID {}: {}", HospId, e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Collections.emptyList());
        }
    }

    @PutMapping(value = "/update/{hospId}", consumes = "application/json")
    public ResponseEntity<String> updateHospMaster(@PathVariable Long hospId, @Valid @RequestBody HospMaster hospMaster) {
        try {
            String response = hospMasterService.updateHospMaster(hospId, hospMaster);
            log.info("updateHospMaster:: Updated hospital with ID {}", hospId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error updating hospital with ID {}: {}", hospId, e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred while updating the hospital.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteHospMaster(@PathVariable Long id) {
        try {
            hospMasterService.deleteHospMaster(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Data Deleted with HospId: " + id);
            log.info("deleteHospMaster:: Deleted hospital with ID {}", id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error deleting hospital with ID {}: {}", id, e.getLocalizedMessage());
            Map<String, String> response = new HashMap<>();
            response.put("error", "An error occurred while deleting the hospital.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
