package br.fai.lds.models;

public class Cavalo extends Animal{
    //    public Cavalo(int id, String nome) {
//        setId(id);
//        setNome(nome);
//    }

    public Cavalo (String nome){
        setNome(nome);

        incrementarIdUnico();
        int id = getIdUnico();
        setId(id);
    }

    public String getTipo(){
        return "Cavalo";
    }
}
