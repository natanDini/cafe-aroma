package br.com.cpet.backend.controllers;

import br.com.cpet.backend.dtos.request.ContatoDTO;
import br.com.cpet.backend.entities.Contato;
import br.com.cpet.backend.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contato")
@Tag(name = "Contato", description = "Operações para recebimento e listagem de mensagens de contato.")
public class ContatoController {

    private final ContatoService contatoService;

    @Operation(summary = "Listar contatos", description = "Retorna a lista de todas as mensagens e registros de contato recebidos.")
    @GetMapping
    public ResponseEntity<List<Contato>> getContatos() {
        return ResponseEntity.ok(contatoService.getContatos());
    }

    @Operation(summary = "Enviar mensagem de contato", description = "Recebe e processa uma nova mensagem enviada pelo formulário de contato.")
    @PostMapping
    public ResponseEntity<String> enviarContato(@RequestBody ContatoDTO contatoDTO) {
        return ResponseEntity.ok(contatoService.enviarContato(contatoDTO));
    }
}