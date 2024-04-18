package br.fai.lds;

import br.fai.lds.models.Animal;
import br.fai.lds.models.Cavalo;
import br.fai.lds.models.Girafa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    private Scanner scanner = new Scanner(System.in);
    private List<Animal> animais = new ArrayList<>();
    private void start() {

    boolean emExecucao = true;
    while (emExecucao){

        exibirMenu();
        /**
         * A declaracao da opção ficou para fora try pois se ficar demtro, ele fica como
         */
        int opcao = -1;

        /**
         * bloco de try catch, responsavel por pegar alguma execucao vindo do scanner.next
         */
        try{
             opcao = scanner.nextInt();
             scanner.nextLine();
        }catch (Exception exception){
            /**
             * caso alguma coisa de arreado, automativamente p cprofp
             */
            scanner.next();
            System.out.println("Ocorreu um erro ao tentar ler entrada");
            /**
             * o continue serve para voltar ao topo do laco de interacao
             */
            continue;
        }

        switch (opcao){
            case 1:
                cadastrarCavalo();
                break;
            case 2:
                cadastrarGirafa();
                break;
            case 3:
                listarCavalo();
                break;
            case 4:
                listarGirafa();
                break;
            case 5:
                listarTodos();
                break;
            case 6:
                try{
                    System.out.println("--------");
                    System.out.println("Digite o ID do animal: ");

                    int idDoAnimal = scanner.nextInt();
                    removerAnimalPorId(idDoAnimal);
                }catch (Exception e){
                    scanner.next();
                    System.out.println("Ocorreu um erro ao obter o ID do animal");
                }
                break;
            case 7:
                break;
            case 8:
                emExecucao = false;
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
        System.out.println("------------------");
    }

    }

    /**
     * Este método tem como proposito exibir o menu da aplicação
     */
    private void exibirMenu(){

        System.out.println("1. Cadastrar cavalo");
        System.out.println("2. Cadastrar girafa");
        System.out.println("3. Listar cavalos");
        System.out.println("4. Listar girafas");
        System.out.println("5. Listar todos os animais");
        System.out.println("6. Remover um animal por id");
        System.out.println("7. Exibir a quantidade de animais cadastrados por tipo");
        System.out.println("8. Sair");
        System.out.println("Sua opção: ");
    }

    /**
     * Metodo responsavel por cadastrar cavalo
     */
    private void cadastrarCavalo(){
        System.out.println("--------");
        System.out.println("Digite o nome do cavalo: ");

        String nome = scanner.nextLine();
        Animal cavalo = new Cavalo(nome);

        animais.add(cavalo);
        System.out.println("Cavalo inserido com sucesso");
    }

    private void cadastrarGirafa(){
        System.out.println("----------");
        System.out.println("Digite o nome da girafa:");

        String nome = scanner.nextLine();
        Animal girafa = new Girafa(nome);

        animais.add(girafa);
        System.out.println("A girafa foi adicionado com sucesso.");
    }

    private void listarCavalo(){
        System.out.println("-----");

//        if (animais.size() == 0)  faz a mesma coisa que o de baixo!{
//
//        }
        if (animais.isEmpty()){
            System.out.println("Nenhum animal cadastrado");
            return;
        }

        for (Animal animal: animais){
            if(animal instanceof  Cavalo){
                System.out.println("Dados do cavalo ID Cavalo " + animal.getId() + " | " + "Nome " + animal.getNome());
            }
        }
    }

    private void listarGirafa(){
        System.out.println("-------");

        if (animais.isEmpty()){
            System.out.println("Nenhuma animal cadastrado");
            return;
        }

        for (Animal animal: animais){
            if(animal instanceof  Girafa){
                System.out.println("Dados do cavalo ID Girafa " + animal.getId() + " | " + "Nome " + animal.getNome());
            }
        }
    }

    private void listarTodos(){
        System.out.println("------------");
        if (animais.isEmpty()){
            System.out.println("Nenhum animal cadastrado");
            return;
        }

        for (Animal animal : animais){
            if (animal instanceof Cavalo) {
                Cavalo cavalo = (Cavalo) animal;
                System.out.println("animal: cavalo |" + cavalo.getId() + " | " + cavalo.getNome());
            } else if (animal instanceof Girafa) {
                Girafa girafa = (Girafa) animal;
                System.out.println("animal: girafa |" + girafa.getId() + " | " + girafa.getNome());
            }
        }

    }

    /**
     * Metodo responsavel por remover um animal por ID
     *
     * Sobre variaveis declaradas como FINAL:
     *  estas variaveis se tornam imutaveis, ou seja, o valor que uma vez foi inserido não pode mais ser alterado, o
     *  que ajuda na previsibilidade / manutencao do codigo
     *
     * @param id
     */
    private void removerAnimalPorId(final int id){
        int indiceDaListaDeAnimais = -1;

        // realizado a interacao de lista de animais
        for (int i = 0; i < animais.size(); i++) {
            //extraio o animal do indice i em questao
            Animal animal = animais.get(i);

            // comparo se o ID daquele animal bate com o ID que chegou por parametro
            if (animal.getId() == id){
                //caso o ID seja o mesmo, aloca o valor de i na variavel de indice e sai do laco FOR
                indiceDaListaDeAnimais = i;
                break;
            }

        }

        //agora, caso o laco FOR tenha sido finalizado E o valor do indice
        //continue em -1, isso significa que o ID buscado nao existe, portanto
        //exibe a mensagem da tela e sai do metodo de forma automatica

        if (indiceDaListaDeAnimais == -1){
            System.out.println("ID de animal inexistente");
            return;
        }

        // caso contrario, o ID eh valido, portanto basta realizar a remocao

        Animal animalRemovido = animais.remove(indiceDaListaDeAnimais);
        System.out.println("Animal " + animalRemovido.getNome() + " removido com sucesso.");

    }

}
