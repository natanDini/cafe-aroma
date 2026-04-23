package br.com.cpet.backend.utilities;

import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@UtilityClass
public class ImagemUtil {

    public String converterImagemParaBase64(String nomeArquivo) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("static/imagens/" + nomeArquivo);

        try (InputStream is = imgFile.getInputStream()) {
            byte[] bytes = is.readAllBytes();
            String extensao = nomeArquivo.substring(nomeArquivo.lastIndexOf(".") + 1);

            return "data:image/" + extensao + ";base64," + Base64.getEncoder().encodeToString(bytes);
        }
    }
}