package com.myhospinfos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhospinfos.modal.HospInfoDtl;



public interface HospInfoDtlRepo extends JpaRepository<HospInfoDtl, Long> {
}
