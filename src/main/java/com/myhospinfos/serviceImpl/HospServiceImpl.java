package com.myhospinfos.serviceImpl;


import java.util.List;
import java.util.Optional;

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


	@Autowired
	private HospRepo hospRepo;
	
	@Override
	public HospMaster saveHospMaster(HospMaster hospMaster) { 
	    return hospRepo.save(hospMaster);
	}

	
	@Override
	public List<HospMaster> getHospMasterByStatus(String status) {
	    List<HospMaster> hospMasters = hospRepo.findByHospTransStatusId(status);
	    return hospMasters;
	}
	
	@Override
	public List<HospMaster>  getHospMasterById(Long HospId) {
		List<HospMaster> hospMasters = hospRepo.findByHospId(HospId);
	    return hospMasters;
	}
	
	@Override
	public List<HospMaster> getAllHospMasters() {
	    List<HospMaster> hospMasters = hospRepo.findAll();
	    return hospMasters;
	}

	@Override
	public String updateHospMaster(Long hospId, HospMaster updatedHospMaster) {
	    Optional<HospMaster> optionalHospitalMaster = hospRepo.findById(hospId);
	    if (optionalHospitalMaster.isPresent()) {
	        HospMaster hospitalMaster = optionalHospitalMaster.get();
	        // Update existing HospMaster entity with the data from updatedHospMaster
	        hospitalMaster.setHospTransStatusId(updatedHospMaster.getHospTransStatusId());
	        hospitalMaster.setRecordStatus(updatedHospMaster.getRecordStatus());
//	        hospitalMaster.setCreatedBy(updatedHospMaster.getCreatedBy());
//	        hospitalMaster.setCreatedDate(updatedHospMaster.getCreatedDate());
	        hospitalMaster.setModifiedDate(updatedHospMaster.getModifiedDate());
	        hospitalMaster.setModifiedBy(updatedHospMaster.getModifiedBy());

	        // Assuming you want to update the first HospInfoDtl and HospCommDtl
	        HospInfoDtl updatedInfoDtl = updatedHospMaster.getHospInfoDtls();
	        HospCommDtl updatedCommDtl = updatedHospMaster.getHospCommunicationDtls();

	        // Update existing HospInfoDtl
	        HospInfoDtl infoDetail = hospitalMaster.getHospInfoDtls();
	        infoDetail.setHospName(updatedInfoDtl.getHospName());
	        infoDetail.setHospShortName(updatedInfoDtl.getHospShortName());
	        infoDetail.setHospRegisteredNo(updatedInfoDtl.getHospRegisteredNo());
	        infoDetail.setHospOwnerName(updatedInfoDtl.getHospOwnerName());

	        // Update existing HospCommDtl
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
	    } else {
	        return "No Data Found with HospId: "+hospId;
	    }
        return "Hospital details updated successfully.";
	}

	
    @Override
    public void deleteHospMaster(Long hospId) {
        if (hospRepo.existsById(hospId)) {
            hospRepo.deleteById(hospId);
        } else {
            throw new HospInfoException("No Data Found with HospId: " + hospId);
        }
    }

}