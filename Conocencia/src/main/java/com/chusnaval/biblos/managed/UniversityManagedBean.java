package com.chusnaval.biblos.managed;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.chusnaval.biblos.model.University;
import com.chusnaval.biblos.service.IUniversityService;

@ManagedBean(name = "universityMB")
public class UniversityManagedBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5021779643081896600L;
	
	@ManagedProperty(value = "#{UniversityService}")
	private IUniversityService universityService;

	public List<University> getUniversities() {
		return universityService.getUniversities();
	}

	public IUniversityService getUniversityService() {
		return universityService;
	}

	public void setWriterService(IUniversityService universityService) {
		this.universityService = universityService;
	}
}
