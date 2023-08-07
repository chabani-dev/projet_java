package fr.doranco.salaires.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import fr.doranco.salaires.entity.User;
import fr.doranco.salaires.utils.Dates;

public class UserDao implements IUserDao {



	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user == null) {
			throw new NullPointerException("Le User ne doit pas être NULL !");
		}
		if (user.getNom() == null || user.getNom().trim().isEmpty() || user.getPrenom() == null
				|| user.getPrenom().trim().isEmpty()) {

			throw new IllegalArgumentException("Des paramètres du User sont manquants !");
		}
		Connection connection = SalaireDataSource.getConnection();
		String requete = "INSERT INTO user(nom, prenom, email, password) VALUES(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			int id = rs.getInt(1);
			return id;
		}
		return 0;
	}

	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		if (id <= 0) {
			throw new IllegalArgumentException("L'id doit être > 0");
		}
		Connection connection = SalaireDataSource.getConnection();
		String requete = "SELECT * FROM user WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs != null && rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			// récupérer toutes les colonnes
			return user;
		}
		return null;
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub

		if (email == null) {
			throw new IllegalArgumentException("L'id doit être null ");
		}
		Connection connection = SalaireDataSource.getConnection();
		String requete = "SELECT * FROM user WHERE email = ?";
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs != null && rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setNom(rs.getString("nom"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		}

		return user;
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user == null) {
			throw new NullPointerException("Le User ne doit pas être NULL !");
		}
		if (user.getNom() == null || user.getNom().trim().isEmpty() || user.getPrenom() == null
				|| user.getPrenom().trim().isEmpty()) {

			throw new IllegalArgumentException("Des paramètres du User sont manquants !");
		}

		Connection connection = SalaireDataSource.getConnection();
		String updateQuery = "UPDATE user SET nom = ?, titre = ? , prenom = ? ,genre = ? , date_naissance = ? , date_sortie= ? , date_entree   WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(updateQuery);
		ps.setString(1,user.getNom());
		ps.setString(2, user.getEmail());
		ps.setInt(3, user.getId());
		ps.setString(4, user.getPrenom());
		ps.setString(6, user.getGenre());
		ps.setString(7, user.getStatut());
		ps.setString(8, user.getTitre());
		ps.setDate(9, Dates.convertDateUtilToDateSql(user.getDateNaissance()));
		ps.setDate (10, Dates.convertDateUtilToDateSql(user.getDate_sortie()));
		ps.setDate(11, Dates.convertDateUtilToDateSql(user.getDateEntree()));
		ps.executeUpdate();
		

	}

	@Override
	public void deleteUser(int id) throws Exception {
		
		if (id <= 0) {
			throw new IllegalArgumentException("L'id doit être > 0");
		}
		// TODO Auto-generated method stub
		Connection connection = SalaireDataSource.getConnection();
		PreparedStatement pstmt = connection.prepareStatement("DELETE FROM user WHERE id = ?");
		String deleteQuery = null;
		pstmt = connection.prepareStatement(deleteQuery);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
	}

	@Override
	public Set<User> getUsers() throws Exception {
		// TODO Auto-generated method stub
		
		Set<User> listUser = new HashSet<User>(); //declaration d'une list de user
	        Connection connection =SalaireDataSource.getConnection(); // Besoin d'une connection donc appel de la class SalaireDataSource
	        String requete = "SELECT*FROM user";
	        PreparedStatement pstmt = connection.prepareStatement(requete);
	        ResultSet rs = pstmt.executeQuery();	
	        while (rs.next()) {
	        	
	        	User user = new User();
	        	  user.setId(rs.getInt("id"));
	              user.setId(rs.getInt("nom"));
	              user.setId(rs.getInt("prenom"));
	              user.setId(rs.getInt("age"));

	              listUser.add(user);
	        }
	        
	        
	        
	        return listUser;
	}

}
