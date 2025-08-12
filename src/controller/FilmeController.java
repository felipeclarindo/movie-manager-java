package controller;

import java.util.ArrayList;

import model.dao.ConnectionFactory;
import model.dao.FilmeDAO;
import model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;

public class FilmeController {
    public String inserirFilme(String titulo, String genero,String produtora) throws
        ClassNotFoundException, SQLException {
            String resultado;
            Connection con = ConnectionFactory.abrirConexao();
            Filme filme = new Filme();
            filme.setTitulo(titulo);
            filme.setGenero(genero);
            filme.setProdutora(produtora);
            FilmeDAO filmeDAO = new FilmeDAO(con);
            resultado = filmeDAO.inserir(filme);
            ConnectionFactory.fecharConexao(con);
            return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero,String produtora) throws
        ClassNotFoundException, SQLException {
            String resultado;
            Connection con = ConnectionFactory.abrirConexao();
            Filme filme = new Filme();
            filme.setCodigo(codigo);
            filme.setTitulo(titulo);
            filme.setGenero(genero);
            filme.setProdutora(produtora);
            FilmeDAO filmeDAO = new FilmeDAO(con);
            resultado = filmeDAO.alterar(filme);
            ConnectionFactory.fecharConexao(con);
            return resultado;
    }

    public String excluirFilme(int codigo) throws
        ClassNotFoundException, SQLException {
            String resultado;
            Connection con = ConnectionFactory.abrirConexao();
            Filme filme = new Filme();
            filme.setCodigo(codigo);
            FilmeDAO filmeDAO = new FilmeDAO(con);
            resultado = filmeDAO.excluir(filme);
            ConnectionFactory.fecharConexao(con);
            return resultado;
    }

    public String listarTodosFilmes() throws
        ClassNotFoundException, SQLException {
            ArrayList<Filme> filmes = new ArrayList<Filme>();
            Connection con = ConnectionFactory.abrirConexao();
            FilmeDAO filmeDAO = new FilmeDAO(con);
            String resultado = "";
            if (!filmes.isEmpty()){
                filmes = filmeDAO.listarTodos();
                for (Filme filme: filmes) {
                    resultado += resultado + "--------- " + filme.getTitulo() + " ---------" + ": " + "\nCodigo: " + filme.getCodigo() +  "\nTitulo: " + filme.getTitulo() + "\nGênero: " + filme.getGenero() + "\nProdutora: " + filme.getProdutora() + "\n";
                }
            }
            
            if (resultado.isEmpty()){
                resultado = "Nenhum filme encontrado.";
            }
            
            ConnectionFactory.fecharConexao(con);
            return resultado;
    }
}