package fr.doranco.salaires.model;

import java.util.Set;

import fr.doranco.salaires.entity.User;

public interface IUserDao {

	public int addUser(User user) throws Exception;
	

	public User getUserById(int id) throws Exception;

	public User getUserByEmail(String email) throws Exception;

	public void updateUser(User user) throws Exception;

	public void deleteUser(int id) throws Exception;

	public Set<User> getUsers() throws Exception;

}
