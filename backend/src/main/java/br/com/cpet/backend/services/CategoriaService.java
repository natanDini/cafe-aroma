package br.com.cpet.backend.services;

import br.com.cpet.backend.dtos.response.CategoriaDTO;
import br.com.cpet.backend.entities.Categoria;
import br.com.cpet.backend.repositories.CategoriaRepository;
import br.com.cpet.backend.utilities.ImagemUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> getCategorias() throws Exception {

        List<Categoria> categorias = categoriaRepository.findAll();

        List<CategoriaDTO> categoriasDTO = new ArrayList<>();

        for (Categoria categoria : categorias) {

            String base64Image = ImagemUtil.converterImagemParaBase64(categoria.getImagem());

            categoriasDTO.add(CategoriaDTO.builder()
                            .nome(categoria.getNome())
                            .descricao(categoria.getDescricao())
                            .imagem(base64Image)
                            .build());
        }

        return categoriasDTO;
    }

    public CategoriaDTO getCategoriaById(Long id) throws Exception {

        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new Exception("Categoria informada não encontrada."));

        String base64Image = ImagemUtil.converterImagemParaBase64(categoria.getImagem());

        return CategoriaDTO.builder()
                .nome(categoria.getNome())
                .descricao(categoria.getDescricao())
                .imagem(base64Image)
                .build();
    }
}