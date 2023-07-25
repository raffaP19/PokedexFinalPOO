package br.ufpb.dcx.pokedexfinal;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Interface que representa todas as funcionalidades 
 * do sistema pokedexfinal
 */
public interface InterfacePokedex {


    /**
     * Cadastra um pokemón através das informações sobre ele
     * @param p O Pokemon a cadastrar
     * @throws PokemonJaExisteException Se tentar
     * cadastrar um pokemón mais de uma vez
     */
    void cadastrarPokemon(Pokemon p) throws PokemonJaExisteException;


    /**
     * Obter todos os dados de um certo pokemón identificado
     * por um certo nome
     * @param nome nome do pokemón a ser pesquisado
     * @return retorna o objeto Pokemon com todos os dados
     * @throws PokemonNaoExisteException Se não existir no 
     * sistema nenhum pokemón com o nome indicado
     */
    Pokemon pesquisarPokemon(String nome) throws PokemonNaoExisteException;


    /**
     * Mostra uma Coleção de pokemóns
     * @return retorna um Coleção de todos os 
     * pokemóns cadastrados no sistema
     */
    Collection<Pokemon> listarPokemons();


    /**
     * Apaga os dados do certo pokemón identificado 
     * por um certo nome
     * @param nome nome do pokemón a ser apagado
     * @throws PokemonNaoExisteException Se não existir no
     * sistema nenhum pokemón com o nome indicado
     */
    void apagarPokemon(String nome) throws PokemonNaoExisteException;


    /**
     * Sortea um dos pokemóns cadastrados no sistema 
     * @return retorna o objeto Pokemon sorteado
     */
    Pokemon sorteiaPokemon();


    /**
     * Pesquisa pokemóns do tipo indicado
     * @param tipo tipo do pokemón a ser pesquisado
     * @return retorna uma lista de pokemóns do tipo
     * indicado
     */
    ArrayList<Pokemon> pesquisarPokemonPeloTipo(TipoPokemon tipo);


    void cadastrarTipoNoPokemon(String nome, TipoPokemon tipo) throws PokemonNaoExisteException;
}
