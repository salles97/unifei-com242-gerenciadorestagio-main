# Sistema de Gerenciamento de Atividades de Extensão

Este é um projeto desenvolvido como parte da disciplina de Sistemas Distribuídos. O objetivo principal é utilizar o Apache Kafka para o serviço de stream, utilizando a linguagem Java.

## Descrição

O projeto tem como objetivo criar um ambiente para centralizar a coordenação de estágios, de extensão e de iniciação científica da UNIFEI em uma única plataforma. Isso visa simplificar os processos e centralizar as opções de atividades disponíveis para os alunos.

## Funcionalidades

- Gerenciamento de estágios
- Gerenciamento de atividades de extensão
- Gerenciamento de iniciação científica
- Centralização das opções de atividades para os alunos

## Instalação

1. Clone o repositório: `git clone https://github.com/seu-usuario/nome-do-repositorio.git`
2. Navegue até o diretório do projeto: `cd unifei-com242-gerenciadorestagio-main`
3. Com o Docker instalado, inicie os containers necessários: `docker compose up -d`
4. Aguarde até que todos os containers estejam em execução.
5. Se você estiver utilizando uma IDE:
   - Abra o projeto na sua IDE preferida (por exemplo, IntelliJ IDEA, Eclipse).
   - Importe o projeto como um projeto Maven.
   - Execute a aplicação a partir do arquivo de inicialização principal (`GerenciadorEstagioApplication.java` ).

6. Se você estiver usando o Maven diretamente:
   - Execute o projeto utilizando sua IDE preferida ou utilizando o Maven: `mvn clean install`
