package br.ufpb.dcx.pokedexfinal;

public class PokemonNaoExisteException extends  Exception {

    public PokemonNaoExisteException (String notificacao) {
        super(notificacao);

    }

}
