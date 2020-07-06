package com.resilinc;

import org.springframework.util.ReflectionUtils;

/**
 * @author Harshal-Pande
 *
 */
public class Pojo {

	private String processed;
	private String event;
	private String subject;
	private String from;
	private String email;
	private String categories;
	private String uniqueArgs;
	private String companyName;

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getUniqueArgs() {
		return uniqueArgs;
	}

	public void setUniqueArgs(String uniqueArgs) {
		this.uniqueArgs = uniqueArgs;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Pojo [processed=" + processed + ", event=" + event + ", subject=" + subject + ", from=" + from
				+ ", email=" + email + ", categories=" + categories + ", uniqueArgs=" + uniqueArgs + ", companyName="
				+ companyName + "]";
	}
}
