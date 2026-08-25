package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;

import java.io.IOException;

public class importarPetsDoAbrigoCommand implements Command{
    @Override
    public void executar() {
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        PetService petService = new PetService(client);

        try {
            petService.importarPetsDoAbrigo();
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());;
        }
    }
}
