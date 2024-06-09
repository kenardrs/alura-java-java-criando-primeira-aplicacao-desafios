package br.com.alura.desafios.curso3.services;

import br.com.alura.desafios.curso3.exceptions.ConsultaViaCEPException;
import br.com.alura.desafios.curso3.modelo.EnderecoViaCEP;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaViaCEPService {
    private static final HttpClient client = HttpClient.newHttpClient();

    public EnderecoViaCEP getReposta(String CEP) throws IllegalArgumentException, InterruptedException, IOException {
        // Valida o cep passado para busca
        if(!CEP.toLowerCase().matches("^(sair|\\d{8})")){
            throw new IllegalArgumentException("CEP inválido, tente novamente com um cep válido!");
        }

        var req = HttpRequest.newBuilder()
                .uri(URI.create("http://viacep.com.br/ws/" + CEP + "/json/"))
                .GET()
                .build();

        try {
            var res = client.send(
                    req,
                    HttpResponse
                            .BodyHandlers
                            .ofString());
            // devolve a resposta da requisição no formato EnderencoViaCEP
            var resposta = res.body();
            if(resposta.contains("erro")){
                throw new ConsultaViaCEPException("Dados indisponiveis para este CEP");
            }
            return new Gson().fromJson(resposta, EnderecoViaCEP.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro na conexão com do serviço ViaCEP");
        }
    }
}