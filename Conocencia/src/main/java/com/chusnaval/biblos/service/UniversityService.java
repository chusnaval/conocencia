package com.chusnaval.biblos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chusnaval.biblos.dao.IUniversityDAO;
import com.chusnaval.biblos.model.University;

@Transactional(readOnly = true)
@Service(value = "UniversityService")
public class UniversityService implements IUniversityService {

	@Autowired(required = true)
	private IUniversityDAO universityDAO;

	@Override
	public List<University> getUniversities() {
		return universityDAO.getUniversities();
	}

	public IUniversityDAO getUniversityDAO() {
		return universityDAO;
	}

	public void setUniversityDAO(IUniversityDAO universityDAO) {
		this.universityDAO = universityDAO;
	}

}
