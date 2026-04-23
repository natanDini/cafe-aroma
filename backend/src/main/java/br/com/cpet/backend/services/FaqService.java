package br.com.cpet.backend.services;

import br.com.cpet.backend.dtos.request.FaqDTO;
import br.com.cpet.backend.entities.Faq;
import br.com.cpet.backend.repositories.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public List<Faq> getFaqs(){

        return faqRepository.findAll();
    }

    public String registrarFaq(FaqDTO faqDTO) {

        Faq faq = new Faq();

        faq.setPergunta(faqDTO.pergunta());
        faq.setResposta(faqDTO.resposta());

        faqRepository.save(faq);

        return  "FAQ registrado com sucesso!";
    }
}