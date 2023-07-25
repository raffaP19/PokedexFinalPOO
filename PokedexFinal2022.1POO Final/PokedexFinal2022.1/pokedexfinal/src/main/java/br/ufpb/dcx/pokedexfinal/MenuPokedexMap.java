package br.ufpb.dcx.pokedexfinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MenuPokedexMap implements InterfacePokedex {

    private Map<String, Pokemon> pokedex;

    public MenuPokedexMap() {
        this.pokedex = new HashMap<>();
    }

    @Override
    public Collection<Pokemon> listarPokemons() {
        return this.pokedex.values();
    }

    @Override
    public void cadastrarPokemon(Pokemon p) throws PokemonJaExisteException {
        Pokemon pokemon = p;
        if (this.pokedex.containsKey(pokemon.getNome())) {
            throw new PokemonJaExisteException("O pokemon " + pokemon.getNome() + " já foi capturado (cadastrado) no pokedex.");
        } else {
            this.pokedex.put(pokemon.getNome(), pokemon);
        }
        
    }

    @Override
    public Pokemon pesquisarPokemon(String nome) throws PokemonNaoExisteException {
        Pokemon pokemon = this.pokedex.get(nome);
        if (pokemon == null) {
            throw new PokemonNaoExisteException("O pokemon " + nome + " não foi capturado (cadastrado) no pokedex.");
        } else {
            return pokemon;
        }
    }

    @Override
    public ArrayList<Pokemon> pesquisarPokemonPeloTipo(TipoPokemon tipo) {
        ArrayList<Pokemon> pokemonsDoTipo = new ArrayList<>();
        for (Pokemon pokemon : this.pokedex.values()) {
            if (pokemon.isTipo(tipo)) {
                pokemonsDoTipo.add(pokemon);
            }
        }
        return pokemonsDoTipo;
    }

    @Override
    public void apagarPokemon(String nome) throws PokemonNaoExisteException {
        if (this.pokedex.containsKey(nome)) {
            this.pokedex.remove(nome);
        } else {
            throw new PokemonNaoExisteException("O pokemon " + nome + " não foi capturado (cadastrado) no pokedex.");
        }
    }
    
    @Override
    public Pokemon sorteiaPokemon() {
        ArrayList<String> p = new ArrayList<>();
        for (String nome : this.pokedex.keySet()) {
            p.add(nome);
        }

        Random random = new Random();
        int index = random.nextInt(p.size());

        Pokemon pokemon = this.pokedex.get(p.get(index));

        return pokemon;

    }

    @Override
    public void cadastrarTipoNoPokemon(String nome, TipoPokemon tipo) throws PokemonNaoExisteException {
        if (this.pokedex.containsKey(nome)) {
            Pokemon p = this.pokedex.get(nome);
            p.inserirTipoNoPokemon(tipo);
        } else {
            throw new PokemonNaoExisteException("Não foi cadastrado o pokemón com nome " + 
            nome + " para realizar a ação.");
        }
    }

    

}
