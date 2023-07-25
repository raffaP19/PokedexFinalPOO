package br.ufpb.dcx.pokedexfinal;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDePokemons {

    private String fileName = "colecao_de_pokemons.txt";

    public void salvarPokemons(Collection<Pokemon> pokemons) throws IOException {
        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(fileName));
            ArrayList<Pokemon> pokemonsASalvar = new ArrayList<>(pokemons);
            gravador.writeObject(pokemonsASalvar);
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }

    public Collection<Pokemon> recuperarPokemons() throws IOException, ClassNotFoundException {
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream(new FileInputStream(fileName));
            Collection<Pokemon> pokemonsLidos = (Collection<Pokemon>) leitor.readObject();
            return pokemonsLidos;
        } finally {
            if(leitor!=null) {
                leitor.close();
            }
        }
    }
}