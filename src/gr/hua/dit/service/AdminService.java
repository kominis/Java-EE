package gr.hua.dit.service;

import gr.hua.dit.entity.ApplicationUser;

public interface AdminService {
	public void createUser(ApplicationUser appUser);
	
	public void deleteUser(int id);
	
	public void modifyUser(ApplicationUser modifiedAppUser);
	
	public ApplicationUser getUser(int id);
}