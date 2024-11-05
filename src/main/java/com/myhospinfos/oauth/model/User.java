package com.myhospinfos.oauth.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "D_USER_HDR_TST")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "LOGIN_ID")
	private String userName;

	@Column(name = "AUTH_CODE")
	private String password;

	@Column(name = "SYSTEM_DATA")
	private String system_data;

	@Column(name = "USER_TYPE")
	private Long user_type;

	@Column(name = "EMAIL_ID")
	private String email_id;

	@Column(name = "ROLE_ID")
	private Long role_id;

	@Column(name = "ACTIVE_STATUS")
	private Long active_status;

	@Column(name = "CREATED_BY")
	private Long created_by;

	@Column(name = "CREATED_ON")
	private Date created_on;

	@Column(name = "UPDATE_BY")
	private Long updated_by;

	@Column(name = "UPDATE_ON")
	private Date updated_on;

	@Column(name = "VERSION_NO")
	private Long version_no;

	@Column(name = "IMAGE_PATH")
	private String image_path;

	@Column(name = "LAST_LOGIN")
	private Date last_login;

	@Column(name = "MAIL_SENT_TIME")
	private Date mail_sent_time;

	@Column(name = "NO_OF_ATTEMPT")
	private int no_of_attempt;

	@Column(name = "AUTH_CODE1")
	private String auth_code1;

	@Column(name = "AUTH_CODE2")
	private String auth_code2;

	@Column(name = "OTP")
	private String otp;

	@Column(name = "MOBILE_NUMBER")
	private Long mobile_number;

	@Column(name = "AUTH_KEY")
	private String auth_key;

	public User() {
		super();
	}

	public User(User user) {
		super();
		this.userId = user.userId;
		this.userName = user.userName;
		this.password = user.password;
		this.system_data = user.system_data;
		this.user_type = user.user_type;
		this.email_id = user.email_id;
		this.role_id = user.role_id;
		this.active_status = user.active_status;
		this.created_by = user.created_by;
		this.created_on = user.created_on;
		this.updated_by = user.updated_by;
		this.updated_on = user.updated_on;
		this.version_no = user.version_no;
		this.image_path = user.image_path;
		this.last_login = user.last_login;
		this.mail_sent_time = user.mail_sent_time;
		this.no_of_attempt = user.no_of_attempt;
		this.auth_code1 = user.auth_code1;
		this.auth_code2 = user.auth_code2;
		this.otp = user.otp;
		this.mobile_number = user.mobile_number;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSystem_data() {
		return system_data;
	}

	public void setSystem_data(String system_data) {
		this.system_data = system_data;
	}

	public Long getUser_type() {
		return user_type;
	}

	public void setUser_type(Long user_type) {
		this.user_type = user_type;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public Long getActive_status() {
		return active_status;
	}

	public void setActive_status(Long active_status) {
		this.active_status = active_status;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Long getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Long updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public Long getVersion_no() {
		return version_no;
	}

	public void setVersion_no(Long version_no) {
		this.version_no = version_no;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public Date getMail_sent_time() {
		return mail_sent_time;
	}

	public void setMail_sent_time(Date mail_sent_time) {
		this.mail_sent_time = mail_sent_time;
	}

	public int getNo_of_attempt() {
		return no_of_attempt;
	}

	public void setNo_of_attempt(int no_of_attempt) {
		this.no_of_attempt = no_of_attempt;
	}

	public String getAuth_code1() {
		return auth_code1;
	}

	public void setAuth_code1(String auth_code1) {
		this.auth_code1 = auth_code1;
	}

	public String getAuth_code2() {
		return auth_code2;
	}

	public void setAuth_code2(String auth_code2) {
		this.auth_code2 = auth_code2;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active_status == null) ? 0 : active_status.hashCode());
		result = prime * result + ((auth_code1 == null) ? 0 : auth_code1.hashCode());
		result = prime * result + ((auth_code2 == null) ? 0 : auth_code2.hashCode());
		result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result + ((created_on == null) ? 0 : created_on.hashCode());
		result = prime * result + ((email_id == null) ? 0 : email_id.hashCode());
		result = prime * result + ((image_path == null) ? 0 : image_path.hashCode());
		result = prime * result + ((last_login == null) ? 0 : last_login.hashCode());
		result = prime * result + ((mail_sent_time == null) ? 0 : mail_sent_time.hashCode());
		result = prime * result + ((mobile_number == null) ? 0 : mobile_number.hashCode());
		result = prime * result + no_of_attempt;
		result = prime * result + ((otp == null) ? 0 : otp.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
		result = prime * result + ((system_data == null) ? 0 : system_data.hashCode());
		result = prime * result + ((updated_by == null) ? 0 : updated_by.hashCode());
		result = prime * result + ((updated_on == null) ? 0 : updated_on.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((user_type == null) ? 0 : user_type.hashCode());
		result = prime * result + ((version_no == null) ? 0 : version_no.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (active_status == null) {
			if (other.active_status != null)
				return false;
		} else if (!active_status.equals(other.active_status))
			return false;
		if (auth_code1 == null) {
			if (other.auth_code1 != null)
				return false;
		} else if (!auth_code1.equals(other.auth_code1))
			return false;
		if (auth_code2 == null) {
			if (other.auth_code2 != null)
				return false;
		} else if (!auth_code2.equals(other.auth_code2))
			return false;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		if (created_on == null) {
			if (other.created_on != null)
				return false;
		} else if (!created_on.equals(other.created_on))
			return false;
		if (email_id == null) {
			if (other.email_id != null)
				return false;
		} else if (!email_id.equals(other.email_id))
			return false;
		if (image_path == null) {
			if (other.image_path != null)
				return false;
		} else if (!image_path.equals(other.image_path))
			return false;
		if (last_login == null) {
			if (other.last_login != null)
				return false;
		} else if (!last_login.equals(other.last_login))
			return false;
		if (mail_sent_time == null) {
			if (other.mail_sent_time != null)
				return false;
		} else if (!mail_sent_time.equals(other.mail_sent_time))
			return false;
		if (mobile_number == null) {
			if (other.mobile_number != null)
				return false;
		} else if (!mobile_number.equals(other.mobile_number))
			return false;
		if (no_of_attempt != other.no_of_attempt)
			return false;
		if (otp == null) {
			if (other.otp != null)
				return false;
		} else if (!otp.equals(other.otp))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		if (system_data == null) {
			if (other.system_data != null)
				return false;
		} else if (!system_data.equals(other.system_data))
			return false;
		if (updated_by == null) {
			if (other.updated_by != null)
				return false;
		} else if (!updated_by.equals(other.updated_by))
			return false;
		if (updated_on == null) {
			if (other.updated_on != null)
				return false;
		} else if (!updated_on.equals(other.updated_on))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (user_type == null) {
			if (other.user_type != null)
				return false;
		} else if (!user_type.equals(other.user_type))
			return false;
		if (version_no == null) {
			if (other.version_no != null)
				return false;
		} else if (!version_no.equals(other.version_no))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", system_data="
				+ system_data + ", user_type=" + user_type + ", email_id=" + email_id + ", role_id=" + role_id
				+ ", active_status=" + active_status + ", created_by=" + created_by + ", created_on=" + created_on
				+ ", updated_by=" + updated_by + ", updated_on=" + updated_on + ", version_no=" + version_no
				+ ", image_path=" + image_path + ", last_login=" + last_login + ", mail_sent_time=" + mail_sent_time
				+ ", no_of_attempt=" + no_of_attempt + ", auth_code1=" + auth_code1 + ", auth_code2=" + auth_code2
				+ ", otp=" + otp + ", mobile_number=" + mobile_number + "]";
	}

}
