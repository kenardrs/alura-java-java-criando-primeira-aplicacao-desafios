package br.com.alura.desafios.curso3.main;

import br.com.alura.desafios.curso3.exceptions.ConsultaViaCEPException;
import br.com.alura.desafios.curso3.services.ConsultaViaCEPService;
import br.com.alura.desafios.curso3.services.GravaArquivoService;

import java.io.IOException;
import java.util.Scanner;

public class ConsultaCEPMain {
    public static void main(String[] args) {
        var ler = new Scanner(System.in);
        var busca = "";
        var consultaViaCEPService = new ConsultaViaCEPService();
        var gravaArquivoService = new GravaArquivoService();

        while (!"sair".equalsIgnoreCase(busca)) {
            System.out.println("Informe o cep para busca");
            busca = ler.nextLine();

            if ("sair".equalsIgnoreCase(busca)) {
                break;
            }

            try {
                // Conecta api e efetua a consulta
                var endereco = consultaViaCEPService.getReposta(busca);
                gravaArquivoService.gravaArquivoJson(endereco);
            } catch(IOException | IllegalArgumentException | ConsultaViaCEPException | InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
