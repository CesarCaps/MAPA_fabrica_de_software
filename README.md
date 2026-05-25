# 📚 Gerenciador de Biblioteca - Unicesumar

Sistema Web desenvolvido como atividade acadêmica para a **Universidade Cesumar (Unicesumar)**. O objetivo do projeto é modernizar o controle de acervo da biblioteca universitária, substituindo planilhas manuais por uma aplicação funcional, segura e com interface amigável para o cadastro, listagem e exclusão de livros.

## 🚀 Funcionalidades

- **Cadastro de Livros:** Permite inserir novos títulos informando Título, Autor, Ano de Publicação e ISBN.
- **Listagem em Tempo Real:** Exibe de forma organizada e clara todos os livros salvos no acervo através de uma tabela dinâmica.
- **Exclusão Avançada:** Permite remover livros do sistema informando o ISBN (o sistema é inteligente e reconhece a exclusão mesmo se digitada com ou sem hífens/espaços).
- **Massa de Dados Inicial:** O sistema já inicia com 3 livros clássicos carregados na memória para testes imediatos (`Dom Casmurro`, `O Pequeno Príncipe` e `O Homem Mais Rico da Babilônia`).

## 🧠 Tratamento de Erros e Robustez

A aplicação foi blindada contra falhas comuns de entrada de dados:
* **Campos Vazios:** Impedimento de envios nulos ou apenas com espaços em branco tanto no Front-End quanto no Back-End.
* **Validação de ISBN:** Uso de Expressões Regulares (Regex) para garantir o padrão correto de 10 ou 13 dígitos antes do envio.
* **Segurança no Ano:** Tratamento contra falhas de digitação (letras no campo de ano) utilizando blocos `try-catch` para evitar a queda do servidor (`NumberFormatException`).
* **Suporte a Acentuação:** Configuração de encoding em `UTF-8` para garantir que títulos em português não fiquem com caracteres corrompidos.

