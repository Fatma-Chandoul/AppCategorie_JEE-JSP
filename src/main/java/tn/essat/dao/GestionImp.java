package tn.essat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Produit;

public class GestionImp implements IGestion {
	Connection cnx;
	
	public GestionImp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/base888", "root", "");

		} catch (Exception e) {

		}
	}

	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> liste=new ArrayList<Categorie>();
		try {
		PreparedStatement pre=this.cnx.prepareStatement("select * from categorie");
		ResultSet rs=pre.executeQuery();
		while(rs.next()) {
			Categorie cat=new Categorie();
		cat.setId(rs.getInt("id"));
		cat.setTitre(rs.getString("titre"));
		liste.add(cat);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return liste;
	}

	@Override
	public Categorie getCategorieById(int id) {
		Categorie c = new Categorie();
		try {
			PreparedStatement pre = this.cnx.prepareStatement("select * from categorie where id =?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();// methode de selection
			if (rs.next()) {

				c.setId(rs.getInt("id"));
				c.setTitre(rs.getString("titre"));
				// liste.add(et);

			}

		} catch (Exception e) {

		}
		return c;

	}

	@Override
	public List<Produit> getAllProduits() {
		List<Produit> liste = new ArrayList<Produit>();
		try {
			PreparedStatement pre = this.cnx.prepareStatement("select * from produit ");
			ResultSet rs = pre.executeQuery();// methode de selection
			while (rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getInt("id"));
				p.setTitre(rs.getString("titre"));
				p.setPrix(rs.getFloat("prix"));
				p.setCat(this.getCategorieById(rs.getInt("cat_id")));
				liste.add(p);

			}

		} catch (Exception e) {

		}

		return liste;
	}

	@Override
	public void addProduit(Produit p) {
		try {
			PreparedStatement pre = this.cnx.prepareStatement("insert into produit values (null,?,?,?)");
			// pre.setInt(1, p.getId());
			pre.setString(1, p.getTitre());
			pre.setFloat(2, p.getPrix());
			pre.setInt(3, p.getCat().getId());
			pre.executeUpdate();

		} catch (Exception e) {

		}
		
	}

	@Override
	public void deleteProduit(int id) {
		try {
			PreparedStatement pre = this.cnx.prepareStatement("delete from produit where id=?");
			pre.setInt(1, id);
			pre.executeUpdate();

		} catch (Exception e) {

		}

		
	}
	

}
