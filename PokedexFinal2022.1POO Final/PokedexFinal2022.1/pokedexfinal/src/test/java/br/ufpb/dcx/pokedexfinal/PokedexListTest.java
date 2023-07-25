package br.ufpb.dcx.pokedexfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import javax.swing.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokedexListTest {

    InterfacePokedex sistema;

    @BeforeEach
    void setUp() {
        this.sistema = new MenuPokedexMap();

    }

    @Test
    void testPesquisaPokemonNaPokedex() {
        try {
            sistema.pesquisarPokemon("Pikachu");

        } catch (PokemonNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        //
        try {
            ArrayList<TipoPokemon> tipo = new ArrayList<>();
            tipo.add(TipoPokemon.ELETRICO);

            Pokemon poke = new Pokemon("Pikachu", "Choque do Trovão", tipo, "Um rato amarelo que dá choque na Equipe Rocket");
            sistema.cadastrarPokemon(poke);
            sistema.pesquisarPokemon("Pikachu");
            assertEquals("Pikachu", poke.getNome());

        } catch (PokemonJaExisteException | PokemonNaoExisteException e) {
            fail("Não deveria lançar exceção");

        }
        //
    }

    @Test
    void cadastrarPokemon() {
        try {
            ArrayList<TipoPokemon> tipo = new ArrayList<>();
            tipo.add(TipoPokemon.ELETRICO);

            Pokemon poke = new Pokemon("Pikachu", "Choque do Trovão", tipo, "Um rato amarelo que dá choque na Equipe Rocket");
            sistema.cadastrarPokemon(poke);
            assertEquals("Pikachu", poke.getNome());
            assertEquals("Choque do Trovão", poke.getHabilidade());
            assertEquals("Um rato amarelo que dá choque na Equipe Rocket", poke.getDescricao());

        } catch (PokemonJaExisteException e) {
            fail("Não deveria lançar exceção");

        }
        //

    }

    //
    @Test
    void removerPokemon() {
        
        ArrayList<TipoPokemon> tipo2 = new ArrayList<>();
        tipo2.add(TipoPokemon.FOGO);

        try {
            sistema.cadastrarPokemon(new Pokemon("Charizard", "Blaze", tipo2, "Um pokemon voador que possui uma aparência dragonica"));
            assert(sistema != null);
        } catch (PokemonJaExisteException e) {
            fail("Não deveria lançar exceção");
        }

        try {
            sistema.apagarPokemon("Charizard");
        } catch (PokemonNaoExisteException e) {
            fail("Não deveria lançar exceção");
        }

    }

    @Test
    public void testeSorteio() {
        
        try{
            ArrayList<TipoPokemon> tipo1 = new ArrayList<>();
            ArrayList<TipoPokemon> tipo2 = new ArrayList<>();
            ArrayList<TipoPokemon> tipo3 = new ArrayList<>();

            tipo1.add(TipoPokemon.ELETRICO);
            tipo2.add(TipoPokemon.FOGO);
            tipo3.add(TipoPokemon.ELETRICO);

            sistema.cadastrarPokemon(new Pokemon("Pikachu", "Choque do Trovão", tipo1, "Um rato amarelo que dá choque na Equipe Rocket"));
            sistema.cadastrarPokemon(new Pokemon("Charizard", "Blaze", tipo2, "Um pokemon voador que possui uma aparência dragonica"));
            sistema.cadastrarPokemon(new Pokemon("Raichu", "Raichu estático", tipo1, "Um rato que é a evolução do Pikachu"));

            Pokemon pokemon = sistema.sorteiaPokemon();

            assert(pokemon != null);
            JOptionPane.showMessageDialog(null, pokemon.getNome());

        } catch (PokemonJaExisteException e) {
            fail("Não deveria lançar exceção");
        }

    }

}