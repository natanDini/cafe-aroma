package br.com.cpet.backend.services;

import br.com.cpet.backend.dtos.response.ProdutoDTO;
import br.com.cpet.backend.entities.Produto;
import br.com.cpet.backend.repositories.ProdutoRepository;
import br.com.cpet.backend.utilities.ImagemUtil;
import br.com.cpet.backend.utilities.MoedaUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getProdutosByCategoriaId(Long categoriaId) throws Exception {

        List<Produto> produtos = produtoRepository.findAllByCategoriaId(categoriaId);

        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        for (Produto produto : produtos) {

            String base64Image = ImagemUtil.converterImagemParaBase64(produto.getImagem());

            produtosDTO.add(ProdutoDTO.builder()
                            .nome(produto.getNome())
                            .preco(MoedaUtil.formatarParaReal(produto.getPreco()))
                            .descricao(produto.getDescricao())
                            .imagem(base64Image)
                    .build());
        }

        return produtosDTO;
    }
}