package br.com.fiap.exemplo07;



import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    List<Produto> findByNome(String prod);

    List<Produto> findByPrecoOrderByNomeDesc(Double preco);

    List<Produto> findByNomeIgnoreCaseOrderByPrecoAsc(String nome);



    List<Produto> findByNomeAndNovo(String nome, boolean novo);
    List<Produto> findByPrecoGreaterThan(double preco);
    List<Produto> findByDataFabricacaoBetween(LocalDate i, LocalDate f);


}
