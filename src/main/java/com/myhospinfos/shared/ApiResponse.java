package com.myhospinfos.shared;

public class ApiResponse<T> {
	private int status;
	private T data;

	public ApiResponse(int status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	public ApiResponse() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", data=" + data + "]";
	}

}
