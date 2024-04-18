package br.fai.lds.models;

public class Girafa extends Animal{
//    public Girafa(int id, String nome) {
//        setId(id);
//        setNome(nome);
//    }


    public Girafa(String nome){
        setNome(nome);

        incrementarIdUnico();
        int id = getIdUnico();
        setId(id);
    }
}
