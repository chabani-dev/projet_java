package fr.doranco.salaires.model;

import java.util.Set;

import fr.doranco.salaires.entity.Adresse;

public interface IAdresseDao {

	public Set<Adresse> getAdresseByUserId(int userId) throws Exception;

	int addAdresse(Adresse adresse, int userId) throws Exception;

}
