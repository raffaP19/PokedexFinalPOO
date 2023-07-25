package br.ufpb.dcx.pokedexfinal;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PokedexGUI extends JFrame {
    
    JLabel background;
    ImageIcon pokedexIcon = new ImageIcon("pokedexfinal" + File.separator + "src" + File.separator + "resources" + File.separator + "imgs" + File.separator + "PokedexGUI.png");
    InterfacePokedex pokedex = new MenuPokedexMap();
    JButton botaoCadastrar, botaoApagar;
    Font fonteBotaoCadastrar, fonteBotaoApagar;
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDePokemons gravador = new GravadorDePokemons();

    public PokedexGUI() {
        // Configurando a estrutura da janela
        setTitle("Pokemóns");
        setSize(500, 400);
        setLocation(350, 150);
        setResizable(false);

        // Recuperando dados
        Collection<Pokemon> pokemons = null;
        try {
            pokemons = gravador.recuperarPokemons();
            for (Pokemon p : pokemons) {
                this.pokedex.cadastrarPokemon(p);
            }
            JOptionPane.showMessageDialog(null, "Pokemóns recuperados com sucesso");
        } catch (IOException | ClassNotFoundException | PokemonJaExisteException e) {
            JOptionPane.showMessageDialog(null, "Pokemóns não recuperados! Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Definindo o plano de fundo
        background = new JLabel(pokedexIcon);
        setContentPane(background);

        // Configurando botões e adicionando-os na janela
        botaoCadastrar = new JButton("Cadastrar pokemon");
        botaoCadastrar.setToolTipText("Cadastra um novo pokemón no pokedex");
        botaoCadastrar.addActionListener(new PokedexCadastrarPokemonController(pokedex, this, gravador));

        botaoApagar = new JButton("Remover pokemon");
        botaoApagar.setToolTipText("Apaga um pokemon cadastrado no pokedex");
        botaoApagar.addActionListener(new PokedexApagarPokemonController(pokedex, this, gravador));

        botaoCadastrar.setBounds(279, 85, 180, 115);
        fonteBotaoCadastrar = new Font("Serif", Font.ITALIC | Font.BOLD, 30);
        botaoCadastrar.setForeground(Color.darkGray);
        botaoCadastrar.setBackground(Color.GREEN);
        add(botaoCadastrar);

        botaoApagar.setBounds(279,200, 180, 115);
        botaoApagar.setForeground(Color.darkGray);
        fonteBotaoApagar = new Font("Serif", Font.ITALIC | Font.BOLD, 30);
        botaoApagar.setBackground(Color.GREEN);
        add(botaoApagar);

        // Configurando a barra de menu
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarPokemon = new JMenuItem("Pesquisar pokemón");
        menuPesquisar.add(menuPesquisarPokemon);
        menuPesquisarPokemon.addActionListener(new PokedexPesquisarPokemonController(pokedex, this));

        JMenuItem menuPesquisarPokemonPeloTipo = new JMenuItem("Pequisar pokemón pelo tipo");
        menuPesquisar.add(menuPesquisarPokemonPeloTipo);
        menuPesquisarPokemonPeloTipo.addActionListener(new PokedexPesquisarPokemonPeloTipoController(pokedex, this));
        barraDeMenu.add(menuPesquisar);

        JMenu menuSortear = new JMenu("Sortear");
        JMenuItem menuSortearPokemon = new JMenuItem("Sortear pokemón");
        menuSortear.add(menuSortearPokemon);
        menuSortearPokemon.addActionListener(new PokedexSortearPokemonController(pokedex, this));
        barraDeMenu.add(menuSortear);

        JMenu menuInserir = new JMenu("Inserir");
        JMenuItem menuInserirTipoNoPokemon = new JMenuItem("Inserir tipo no pokemón");
        menuInserir.add(menuInserirTipoNoPokemon);
        menuInserirTipoNoPokemon.addActionListener(new PokedexInserirTipoNoPokemonController(pokedex, this, gravador));
        barraDeMenu.add(menuInserir);

        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        JFrame janela = new PokedexGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(janela, "Tem " +
                        "certeza de que quer sair?", "Atenção", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
