package br.ufpb.dcx.pokedexfinal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PokedexApagarPokemonController implements ActionListener {
    private InterfacePokedex pokedex;
    private JFrame janelaPrincipal;
    private GravadorDePokemons gravador;

    public PokedexApagarPokemonController(InterfacePokedex pokedex, JFrame janela, GravadorDePokemons gravador) {
        this.pokedex = pokedex;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog("Digite o nome do pokemon que deseja apagar");
        try {
            pokedex.apagarPokemon(nome);
            gravador.salvarPokemons(pokedex.listarPokemons());
            JOptionPane.showMessageDialog(janelaPrincipal, "Remoção realizado com sucesso!");
        } catch (IOException | PokemonNaoExisteException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }

}
