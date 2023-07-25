package br.ufpb.dcx.pokedexfinal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class PokedexSortearPokemonController implements ActionListener {
    private InterfacePokedex pokedex;
    private JFrame janelaPrincipal;

    public PokedexSortearPokemonController(InterfacePokedex pokedex, JFrame janela) {
        this.pokedex = pokedex;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        Collection<Pokemon> pokemons = pokedex.listarPokemons();
        if (pokemons.size() <= 1) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não tem como sortear um pokemón, porque tem " + pokemons.size() + " pokemon(s) cadastrado(s)");
        } else {
            Pokemon p = pokedex.sorteiaPokemon();
            JOptionPane.showMessageDialog(janelaPrincipal, "O pokemón sorteado foi " + p.getNome());
        }
    }

}
