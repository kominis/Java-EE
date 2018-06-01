package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.ApplicationUserDAO;
import gr.hua.dit.entity.ApplicationUser;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

	@Autowired
	private ApplicationUserDAO appUserDAO;
	
	@Override
	@Transactional
	public List<ApplicationUser> getEmployees(int rights) {
		return appUserDAO.getEmployees(rights);
	}

	@Override
	@Transactional
	public List<ApplicationUser> getAdministrators(int rights) {
		return appUserDAO.getAdministrators(rights);
	}

	@Override
	@Transactional
	public List<ApplicationUser> getEngineers(int rights) {
		return appUserDAO.getEngineers(rights);
	}

}
