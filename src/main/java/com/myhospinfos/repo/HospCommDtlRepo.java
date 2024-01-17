package com.myhospinfos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhospinfos.modal.HospCommDtl;

public interface HospCommDtlRepo extends JpaRepository<HospCommDtl, Long> {
}