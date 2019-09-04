package br.com.fiap.exemplo04h2.controller;

import br.com.fiap.exemplo04h2.Produto;
import br.com.fiap.exemplo04h2.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "formulario";
    }

    @GetMapping("/buscar")
    public String buscar(){
        return "busca";
    }

    @PostMapping("/cadastrar")
    public String processarForm(Produto produto){
        repository.save(produto);
        System.out.print(produto.getNome() + " " + produto.getPreco());
        return "sucesso";
    }

    @PostMapping("/buscarProduto")
    public String processarForm(int cod, Model model){
       Optional<Produto> produto = repository.findById(cod);
       model.addAttribute("prod", produto);
       return "listaProduto";
    }


}
