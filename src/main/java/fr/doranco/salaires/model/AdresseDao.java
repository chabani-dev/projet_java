package fr.doranco.salaires.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import fr.doranco.salaires.entity.Adresse;


public class AdresseDao implements IAdresseDao {

	public Set<Adresse> getAdresseByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		
		if (userId <= 0) {
			throw new IllegalArgumentException("L'id doit être > 0");
		}
		Connection connection = SalaireDataSource.getConnection();
		String requete = "SELECT * FROM adresse WHERE userId = ?";
	    PreparedStatement ps = connection.prepareStatement(requete);
	    ps.setInt(1, userId);
	    ResultSet rs = ps.executeQuery();

	    Set<Adresse> adresses = new HashSet<>();
	    while (rs.next()) {
	        Adresse adresse = new Adresse();
	        adresse.setId(rs.getInt("id"));
	        adresses.add(adresse);
	    }
		
			return adresses;
		}
		
	@Override
	public int addAdresse(Adresse adresse, int userId) throws Exception {
	    if (userId <= 0) {
	        throw new NullPointerException("Le User ne doit pas être NULL !");
	    }
	    if (adresse == null) {
	        throw new IllegalArgumentException("Des paramètres du adresse sont manquants !");
	    }

	    Connection connection = SalaireDataSource.getConnection();
	    String requete = "INSERT INTO adresse (user_id , numero, rue, ville, code_postal) VALUES (?,?,?,?,?)";
	    PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
	    ps.setInt(1, userId);
	    ps.setInt(2,adresse.getNumero());
	    ps.setString(3,adresse.getRue());
	    ps.setString(4, adresse.getVille());
	    ps.setInt(5, adresse.getCodePostal());
	    ps.executeUpdate();
	
	
	return 0;
	

}
}
