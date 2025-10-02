package com.br.aweb.sistema_vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aweb.sistema_vendas.model.Cliente;
import com.br.aweb.sistema_vendas.model.Pedido;
import com.br.aweb.sistema_vendas.model.Produto;
import com.br.aweb.sistema_vendas.model.StatusPedido;
import com.br.aweb.sistema_vendas.repository.PedidoRepository;
import com.br.aweb.sistema_vendas.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
import lombok.var;

@Service
public class PedidoServices {
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public Pedido salvar(Cliente cliente) {
        return pedidoRepository.save(new Pedido(cliente));
    }

    @Transactional
    public void adicionarItem(Long pedidoId, Long produtoId, Integer quantidade) {
        var optinalProduto = produtoRepository.findById(produtoId);
        var optinalPedido = pedidoRepository.findById(pedidoId);
        if (!optinalProduto.isPresent() || !optinalPedido.isPresent()) {
            throw new IllegalArgumentException("Produto/Pedido não enontrado");
        }
        Produto produtoExistente = optinalProduto.get();
        Pedido pedidoExistente = optinalPedido.get();

        if (pedidoExistente.getStatus().compareTo(StatusPedido.ATIVO) != 0) {
            throw new IllegalArgumentException("Pedido não ativo");
        }
        if (produtoExistente.getQuantidadeEmEstoque() < quantidade) {
            throw new IllegalArgumentException("quantidade em estoque insuficiente");
        }

        pedidoExistente.getItens().
    }
}
