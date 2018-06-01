package gr.hua.dit.dao;

import gr.hua.dit.entity.ApplicationUser;

public interface AdminDAO {
	public void createUser(ApplicationUser appUser);

	public void deleteUser(int id);

	public void modifyUser(ApplicationUser modifiedAppUser);

	public ApplicationUser getUser(int id);
}
