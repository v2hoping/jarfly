package com.owl.utils;

import java.util.Map;

/**
 * @author jiaoanjian
 */
public class ValidationResult {
	
	// 校验结果是否有错
	private Boolean hasErrors;

	// 校验错误信息
	private Map<String, String> errorMsg;



	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}
	
	public String getErrorString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> item : errorMsg.entrySet()) {
			sb.append(item.getKey()+":"+item.getValue()+".\n");
		}
		return sb.toString();
	}

	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ValidationResult [hasErrors=" + getHasErrors() + ", errorMsg=" + errorMsg + "]";
	}

	public Boolean getHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(Boolean hasErrors) {
		this.hasErrors = hasErrors;
	}
}
