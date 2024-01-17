package com.myhospinfos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhospinfos.modal.HospMaster;



public interface HospRepo extends JpaRepository<HospMaster, Long> {
    List<HospMaster> findByHospTransStatusId(String hospTransStatusId);
    List<HospMaster> findByHospId(Long hospId);

}