package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entity.Pokemon;

public interface IPokemonDao {

	void ajouterPokemon(Pokemon pokemon);

	void supprimerPokemon(int id);

	List<Pokemon> findAllPokemon();

	Pokemon findPokemonById(int id);

}
