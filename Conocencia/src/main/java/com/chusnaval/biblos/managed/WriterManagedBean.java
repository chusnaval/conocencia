package com.chusnaval.biblos.managed;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.chusnaval.biblos.model.Writer;
import com.chusnaval.biblos.service.IWriterService;

@ManagedBean(name = "writerMB")
public class WriterManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6148224551170199523L;

	@ManagedProperty(value = "#{WriterService}")
	IWriterService writerService;

	public List<Writer> getWriters() {
		return writerService.getWriters();
	}

	public IWriterService getWriterService() {
		return writerService;
	}

	public void setWriterService(IWriterService writerService) {
		this.writerService = writerService;
	}
}
