package br.ufpb.dcx.pokedexfinal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class PokedexPesquisarPokemonPeloTipoController implements ActionListener{
    private InterfacePokedex pokedex;
    private JFrame janelaPrincipal;

    public PokedexPesquisarPokemonPeloTipoController(InterfacePokedex pokedex, JFrame janela) {
        this.pokedex = pokedex;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String listaDePokemons = "";
        Collection<Pokemon> pokemons = pokedex.listarPokemons();
        TipoPokemon tipo;
        JComboBox tiposDePokemon = new JComboBox<>();
        for (TipoPokemon t : TipoPokemon.values()) {
            tiposDePokemon.addItem(t);
        }
        JOptionPane.showMessageDialog(null, tiposDePokemon, "Selecione o tipo do pokemón", JOptionPane.INFORMATION_MESSAGE);

        tipo = (TipoPokemon) tiposDePokemon.getSelectedItem();

        if(pokemons.size() == 0) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi possível completar a ação, pois não foi cadastrado nenhum pokemón");
        } else {
            for (Pokemon p : pokemons) {
                if (p.isTipo(tipo)) {
                    listaDePokemons += p.getNome() + "\n";
                }
            }
            if(listaDePokemons.length() > 0){
                JOptionPane.showMessageDialog(janelaPrincipal, "A lista de pokemóns do tipo " + tipo + ":\n" + listaDePokemons);
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal, "Não foi cadastrado um pokemón do tipo " + tipo);
            }
        }
    }
}
