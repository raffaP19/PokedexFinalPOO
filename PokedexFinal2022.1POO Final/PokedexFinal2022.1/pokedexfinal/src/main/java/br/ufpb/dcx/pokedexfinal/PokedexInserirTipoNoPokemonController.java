package br.ufpb.dcx.pokedexfinal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PokedexInserirTipoNoPokemonController implements ActionListener {
    private InterfacePokedex pokedex;
    private JFrame janelaPrincipal;
    private GravadorDePokemons gravador;

    public PokedexInserirTipoNoPokemonController(InterfacePokedex pokedex, JFrame janela, GravadorDePokemons gravador) {
        this.pokedex = pokedex;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do pokemón que " +
        " deseja inserir um novo tipo");
        TipoPokemon tipoPokemon;
        JComboBox tiposDePokemon = new JComboBox<>();
        for (TipoPokemon t : TipoPokemon.values()) {
            tiposDePokemon.addItem(t);
        }

        JOptionPane.showMessageDialog(null,tiposDePokemon, "Selecione o tipo do pokemón", JOptionPane.INFORMATION_MESSAGE);
        tipoPokemon = (TipoPokemon) tiposDePokemon.getSelectedItem();

        try {
            pokedex.cadastrarTipoNoPokemon(nome, tipoPokemon);
            gravador.salvarPokemons(pokedex.listarPokemons());
            JOptionPane.showMessageDialog(janelaPrincipal, "Inserção realizado com sucesso");
        } catch (PokemonNaoExisteException | IOException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }
}
