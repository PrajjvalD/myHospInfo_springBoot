package com.myhospinfos.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhospinfos.exception.HospInfoException;
import com.myhospinfos.modal.HospCommDtl;
import com.myhospinfos.modal.HospInfoDtl;
import com.myhospinfos.modal.HospMaster;
import com.myhospinfos.repo.HospRepo;
import com.myhospinfos.service.HospService;

@Service
public class HospServiceImpl implements HospService {

    private static final Logger log = LoggerFactory.getLogger(HospServiceImpl.class);

    @Autowired
    private HospRepo hospRepo;

    @Override
    public HospMaster saveHospMaster(HospMaster hospMaster) {
        try {
            log.info("Saving hospital master: {}", hospMaster);
            return hospRepo.save(hospMaster);
        } catch (Exception e) {
            log.error("Error saving hospital master: {}", e.getMessage(), e);
            throw new HospInfoException("Error saving hospital master: " + e.getMessage(), e);
        }
    }

    @Override
    public List<HospMaster> getHospMasterByStatus(String status) {
        try {
            log.info("Fetching hospital masters by status: {}", status);
            return hospRepo.findByHospTransStatusId(status);
        } catch (Exception e) {
            log.error("Error fetching hospital masters by status: {}", e.getMessage(), e);
            throw new HospInfoException("Error fetching hospital masters by status: " + e.getMessage(), e);
        }
    }

    @Override
    public List<HospMaster> getHospMasterById(Long hospId) {
        try {
            log.info("Fetching hospital masters by ID: {}", hospId);
            return hospRepo.findByHospId(hospId);
        } catch (Exception e) {
            log.error("Error fetching hospital masters by ID: {}", e.getMessage(), e);
            throw new HospInfoException("Error fetching hospital masters by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<HospMaster> getAllHospMasters() {
        try {
            log.info("Fetching all hospital masters");
            return hospRepo.findAll();
        } catch (Exception e) {
            log.error("Error fetching all hospital masters: {}", e.getMessage(), e);
            throw new HospInfoException("Error fetching all hospital masters: " + e.getMessage(), e);
        }
    }

    @Override
    public String updateHospMaster(Long hospId, HospMaster updatedHospMaster) {
        try {
            log.info("Updating hospital master with ID: {}", hospId);
            Optional<HospMaster> optionalHospitalMaster = hospRepo.findById(hospId);
            if (optionalHospitalMaster.isPresent()) {
                HospMaster hospitalMaster = optionalHospitalMaster.get();
                // Update existing HospMaster entity with the data from updatedHospMaster
                hospitalMaster.setHospTransStatusId(updatedHospMaster.getHospTransStatusId());
                hospitalMaster.setRecordStatus(updatedHospMaster.getRecordStatus());
                hospitalMaster.setModifiedDate(updatedHospMaster.getModifiedDate());
                hospitalMaster.setModifiedBy(updatedHospMaster.getModifiedBy());

                // Update existing HospInfoDtl
                HospInfoDtl updatedInfoDtl = updatedHospMaster.getHospInfoDtls();
                HospInfoDtl infoDetail = hospitalMaster.getHospInfoDtls();
                infoDetail.setHospName(updatedInfoDtl.getHospName());
                infoDetail.setHospShortName(updatedInfoDtl.getHospShortName());
                infoDetail.setHospRegisteredNo(updatedInfoDtl.getHospRegisteredNo());
                infoDetail.setHospOwnerName(updatedInfoDtl.getHospOwnerName());

                // Update existing HospCommDtl
                HospCommDtl updatedCommDtl = updatedHospMaster.getHospCommunicationDtls();
                HospCommDtl communicationDetail = hospitalMaster.getHospCommunicationDtls();
                communicationDetail.setHospAddress(updatedCommDtl.getHospAddress());
                communicationDetail.setHospCity(updatedCommDtl.getHospCity());
                communicationDetail.setHospDistrict(updatedCommDtl.getHospDistrict());
                communicationDetail.setHospEmailId(updatedCommDtl.getHospEmailId());
                communicationDetail.setHospLandMark(updatedCommDtl.getHospLandMark());
                communicationDetail.setHospMobileNo(updatedCommDtl.getHospMobileNo());
                communicationDetail.setHospPincode(updatedCommDtl.getHospPincode());
                communicationDetail.setHospState(updatedCommDtl.getHospState());

                // Save the updated HospMaster entity
                hospRepo.save(hospitalMaster);
                log.info("Hospital master updated successfully: {}", hospitalMaster);
                return "Hospital details updated successfully.";
            } else {
                log.warn("No Data Found with HospId: {}", hospId);
                return "No Data Found with HospId: " + hospId;
            }
        } catch (Exception e) {
            log.error("Error updating hospital master: {}", e.getMessage(), e);
            throw new HospInfoException("Error updating hospital master: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteHospMaster(Long hospId) {
        try {
            log.info("Deleting hospital master with ID: {}", hospId);
            if (hospRepo.existsById(hospId)) {
                hospRepo.deleteById(hospId);
                log.info("Hospital master deleted successfully with ID: {}", hospId);
            } else {
                log.warn("No Data Found with HospId: {}", hospId);
                throw new HospInfoException("No Data Found with HospId: " + hospId);
            }
        } catch (Exception e) {
            log.error("Error deleting hospital master: {}", e.getMessage(), e);
            throw new HospInfoException("Error deleting hospital master: " + e.getMessage(), e);
        }
    }
}
