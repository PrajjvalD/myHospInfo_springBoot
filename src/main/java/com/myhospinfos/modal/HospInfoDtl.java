package com.myhospinfos.modal;


import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;

@Entity
public class HospInfoDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospInfoDtlId;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOSP_ID")
    private HospMaster hospMaster;

    @NotBlank(message = "hospName field is null or empty")
    private String hospName;

    private String hospShortName;

    @NotBlank(message = "hospRegisteredNo field is null or empty")
    private String hospRegisteredNo;

    @NotBlank(message = "hospOwnerName field is null or empty")
    private String hospOwnerName;

	public HospInfoDtl(Long hospInfoDtlId, HospMaster hospMaster,
			@NotBlank(message = "hospName field is null or empty") String hospName,
			@NotBlank(message = "hospShortName field is null or empty") String hospShortName,
			@NotBlank(message = "hospRegisteredNo field is null or empty") String hospRegisteredNo,
			@NotBlank(message = "hospOwnerName field is null or empty") String hospOwnerName) {
		super();
		this.hospInfoDtlId = hospInfoDtlId;
		this.hospMaster = hospMaster;
		this.hospName = hospName;
		this.hospShortName = hospShortName;
		this.hospRegisteredNo = hospRegisteredNo;
		this.hospOwnerName = hospOwnerName;
	}

	public HospInfoDtl() {
		super();
	}

	public Long getHospInfoDtlId() {
		return hospInfoDtlId;
	}

	public void setHospInfoDtlId(Long hospInfoDtlId) {
		this.hospInfoDtlId = hospInfoDtlId;
	}

	public HospMaster getHospMaster() {
		return hospMaster;
	}

	public void setHospMaster(HospMaster hospMaster) {
		this.hospMaster = hospMaster;
	}

	public String getHospName() {
		return hospName;
	}

	public void setHospName(String hospName) {
		this.hospName = hospName;
	}

	public String getHospShortName() {
		return hospShortName;
	}

	public void setHospShortName(String hospShortName) {
		this.hospShortName = hospShortName;
	}

	public String getHospRegisteredNo() {
		return hospRegisteredNo;
	}

	public void setHospRegisteredNo(String hospRegisteredNo) {
		this.hospRegisteredNo = hospRegisteredNo;
	}

	public String getHospOwnerName() {
		return hospOwnerName;
	}

	public void setHospOwnerName(String hospOwnerName) {
		this.hospOwnerName = hospOwnerName;
	}

	@Override
	public String toString() {
		return "HospInfoDtl [hospInfoDtlId=" + hospInfoDtlId + ", hospMaster=" + hospMaster + ", hospName=" + hospName
				+ ", hospShortName=" + hospShortName + ", hospRegisteredNo=" + hospRegisteredNo + ", hospOwnerName="
				+ hospOwnerName + "]";
	}

   
}