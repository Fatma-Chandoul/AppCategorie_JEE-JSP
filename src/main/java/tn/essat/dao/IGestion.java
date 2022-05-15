package tn.essat.dao;

import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Produit;

public interface IGestion {
	public List<Categorie>getAllCategories();
	public Categorie getCategorieById(int id);
	public List<Produit>getAllProduits();
	public void addProduit(Produit p);
	public void deleteProduit(int id);

}
