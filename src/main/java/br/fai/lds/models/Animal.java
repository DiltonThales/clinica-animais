package br.fai.lds.models;

public abstract class Animal {
    private int id;
    private String nome;


    /**
     * Ao criar uma variavel tipo static, o mesmo podera ser compartilhada com todas
     * as instancias que as classes/subclasses terao
     *
     * Exemplo: neste caso, o valor da variavel idUnico sera o mesmo para: Cavalo e Girafa
     *
     * ou seja, ao realizar o incremento em uma dessas classes, automaticamente
     * a outra classe passa a ter aquele valor.
     *
     * Outro detalhe falaremos mais adiante é que metodos estaticos podem ser
     * processados sem a necessidade de se criar uma instancia, porem isso
     * voces nao precisam se preocupar por enquanto...
     */
    private static int idUnico = 0;

    public int getIdUnico(){
        return idUnico;
    }


    protected void  incrementarIdUnico(){
        idUnico += 1;
    }


    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }
}

