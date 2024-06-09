package br.com.alura.desafios.curso3.modelo;

public record EnderecoViaCEP(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
        ) {
}
