package br.com.platformbuilders.cadastroclientes.controller;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.mockMvc;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/*
 * Testes com REST-assured...
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    public void dadoCadastrar_quandoUsuarioInexistente_entaoRetorna400() {
        mockMvc(mockMvc);
        given().body(EMPTY).contentType(JSON).when().post("/cliente/{usuarioId}", 1).then().statusCode(400);
    }

}