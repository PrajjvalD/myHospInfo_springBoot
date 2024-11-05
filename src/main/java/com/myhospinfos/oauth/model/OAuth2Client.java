package com.myhospinfos.oauth.model;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "oauth_client_details")
public class OAuth2Client {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "created", nullable = false)
	private Date created;
	@Column(name = "last_updated")
	private Date lastUpdate;

	@Column(name = "client_id", nullable = false)
	private String clientId;
	@Column(name = "resource_ids")
	private String resourceIds;
	@Column(name = "client_secret", nullable = false)
	private String clientSecret;
	@Column(name = "scope", nullable = false)
	private String scope;
	@Column(name = "authorized_grant_types", nullable = false)
	private String grantTypes;
	@Column(name = "web_server_redirect_uri")
	private String webServerRedirectUri;
	@Column(name = "authorities", nullable = false)
	private String authorities;
	@Column(name = "access_token_validity", nullable = false)
	private Integer accessTokenValidity;
	@Column(name = "refresh_token_validity")
	private Long refreshTokenValidity;
	@Column(name = "additional_information", length = 4096)
	private String additionalInfo;
	@Column(name = "autoapprove")
	private String autoApprove;
	@Column(name = "CUSER_NAME")
	private String cUserName;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getGrantTypes() {
		return grantTypes;
	}

	public void setGrantTypes(String grantTypes) {
		this.grantTypes = grantTypes;
	}

	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Long getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Long refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getAutoApprove() {
		return autoApprove;
	}

	public void setAutoApprove(String autoApprove) {
		this.autoApprove = autoApprove;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getcUserName() {
		return cUserName;
	}

	public void setcUserName(String cUserName) {
		this.cUserName = cUserName;
	}

}
