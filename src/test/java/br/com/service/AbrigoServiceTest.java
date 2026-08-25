package br.com.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.Abrigo;
import br.com.alura.service.AbrigoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

        private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
        private AbrigoService service = new AbrigoService(client);
        private HttpResponse <String> response = mock(HttpResponse.class);
        private Abrigo abrigo = new Abrigo("Abrigo Teste", "123456789", "teste@teste.com");

        @Test
        public void deveListarAbrigos() throws IOException, InterruptedException {
            String jsonRetorno = """
                    [
                        {
                            "id": 1,
                            "nome": "Abrigo Teste",
                            "telefone": "123456789",
                            "endereco": "Rua Teste, 123"
                        }
                    ]
                    """;

            String expectedResponse = "Abrigos cadastrados:";
            String expectedId = "1 - Abrigo Teste";


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);


            when(response.body()).thenReturn(jsonRetorno);
            when(client.dispararRequisicaoGet(any())).thenReturn(response);


            service.listarAbrigo();


            String[] lines = baos.toString().split(System.lineSeparator());

            Assertions.assertEquals(expectedResponse, lines[0]);
            Assertions.assertEquals(expectedId, lines[1]);

    }
}
