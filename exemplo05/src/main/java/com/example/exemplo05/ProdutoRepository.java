package com.example.exemplo05;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    List<Produto> findByNome(String prod);


}
