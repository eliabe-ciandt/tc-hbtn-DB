package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.Date;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        Produto produto = produtoModel.findById(produtos.get(0));
        System.out.println(produto);

        produtoModel.delete(produto);
        System.out.println("Qtde de produtos encontrados : " + produtos.size());


        // TODO - Testar os demais metódos das classes: ProdutoModel e PessoaModel
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa = new Pessoa("Eu mesmo", "eumesmo@email.com", 23, "432304975123", new Date());

        pessoaModel.create(pessoa);
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Quantidade de pessoas encontradas: " + pessoas.size());
        System.out.println(pessoaModel.findById(pessoas.get(0)));

    }
}
