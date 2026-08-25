package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;

import java.io.IOException;

public class ListarAbrigoCommand implements Command {
    @Override
    public void executar() {
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        AbrigoService abrigoService = new AbrigoService(client);
        try {
            abrigoService.listarAbrigo();
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());;
        }

    }
}
