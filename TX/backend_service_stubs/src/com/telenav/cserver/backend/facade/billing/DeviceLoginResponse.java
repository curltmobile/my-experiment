package com.telenav.cserver.backend.facade.billing;

public class DeviceLoginResponse extends BillingFacadeCommonResponse{

	private long userId=-1L;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
