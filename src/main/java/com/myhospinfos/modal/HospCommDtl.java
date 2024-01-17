package com.myhospinfos.modal;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class HospCommDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospCommunicationId;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOSP_ID", nullable = false)
    @JsonIgnoreProperties("hospCommunicationDtls")
    private HospMaster hospMaster;

    @NotBlank(message = "hospAddress field is null or empty")
    private String hospAddress;

    @NotBlank(message = "hospCity field is null or empty")
    private String hospCity;

    @NotBlank(message = "hospDistrict field is null or empty")
    private String hospDistrict;

    @NotBlank(message = "hospState field is null or empty")
    private String hospState;

    @NotBlank(message = "hospLandMark field is null or empty")
    private String hospLandMark;

    @Size(min = 6, max = 6, message = "Invalid hospPincode: Must be 6 digit")
    @Digits(message="Pincode should be number not character", fraction = 0, integer = 6) 
    private String hospPincode;

    @Digits(message="MobileNo should be number not character", fraction = 0, integer = 10)
    @Size(min = 10, max = 10, message = "Invalid hospPincode: Must be 10 digit")
    private String hospMobileNo;

    @Email(message = "Invalid email")
    private String hospEmailId;

    public HospCommDtl() {
        super();
    }

	public HospCommDtl(Long hospCommunicationId, HospMaster hospMaster,
			@NotBlank(message = "hospAddress field is null or empty") String hospAddress,
			@NotBlank(message = "hospCity field is null or empty") String hospCity,
			@NotBlank(message = "hospDistrict field is null or empty") String hospDistrict,
			@NotBlank(message = "hospState field is null or empty") String hospState,
			@NotBlank(message = "hospLandMark field is null or empty") String hospLandMark,
			@Digits(message = "Number should contain 10 digits.", fraction = 0, integer = 6) String hospPincode,
			@NotBlank(message = "hospMobileNo field is null or empty") @Digits(message = "Number should contain 10 digits.", fraction = 0, integer = 10) String hospMobileNo,
			@Email(message = "Invalid email") String hospEmailId) {
		super();
		this.hospCommunicationId = hospCommunicationId;
		this.hospMaster = hospMaster;
		this.hospAddress = hospAddress;
		this.hospCity = hospCity;
		this.hospDistrict = hospDistrict;
		this.hospState = hospState;
		this.hospLandMark = hospLandMark;
		this.hospPincode = hospPincode;
		this.hospMobileNo = hospMobileNo;
		this.hospEmailId = hospEmailId;
	}

	public Long getHospCommunicationId() {
		return hospCommunicationId;
	}

	public void setHospCommunicationId(Long hospCommunicationId) {
		this.hospCommunicationId = hospCommunicationId;
	}

	public HospMaster getHospMaster() {
		return hospMaster;
	}

	public void setHospMaster(HospMaster hospMaster) {
		this.hospMaster = hospMaster;
	}

	public String getHospAddress() {
		return hospAddress;
	}

	public void setHospAddress(String hospAddress) {
		this.hospAddress = hospAddress;
	}

	public String getHospCity() {
		return hospCity;
	}

	public void setHospCity(String hospCity) {
		this.hospCity = hospCity;
	}

	public String getHospDistrict() {
		return hospDistrict;
	}

	public void setHospDistrict(String hospDistrict) {
		this.hospDistrict = hospDistrict;
	}

	public String getHospState() {
		return hospState;
	}

	public void setHospState(String hospState) {
		this.hospState = hospState;
	}

	public String getHospLandMark() {
		return hospLandMark;
	}

	public void setHospLandMark(String hospLandMark) {
		this.hospLandMark = hospLandMark;
	}

	public String getHospPincode() {
		return hospPincode;
	}

	public void setHospPincode(String hospPincode) {
		this.hospPincode = hospPincode;
	}

	public String getHospMobileNo() {
		return hospMobileNo;
	}

	public void setHospMobileNo(String hospMobileNo) {
		this.hospMobileNo = hospMobileNo;
	}

	public String getHospEmailId() {
		return hospEmailId;
	}

	public void setHospEmailId(String hospEmailId) {
		this.hospEmailId = hospEmailId;
	}

	@Override
	public String toString() {
		return "HospCommDtl [hospCommunicationId=" + hospCommunicationId + ", hospMaster=" + hospMaster
				+ ", hospAddress=" + hospAddress + ", hospCity=" + hospCity + ", hospDistrict=" + hospDistrict
				+ ", hospState=" + hospState + ", hospLandMark=" + hospLandMark + ", hospPincode=" + hospPincode
				+ ", hospMobileNo=" + hospMobileNo + ", hospEmailId=" + hospEmailId + "]";
	}

	
   
}
