package br.com.platformbuilders.cadastroclientes.controller;

import static org.assertj.core.internal.bytebuddy.utility.RandomString.make;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.platformbuilders.cadastroclientes.model.Usuario;

/*
 * Testes com MockMvc (Spring Boot Test)...
 */
@SuppressWarnings("deprecation")
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    public void dadoCadastrar_quandoEmailInexistente_entaoCadastrarUsuario() throws Exception {

        final var json = new Usuario(1L, make(), make());

        mockMvc.perform(post("/usuario")
                       .contentType(APPLICATION_JSON)
                       .content(objectMapper.writeValueAsString(json)))
                       .andExpect(status().isOk());

    }

}