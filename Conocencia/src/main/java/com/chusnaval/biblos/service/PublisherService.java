package com.chusnaval.biblos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chusnaval.biblos.dao.IPublisherDAO;
import com.chusnaval.biblos.model.Publisher;

@Transactional(readOnly = true)
@Service(value = "PublisherService")
public class PublisherService implements IPublisherService {

	@Autowired(required = true)
	private IPublisherDAO publisherDAO;

	@Override
	public List<Publisher> getPublishers() {
		return publisherDAO.getPublishers();
	}

	public IPublisherDAO getPublisherDAO() {
		return publisherDAO;
	}

	public void setPublisherDAO(IPublisherDAO publisherDAO) {
		this.publisherDAO = publisherDAO;
	}

}
