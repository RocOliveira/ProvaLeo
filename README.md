# 📱 Estoque App - Android

Aplicativo Android desenvolvido para controle de estoque de produtos.
Permite cadastrar produtos e visualizar uma lista com os itens.


## 🚀 Funcionalidades

### ✅ Cadastro de Produtos

* Nome do produto
* Código do produto (alfanumérico)
* Preço (em reais)
* Quantidade em estoque

### ✅ Validações

* Todos os campos são obrigatórios
* Preço deve ser:
  * Número positivo
  * Até 2 casas decimais
  * 
* Quantidade deve ser:
  * Número inteiro positivo

### ✅ Listagem de Produtos

* Exibe:
  * Nome
  * Código
  * Preço formatado em R$
    
* Atualização automática ao voltar para a tela

## 🛠️ Tecnologias Utilizadas

* Java
* Android Studio
* Room Database (persistência local)
* RecyclerView (listagem)



## 💾 Banco de Dados

O aplicativo utiliza o **Room Database** para armazenamento local.

### Entidade:

* `Product`

  * id (auto gerado)
  * nome
  * código
  * preço
  * quantidade

### DAO:

* Inserção de produtos
* Listagem de produtos ordenados por nome


## 📱 Telas do Aplicativo

### 📝 Tela de Cadastro

* Inserção dos dados do produto
* Botão para salvar
* Botão para acessar a listagem

### 📋 Tela de Listagem

* Lista de produtos cadastrados
* Exibição em cards
* Botão para voltar


## 📌 Requisitos

* Android Studio instalado
* SDK Android configurado
* Java 17+

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de:

* Praticar desenvolvimento Android com Java
* Utilizar banco de dados local com Room
* Implementar validações de formulário
* Trabalhar com navegação entre telas
* Aplicar boas práticas de organização de código

---

## 📄 Licença

Este projeto é de uso acadêmico.

---

## 👨‍💻 Autor

Desenvolvido por Rodrigo Oliveira da Cruz
