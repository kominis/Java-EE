package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.ApplicationUser;

public interface ApplicationUserDAO {

	public List<ApplicationUser> getEmployees(int rights);

	public List<ApplicationUser> getAdministrators(int rights);

	public List<ApplicationUser> getEngineers(int rights);
	
}
