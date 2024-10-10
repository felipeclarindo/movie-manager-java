package view;

import javax.swing.JOptionPane;
import controller.FilmeController;

public class FilmeView {
    public static void main(String[] args) {
        int codigo;
        String aux;
        String titulo;
        String genero;
        String produtora;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        int opcao;
        FilmeController filmeController = new FilmeController();
        
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Filme", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao) {
                    case 0:
                        titulo = JOptionPane.showInputDialog("Digite o titulo do filme");
                        genero = JOptionPane.showInputDialog("Digite o gênero do filme");
                        produtora = JOptionPane.showInputDialog("Digite a produtora do filme");
                        System.out.println(filmeController.inserirFilme(titulo, genero, produtora));
                        break;
                    case 1:
                        aux = JOptionPane.showInputDialog("Digite o código do Filme");
                        codigo = Integer.parseInt(aux);
                        titulo = JOptionPane.showInputDialog("Digite o titulo do filme");
                        genero = JOptionPane.showInputDialog("Digite o gênero do filme");
                        produtora = JOptionPane.showInputDialog("Digite a produtora do filme");
                        System.out.println(filmeController.alterarFilme(codigo, titulo, genero, produtora));
                        break;
                    case 2:
                        aux = JOptionPane.showInputDialog("Digite o código do Filme");
                        codigo = Integer.parseInt(aux);
                        System.out.println(filmeController.excluirFilme(codigo));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, filmeController.listarTodosFilmes());;

                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim do Programa");
    }
}