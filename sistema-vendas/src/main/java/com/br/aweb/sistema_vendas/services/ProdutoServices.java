package com.br.aweb.sistema_vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aweb.sistema_vendas.model.Produto;
import com.br.aweb.sistema_vendas.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoServices {
    
    @Autowired
    private ProdutoRepository produtoRepository;    

    @Transactional
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }
}   
