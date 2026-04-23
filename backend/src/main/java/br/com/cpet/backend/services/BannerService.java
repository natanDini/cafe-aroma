package br.com.cpet.backend.services;

import br.com.cpet.backend.dtos.response.BannerDTO;
import br.com.cpet.backend.entities.Banner;
import br.com.cpet.backend.repositories.BannerRepository;
import br.com.cpet.backend.utilities.ImagemUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;

    public BannerDTO getBanner() throws Exception {

        Banner banner = bannerRepository.findById(1L).orElseThrow(() -> new Exception("Banner informado não encontrado."));

        String base64Image = ImagemUtil.converterImagemParaBase64(banner.getLogo());

        return BannerDTO.builder()
                .titulo(banner.getTitulo())
                .subtitulo(banner.getSubtitulo())
                .logo(base64Image)
                .build();
    }
}