package br.com.cpet.backend.controllers;

import br.com.cpet.backend.dtos.request.FaqDTO;
import br.com.cpet.backend.entities.Faq;
import br.com.cpet.backend.services.FaqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faq")
@Tag(name = "FAQ", description = "Gerenciamento de perguntas frequentes e suporte ao usuário.")
public class FaqController {

    private final FaqService faqService;

    @Operation(summary = "Listar todas as FAQs", description = "Recupera a lista completa de perguntas e respostas cadastradas no sistema.")
    @GetMapping
    public ResponseEntity<List<Faq>> getFaqs() {
        return ResponseEntity.ok(faqService.getFaqs());
    }

    @Operation(summary = "Registrar nova FAQ", description = "Cadastra uma nova pergunta frequente com sua respectiva resposta no banco de dados.")
    @PostMapping
    public ResponseEntity<String> registrarFaq(@RequestBody FaqDTO faqDTO) {
        return ResponseEntity.ok(faqService.registrarFaq(faqDTO));
    }
}