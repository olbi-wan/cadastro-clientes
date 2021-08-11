![Platform Builders](https://img.shields.io/badge/Platform-Builders-yellow)
[![Build Status](https://travis-ci.com/olbi-wan/cadastro-clientes.svg?branch=main)](https://travis-ci.com/olbi-wan/cadastro-clientes)
[![codecov](https://codecov.io/gh/olbi-wan/cadastro-clientes/branch/main/graph/badge.svg?token=hVdNFsNmqN)](https://codecov.io/gh/olbi-wan/cadastro-clientes)

<p align="left">
   <img src="https://platformbuilders.io/assets/images/logo.png" width="340" alt="Platform Builders">
</p>

<p align="center">
  <i>
    <a href="#introdução">Introdução</a> •
    <a href="#instalação">Instalação</a> •
    <a href="#projeto">Projeto</a>
  <i/>
</p>

## Introdução
   
Olá novamente! Primeiramente muito obrigado pela nova oportunidade e desculpa a demora, meu notebook não ajudou muito dessa vez.
Nesse novo projeto, tentei complicar um poquinho as coisas para tentar apresentar um pouco mais. Espero que gostem.

## Instalação

* [x] abra o terminal e confirme a versão com o comando `java --version` (a versão 11 terá que estar instalada).
* [x] realize o download do [Eclipse](https://www.eclipse.org/downloads/packages).
* [x] baixe o projeto do GitHub com `git clone`.

## Projeto

Pequeno DevOps (compilação, cobertura): *[Travis CI](https://travis-ci.com/github/olbi-wan/cadastro-clientes), [Codecov](https://app.codecov.io/gh/olbi-wan/cadastro-clientes)*.
   
#### H2 Database
   
Base de dados configurada na memória.

O dashboard está disponível na URL `http://localhost:8080/h2-console`.   
   
![image](https://user-images.githubusercontent.com/50278152/128967056-36e00119-2ec2-4970-9845-afa850ca34a5.png)

#### Testes Unitários   

**Mockito**
   
```java
// ...
when(repository.findByEmail(any())).thenReturn(Optional.of(new Usuario()));

final var excecao = assertThrows(CadastroException.class, () -> usuarioBusiness.cadastrar(new Usuario()));

assertEquals("Usuário duplicado.", excecao.getMessage());
// ...
```

**MockMvc**

```java
// ...
mockMvc.perform(post("/usuario")
               .contentType(APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(json)))
               .andExpect(status().isOk());
// ...
```
   
**REST-assured**

```java
// ...
given().body(EMPTY).contentType(JSON).when().post("/cliente/{usuarioId}", 1).then().statusCode(400);
// ...
```   
