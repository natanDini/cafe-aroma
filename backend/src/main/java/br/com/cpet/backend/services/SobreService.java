package br.com.cpet.backend.services;

import br.com.cpet.backend.dtos.response.SobreDTO;
import br.com.cpet.backend.entities.Sobre;
import br.com.cpet.backend.repositories.SobreRepository;
import br.com.cpet.backend.utilities.ImagemUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SobreService {

    private final SobreRepository sobreRepository;

    public SobreDTO getSobre() throws Exception {

        Sobre sobre = sobreRepository.findById(1L).orElseThrow(() -> new Exception("Informações sobre a empresa informado não encontrado."));

        String base64Image = ImagemUtil.converterImagemParaBase64(sobre.getImagem());

        return SobreDTO.builder()
                .historia(sobre.getHistoria())
                .valores(sobre.getValores())
                .equipe(sobre.getEquipe())
                .imagem(base64Image)
                .build();
    }
}