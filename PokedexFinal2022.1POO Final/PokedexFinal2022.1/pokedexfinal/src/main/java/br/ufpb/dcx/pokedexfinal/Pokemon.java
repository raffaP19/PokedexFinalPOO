package br.ufpb.dcx.pokedexfinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Pokemon implements Serializable {

    private String nome;
    private String habilidade;
    private ArrayList<TipoPokemon> tipo;
    private String descricao;

    /**
     * Cria um Pokemon após informar os dados necessários do mesmo
     * @param nome O nome do pokemón
     * @param habilidade As habilidades que o pokemón possui
     * @param tipo O tipo de pokemón ele é
     * @param descricao A descrição do pokemón (Seus gostos, sua aparência, etc)
     */
    public Pokemon (String nome, String habilidade, ArrayList<TipoPokemon> tipo, String descricao) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.tipo = tipo;
        this.descricao = descricao;

    }

    /**
     * Cria um Pokemón sem informações
     */
    public Pokemon() {
        this("","",new ArrayList<>(),"");

    }

    /**
     * Descreve as informações do Pokemón
     * @return Retorna as informações cadastradas 
     * do objeto Pokemon
     */
    public String toString(){
        return "Nome do pokemón: " + this.getNome() + "\nHabilidades: " + this.getHabilidade()+ "\nTipo de pokemón: " + this.tipo + "\nDescrição: " + this.getDescricao() + "\n\n";

    }

    /**
     * Mostra o nome do objeto Pokemon
     * @return retorna o nome do Pokemón
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Mostra as habilidades do objeto Pokemon
     * @return retorna as habilidades do Pokemón
     */
    public String getHabilidade() {
        return this.habilidade;
    }

    /**
     * Mostra a descrição do objeto Pokemon
     * @return retorna a descrição do Pokemón
     */
    public String getDescricao() {
        return this.descricao;

    }

    /**
     * Verifica se o pokemón é do tipo que foi informado ou não
     * @param tipo  Analisa se o pokemón é do mesmo tipo informado
     * @return      Retorna true quando o pokemón é do mesmo tipo informado. Caso contrário, retorna false
     */
    public boolean isTipo(TipoPokemon tipo) {
        for (TipoPokemon t : this.tipo) {
            if (t == tipo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Insere um novo tipo ao pokemón desejado
     * @param tipo  Insere um novo tipo para o pokemón
     */
    public void inserirTipoNoPokemon(TipoPokemon tipo) {
        this.tipo.add(tipo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(nome, pokemon.nome) && Objects.equals(habilidade, pokemon.habilidade) && Objects.equals(tipo, pokemon.tipo) && Objects.equals(descricao, pokemon.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, habilidade, tipo, descricao);

    }

}