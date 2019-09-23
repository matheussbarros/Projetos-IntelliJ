package br.com.fiap.exemplo06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository repository;


    @GetMapping
    public List<Produto> listar(){
        return repository.findAll();
    }
    @GetMapping("{codigo}")
    public Produto buscar(@PathVariable int codigo){
        return repository.findById(codigo).get();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @PutMapping("{id}")
    public Produto atualizar(@RequestBody Produto produto,
                             @PathVariable int id){
        produto.setCodigo(id);
        return repository.save(produto);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        repository.deleteById(codigo);
    }


//    @GetMapping("pesquisa")
//    public List<Produto> buscar(@RequestParam String nome){
//        return repository.findByNome(nome);
//    }

    @GetMapping("pesquisa")
    public List<Produto> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "false") Boolean novo){
        return nome!=null?
                repository.findByNomeAndNovo(nome,novo):
                repository.findByNome(nome);
    }



}
