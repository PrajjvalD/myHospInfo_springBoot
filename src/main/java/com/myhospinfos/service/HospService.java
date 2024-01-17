package com.myhospinfos.service;


import java.util.List;

import com.myhospinfos.modal.HospMaster;


public interface HospService {
	
	HospMaster saveHospMaster(HospMaster hospMaster);

    List<HospMaster> getAllHospMasters();
    
	List<HospMaster> getHospMasterByStatus(String status);
	
	List<HospMaster> getHospMasterById(Long HospId);

    String updateHospMaster(Long hospId, HospMaster updatedHospMaster);

    void deleteHospMaster(Long hospId);
    
}
