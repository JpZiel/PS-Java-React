package br.com.banco.application.config.handler;

import lombok.Getter;

@Getter
public enum TipoProblema {

    DADOS_INVALIDOS("/dados-invalidos", "Dados inseridos no request inválidos"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encotrado", "Recurso não encontrado"),
    TEMPO_DE_SESSAO_EXPIRADO("/tempo-expirado-sessao", "Tempo para votação excedido"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inserido inválido"),
    APLICACAO_ERRO("/aplicacao-down", "Aplicação caiu e impossibilitou alguns processamentos"),
    ERRO_NEGOCIO("/erro-servico", "Aplicação foi interrompida por erro no fluxo de negócio");

    private String uri;
    private String titulo;

    TipoProblema(String path, String titulo){
        this.uri = "https://www.banco.com.br".concat(path);
        this.titulo = titulo;
    }
}
