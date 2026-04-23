package br.com.cpet.backend.services;

import br.com.cpet.backend.dtos.request.ContatoDTO;
import br.com.cpet.backend.entities.Contato;
import br.com.cpet.backend.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public List<Contato> getContatos() {

        return contatoRepository.findAllByOrderByDataEnvioDesc();
    }

    public String enviarContato(ContatoDTO contatoDTO) {

        Contato contato = new Contato();

        contato.setNome(contatoDTO.nome());
        contato.setEmail(contatoDTO.email());
        contato.setMensagem(contatoDTO.mensagem());
        contato.setDataEnvio(LocalDateTime.now());

        contatoRepository.save(contato);

        return "Contato enviado com sucesso!";
    }
}