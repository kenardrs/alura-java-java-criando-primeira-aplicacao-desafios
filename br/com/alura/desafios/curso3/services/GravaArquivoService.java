package br.com.alura.desafios.curso3.services;

import br.com.alura.desafios.curso3.modelo.EnderecoViaCEP;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GravaArquivoService {
    public void gravaArquivoJson(EnderecoViaCEP endereco) throws IOException {
        try {
            var gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            var escrita = new FileWriter("endereco_" + endereco.cep() + ".json");
            escrita.write(gson.toJson(endereco));
            escrita.close();
        } catch (IOException e) {
            throw new IOException("Erro gravando o arquivo");
        }
    }
}
