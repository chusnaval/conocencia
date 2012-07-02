package com.chusnaval.biblos.managed;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.chusnaval.biblos.model.Publisher;
import com.chusnaval.biblos.service.IPublisherService;

@ManagedBean(name = "publisherMB")
public class PublisherManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6148224551170199523L;

	@ManagedProperty(value = "#{PublisherService}")
	IPublisherService publisherService;

	public List<Publisher> getPublishers() {
		return publisherService.getPublishers();
	}

	public IPublisherService getPublisherService() {
		return publisherService;
	}

	public void setPublisherService(IPublisherService publisherService) {
		this.publisherService = publisherService;
	}
}
