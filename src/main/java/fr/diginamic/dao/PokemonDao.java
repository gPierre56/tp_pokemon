package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.entity.Pokemon;
import fr.diginamic.utils.ConnectionManager;

public class PokemonDao implements IPokemonDao {

	@Override
	public void ajouterPokemon(Pokemon pokemon) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("insert into pokemon(nom_pokemon) values(?)");
			statement.setString(1, pokemon.getNom());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void supprimerPokemon(int id) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("delete from pokemon where id_porkemon = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Pokemon> findAllPokemon() {
		Connection con = ConnectionManager.getInstance();
		List<Pokemon> listePokemon = new ArrayList<Pokemon>();
		try {
			PreparedStatement statement = con.prepareStatement("select * from pokemon");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Pokemon pokemon = new Pokemon();
				pokemon.setId(result.getInt(1));
				pokemon.setNom(result.getString(2));
				listePokemon.add(pokemon);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (listePokemon == null || listePokemon.isEmpty()) {
			return null;
		} else {
			return listePokemon;
		}
	}

	@Override
	public Pokemon findPokemonById(int id) {
		Pokemon pokemon = new Pokemon();
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("select * from pokemon where id_pokemon = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				pokemon.setId(result.getInt(1));
				pokemon.setNom(result.getString(2));
			}
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pokemon.getId() == 0) {
			return null;
		} else {
			return pokemon;
		}

	}

}
