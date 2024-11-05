package com.myhospinfos.modal;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "hospId")
@Entity
public class HospMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hospId;

	@Valid
	@OneToOne(mappedBy = "hospMaster", cascade = CascadeType.ALL)
	private HospInfoDtl hospInfoDtls;

	@Valid
	@OneToOne(mappedBy = "hospMaster", cascade = CascadeType.ALL)
	private HospCommDtl hospCommunicationDtls ;

//    @NotBlank(message = "hospCode field is null or empty")
	private String hospCode;

    @NotBlank(message = "recordStatus field is null or empty")
	private String recordStatus;

	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	private String modifiedBy;

    @NotBlank(message = "hospTransStatusId field is null or empty")
	private String hospTransStatusId;

	public HospMaster() {
		super();
	}

	public HospMaster(Long hospId, @Valid HospInfoDtl hospInfoDtls, @Valid HospCommDtl hospCommunicationDtls,
			String hospCode, @NotBlank(message = "recordStatus field is null or empty") String recordStatus,
			@NotBlank(message = "createdBy field is null or empty") String createdBy, Date createdDate,
			Date modifiedDate, @NotBlank(message = "modifiedBy field is null or empty") String modifiedBy,
			@NotBlank(message = "hospTransStatusId field is null or empty") String hospTransStatusId) {
		super();
		this.hospId = hospId;
		this.hospInfoDtls = hospInfoDtls;
		this.hospCommunicationDtls = hospCommunicationDtls;
		this.hospCode = hospCode;
		this.recordStatus = recordStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.hospTransStatusId = hospTransStatusId;
	}

	public Long getHospId() {
		return hospId;
	}

	public void setHospId(Long hospId) {
		this.hospId = hospId;
	}

	public HospInfoDtl getHospInfoDtls() {
		return hospInfoDtls;
	}

	public void setHospInfoDtls(HospInfoDtl hospInfoDtls) {
		this.hospInfoDtls = hospInfoDtls;
	}

	public HospCommDtl getHospCommunicationDtls() {
		return hospCommunicationDtls;
	}

	public void setHospCommunicationDtls(HospCommDtl hospCommunicationDtls) {
		this.hospCommunicationDtls = hospCommunicationDtls;
	}

	public String getHospCode() {
		return hospCode;
	}

	public void setHospCode(String hospCode) {
		this.hospCode = hospCode;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getHospTransStatusId() {
		return hospTransStatusId;
	}

	public void setHospTransStatusId(String hospTransStatusId) {
		this.hospTransStatusId = hospTransStatusId;
	}

	@Override
	public String toString() {
		return "HospMaster [hospId=" + hospId + ", hospInfoDtls=" + hospInfoDtls + ", hospCommunicationDtls="
				+ hospCommunicationDtls + ", hospCode=" + hospCode + ", recordStatus=" + recordStatus + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", modifiedBy="
				+ modifiedBy + ", hospTransStatusId=" + hospTransStatusId + "]";
	}

	
	
}