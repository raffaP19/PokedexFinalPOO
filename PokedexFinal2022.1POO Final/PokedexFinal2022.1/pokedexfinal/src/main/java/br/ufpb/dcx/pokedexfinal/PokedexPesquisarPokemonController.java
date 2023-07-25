package br.ufpb.dcx.pokedexfinal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PokedexPesquisarPokemonController implements ActionListener {
    private InterfacePokedex pokedex;
    private JFrame janelaPrincipal;

    public PokedexPesquisarPokemonController(InterfacePokedex pokedex, JFrame janela) {
        this.pokedex = pokedex;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do pokemón que deseja pesquisar");
        try {
            Pokemon p = pokedex.pesquisarPokemon(nome);
            JOptionPane.showMessageDialog(janelaPrincipal, p.toString(), "Pokemon encontrado:", JOptionPane.INFORMATION_MESSAGE);
        } catch (PokemonNaoExisteException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
