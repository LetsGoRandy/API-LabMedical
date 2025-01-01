# Lab Medical API


O LabMedical é uma API desenvolvida como parte da avaliação do módulo 2 do curso FullStack oferecido pelo SESI/SENAI, 
que oferece diversos Endpoints para gerenciar um software gestão de atendimentos médicos nos hospitais da Rede LABMedicine.

## Tecnologias utilizadas

Java 17

Spring Boot 3.3.4

Spring Data JPA

Spring Web

Spring Validation

Lombok

PostgreSQL

## Funcionalidades

Estatísticas: Visualização das estaísticas sobre medicamentos e pacientes.

Gestão de Medicamentos: Criar, atualizar, listar, e Deletar

Gestão de Pacientes: Criar, atualizar, Listar, Buscar por Id e Deletar

Gestão de endereços: Criar e Listar

Gestão de Usuários: Criar e Atualizar Senha

## Configurações

1. **Clonar o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/API-LabMedication.git
   cd LABMedication
    ```
2. **Configurar o banco de dados**:

   Crie um banco de dados chamado labMedical.

   Atualize suas credenciais no arquivo application.properties.
   ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/labmedicationbd
    spring.datasource.username=seuUsuario
    spring.datasource.password=suaSenha
   ```
3. **Compile e execute o projeto**:
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

## Documentação de Uso com Postman

Para instruções detalhadas sobre como usar a API com o Postman, consulte:
https://documenter.getpostman.com/view/37241168/2sAXxP9Cxp

## Autor

Desenvolvido em 10/2024 por [Randy Gomes](https://github.com/LetsGoRandy) 
