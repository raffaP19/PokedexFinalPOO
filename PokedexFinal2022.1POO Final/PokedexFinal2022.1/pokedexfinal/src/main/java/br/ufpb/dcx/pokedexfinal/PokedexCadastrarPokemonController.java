package br.ufpb.dcx.pokedexfinal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PokedexCadastrarPokemonController implements ActionListener {
    private InterfacePokedex pokedex;
    private JFrame janelaPrincipal;
    private GravadorDePokemons gravador;

    public PokedexCadastrarPokemonController(InterfacePokedex pokedex, JFrame janela, GravadorDePokemons gravador) {
        this.pokedex = pokedex;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog("Digite o nome do pokemón");

        String habilidades = JOptionPane.showInputDialog("Informe a(s) habilidade(s) do pokemón que deseja cadastrar");

        ArrayList<TipoPokemon> tipoPokemon = new ArrayList<>();
        JComboBox tiposDePokemon = new JComboBox<>();
        for (TipoPokemon t : TipoPokemon.values()) {
            tiposDePokemon.addItem(t);
        }

        JOptionPane.showMessageDialog(null, tiposDePokemon, "Selecione o tipo do pokemón", JOptionPane.INFORMATION_MESSAGE);
        tipoPokemon.add((TipoPokemon) tiposDePokemon.getSelectedItem());
        
        String descricao = JOptionPane.showInputDialog("Descreve o pokemón que deseja cadastrar (a aparência, gostos, entre outros)");

        try {
            pokedex.cadastrarPokemon(new Pokemon(nome, habilidades, tipoPokemon, descricao));
            gravador.salvarPokemons(pokedex.listarPokemons());
            JOptionPane.showMessageDialog(janelaPrincipal, "Cadastro realizado com sucesso!");
        } catch (PokemonJaExisteException | IOException a) {
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }
}
