package br.com.fiap.exemplo06;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
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


    @GetMapping("/buscar2")
    public String buscar2(){
        return "busca2";
    }


    @PostMapping("/cadastrar")
    public String processarForm(Produto produto){
        repository.save(produto);
        System.out.print(produto.getNome() + " " + produto.getPreco());
        return "sucesso";
    }

    @PostMapping("/buscarProduto")
    public String processarForm(String nome, Model model){
        List<Produto> produtos = repository.findByNome(nome);
        model.addAttribute("produtos", produtos);
        return "sucesso";
    }

    @PostMapping("/buscarProduto2")
    public String processarForm2(double preco, Model model){
        List<Produto> produtos = repository.findByPrecoOrderByNomeDesc(preco);
        model.addAttribute("produtos", produtos);
        return "sucesso";
    }




}
