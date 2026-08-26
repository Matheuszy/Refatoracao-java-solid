package br.com.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Pet;
import br.com.alura.service.PetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PetServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private PetService petService = new PetService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Pet pet = new Pet("Pet Teste", "Cachorro", "salsicha", 5, "marrom", 5.0f);

    @Test
    public void deveListarPetsDoAbrigo() throws IOException, InterruptedException {
        String jsonRetorno = """
                    [
                        {
                            "id": 1,
                            "tipo": "Pet Teste",
                            "nome": "Cachorro",
                            "raca": "salsicha",
                            "idade": 5,
                            "cor": "marrom",
                            "peso": 5.0
                        }
                    ]
                    """;

        String expected = "Pets cadastrados:\n1 - Pet Teste - Cachorro - salsicha - 5 ano(s)";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        when(response.body()).thenReturn(jsonRetorno);
        when(client.dispararRequisicaoGet(any())).thenReturn(response);

        petService.listarPetsDoAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());

        Assertions.assertEquals(expected, lines[0]);
        Assertions.assertEquals(expected, lines[1]);
    }

}
