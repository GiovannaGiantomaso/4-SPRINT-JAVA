# Challenge-JAVA
## OdontoPrev - Sistema de Gestão Odontológica

## Sobre o Projeto

O OdontoPrev é um sistema web desenvolvido para facilitar o gerenciamento de clínicas odontológicas, permitindo o controle eficiente de pacientes, tratamentos e auditorias. O sistema foi criado como parte de um desafio acadêmico, visando o aprimoramento das habilidades em desenvolvimento backend com Spring Boot e a construção de uma interface dinâmica com Thymeleaf.

Além de oferecer uma plataforma organizada e intuitiva para gestão odontológica, o OdontoPrev também incorpora recursos de segurança, auditoria, mensageria assíncrona com RabbitMQ e geração de relatórios, garantindo maior transparência e confiabilidade nos processos no geral.

Um grande diferencial do projeto é a integração com Spring AI, que permite ao usuário realizar perguntas diretamente dentro do sistema e receber respostas automáticas através de um chat inteligente integrado com IA da OpenAI, promovendo uma experiência interativa e enriquecedora.

### Principais Funcionalidades

* Autenticação e autorização via Spring Security
* Gerenciamento de pacientes e tratamentos odontológicos
* Registros de auditoria para controle de alterações no banco de dados
* Relatórios detalhados de gastos e tratamentos de cada paciente
* Suporte a internacionalização (i18n) com mensagens em Português, Inglês e Espanhol
* Mensageria assíncrona com RabbitMQ (para Pacientes e Tratamentos)
* Banco de Dados Oracle com Procedures e Triggers para segurança e auditoria
* Chat com IA integrado com Spring AI, permitindo perguntas/respostas no sistema

## Equipe de Desenvolvimento

* Giovanna Lima | RM553369
* Rebeca Lopes | RM553764
* Felipe Arcanjo | RM554018

## LINK DO VÍDEO

https://youtu.be/0BF4E6JazVA

## Tecnologias Utilizadas

### Backend:

* Java 17
* Spring Boot 3.4.3
* Spring Security
* Spring Data JPA
* Spring Boot Actuator
* RabbitMQ
* Spring AI

### Frontend:

* Thymeleaf (Template Engine para renderização de páginas dinâmicas)
* Bootstrap & CSS (Estilização da interface)

### Banco de Dados:

* Oracle Database
* Stored Procedures e Triggers (Gerenciamento de auditoria e relatórios)

### Ferramentas Auxiliares:

* GitHub
* Maven

## Como Clonar e Executar o Projeto

### Clonar o repositório

Abra o terminal ou Git Bash e execute:

git clone https://github.com/GiovannaGiantomaso/CHALLENGE-4-JAVA.git

cd CHALLENGE-4-JAVA

### Comece iniciando a aplicação com:
Acesse: http://localhost:8080

**Antes de iniciar a aplicação, certifique-se de que o RabbitMQ esteja instalado e em execução localmente.**

#### Para garantir o funcionamento da mensageria com RabbitMQ:

Passos para instalação local (Windows):
1. Instale o **Erlang OTP**: https://www.erlang.org/downloads  
2. Instale o **RabbitMQ Server**: https://www.rabbitmq.com/install-windows.html  
3. Após a instalação, abra o `services.msc` e **inicie o serviço RabbitMQ**.

Verifique se o RabbitMQ está rodando:
- Acesse o painel de gerenciamento (se habilitado): http://localhost:15672  
  - Usuário: `guest` | Senha: `guest`
- Confirme se a porta `5672` está ativa

### Rotas da Aplicação:

Login: http://localhost:8080/login

Registrar:http://localhost:8080/register

Página principal: http://localhost:8080/principal

### Perguntar para AI
http://localhost:8080/ai/form

### Gerenciamento de Pacientes

Página de gerenciamento: http://localhost:8080/pacientes

Cadastrar paciente: http://localhost:8080/pacientes/cadastrar

Listar pacientes: http://localhost:8080/pacientes/listar

Editar paciente: http://localhost:8080/pacientes/editar/{id}

### Gerenciamento de Tratamentos

Página de Tratamentos: http://localhost:8080/tratamentos

Cadastrar tratamento: http://localhost:8080/tratamentos/cadastrar

Listar tratamento: http://localhost:8080/tratamentos/listar

Editar tratamento: http://localhost:8080/tratamentos/editar/{id}

### Relatórios

Relatorio dos pacientes e seus tratamentos: http://localhost:8080/relatorios/pacientes-tratamentos

Relatorio dos pacientes e seus gastos: http://localhost:8080/relatorios/gastos-pacientes

### Auditoria

Registros da tabela Auditoria: http://localhost:8080/auditoria

## Monitoramento com Spring Boot Actuator

O projeto implementa monitoramento interno utilizando o **Spring Boot Actuator**, que expõe diversos endpoints úteis para acompanhar o estado da aplicação, métricas de uso, logs, propriedades de ambiente e muito mais.

### Endpoints Disponíveis para o Spring Boot Actuator

> Base padrão: `http://localhost:8080/actuator`

| Endpoint                          | Descrição                                                                 |
|----------------------------------|---------------------------------------------------------------------------|
| `/actuator`                      | Lista todos os endpoints do Actuator.                                     |
| `/actuator/health`               | Verifica se a aplicação está saudável (`UP`, `DOWN`, etc).                |
| `/actuator/info`                 | Exibe informações da aplicação (nome, descrição, versão).                 |
| `/actuator/metrics`             | Lista todas as métricas disponíveis.                                      |
| `/actuator/metrics/{nome}`       | Detalha a métrica especificada (ex: `jvm.memory.used`).                  |
| `/actuator/env`                  | Mostra todas as variáveis de ambiente da aplicação.                      |
| `/actuator/env/{nome}`           | Exibe o valor de uma propriedade específica.                             |
| `/actuator/beans`                | Lista todos os beans do contexto Spring.                                 |
| `/actuator/mappings`             | Lista todos os endpoints da aplicação e seus mapeamentos.                |
| `/actuator/conditions`           | Mostra os beans ativados/desativados pela auto-configuração.             |
| `/actuator/configprops`          | Exibe propriedades configuradas agrupadas por classe.                    |

## Internacionalização (i18n)

O projeto implementa suporte completo à **internacionalização** utilizando o recurso `messages.properties` do Spring Boot, permitindo a tradução da interface e mensagens em diferentes idiomas.

### Idiomas disponíveis:
- 🇧🇷 Português (`messages_pt_BR.properties`)
- 🇺🇸 Inglês (`messages_en.properties`)
- 🇪🇸 Espanhol (`messages_es.properties`)

### Funcionamento:
A tradução é feita através da opção que o usuário escolher na interface.  
As mensagens são exibidas nas views Thymeleaf de forma dinâmica, sem necessidade de alterações no código Java.

### Exemplo de uso no HTML com Thymeleaf:
```html
<h1 th:text="#{msg_bem_vindo}">Bem-vindo</h1>
```

## Mensageria Assíncrona com RabbitMQ

O projeto utiliza o RabbitMQ para realizar comunicação assíncrona entre os serviços da aplicação, enviando e processando mensagens nas operações de **criação**, **atualização** e **exclusão** de dados das entidades `Paciente` e `Tratamento`.

### Filas utilizadas por entidade

#### Entidade `Paciente`:
- `paciente.create`: mensagens de pacientes recém-cadastrados  
- `paciente.update`: mensagens de pacientes atualizados  
- `paciente.delete`: mensagens de pacientes excluídos  

#### Entidade `Tratamento`:
- `tratamento.create`: mensagens de tratamentos cadastrados  
- `tratamento.update`: mensagens de tratamentos atualizados  
- `tratamento.delete`: mensagens de tratamentos excluídos  

Cada ação envia uma mensagem JSON para a fila apropriada. Os consumidores escutam essas filas e realizam o processamento adequado, exibindo os dados no console da aplicação.

### Exemplo de saída no console:

🟢 [PACIENTE CRIADO]

ID: 96

Nome: TESTE PACIENTE

Email: TESTEPACI@GMAIL.COM

Telefone: 11984750909


🟡 [TRATAMENTO ATUALIZADO]

ID: 48

Descrição: Clareamento Dental

Tipo: Estético

Custo: R$ 270.0

Essas mensagens são úteis para rastreabilidade, auditoria e integração futura com outros sistemas ou microsserviços.

### Acesso ao painel do RabbitMQ:

- URL: http://localhost:15672  
- Usuário: `guest`  
- Senha: `guest`

Ao acessar o painel, é possível:
- Monitorar o tráfego nas filas
- Ver mensagens pendentes ou consumidas
- Ver como as exchanges estão roteando as mensagens para as filas corretas

### Comportamento da mensageria:

1. Uma entidade (Paciente ou Tratamento) é criada, atualizada ou excluída via interface web.  
2. O serviço correspondente envia um objeto JSON para a fila vinculada à operação.  
3. O consumidor consome a mensagem da fila, processa e exibe os dados no console em tempo real.

### Configuração no `application.properties`

```properties
# Nome da aplicação

spring.application.name=Odontoprev

# Configuração do banco Oracle

spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl

spring.datasource.username=rm553369

spring.datasource.password=120505

spring.datasource.driver-class-name=oracle.jdbc.OracleDriver


# JPA / Hibernate

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

spring.jpa.hibernate.ddl-auto=none

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true

# Inicialização de scripts SQL

spring.sql.init.mode=always

# Thymeleaf

spring.thymeleaf.cache=false

# Codificação UTF-8 para web

spring.web.encoding.charset=UTF-8

spring.web.encoding.enabled=true

spring.web.encoding.force=true

# Internacionalização

spring.messages.basename=messages

spring.web.locale=pt_BR

spring.web.locale-resolver=fixed

# Habilita métodos HTTP ocultos

spring.mvc.hiddenmethod.filter.enabled=true

# Logging para queries SQL

logging.level.org.hibernate.SQL=DEBUG

logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Spring Boot Actuator

management.endpoints.web.exposure.include=*

management.endpoint.health.show-details=always

info.app.name=Odontoprev

info.app.description=Sistema de Gerenciamento Odontológico

info.app.version=1.0.0

# informacoes personalizadas em /actuator/info

management.endpoint.info.enabled=true

management.info.env.enabled=true

management.endpoint.info.show-details=always

# Configuração do RabbitMQ

spring.rabbitmq.host=localhost

spring.rabbitmq.port=5672

spring.rabbitmq.username=guest

spring.rabbitmq.password=guest

spring.ai.openai.api-key=${TOKEN}

spring.ai.openai.chat.model=gpt-4

spring.ai.openai.base-url=https://models.inference.ai.azure.com

spring.ai.openai.chat.completions-path=/chat/completions

spring.cloud.function.enabled=false

```

### DIAGRAMA (DAR ZOOM PARA VISUALIZAR):

![diagrama-javaa](https://github.com/user-attachments/assets/4de52fbe-006d-4bf5-a670-36ab18f634ff)

