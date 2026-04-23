package br.com.cpet.backend.utilities;

import lombok.experimental.UtilityClass;

import java.text.NumberFormat;
import java.util.Locale;

@UtilityClass
public class MoedaUtil {

    private final Locale LOCALE_BR = new Locale("pt", "BR");

    public String formatarParaReal(Double valor) {

        if (valor == null) {
            return "R$ 0,00";
        }

        NumberFormat formatador = NumberFormat.getCurrencyInstance(LOCALE_BR);

        return formatador.format(valor);
    }
}