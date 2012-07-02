package com.chusnaval.biblos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chusnaval.biblos.dao.IWriterDAO;
import com.chusnaval.biblos.model.Writer;

@Transactional(readOnly = true)
@Service(value = "WriterService")
public class WriterService implements IWriterService {

	@Autowired(required = true)
	private IWriterDAO writerDAO;

	@Override
	public List<Writer> getWriters() {
		return writerDAO.getWriters();
	}

	public IWriterDAO getWriterDAO() {
		return writerDAO;
	}

	public void setWriterDAO(IWriterDAO writerDAO) {
		this.writerDAO = writerDAO;
	}

}
