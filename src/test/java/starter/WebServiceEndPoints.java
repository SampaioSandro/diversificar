package starter;

public enum WebServiceEndPoints {
    STATUS("https://ecs.api-hml.brasilprev.com.br/themis-lgpd-service/health"),
    VALIDAMATRICULA("https://ecs.api-hml.brasilprev.com.br/investimento-service/diversificacao/v1/valida-matricula"),
    TRADE("http://localhost:8080/api/trade");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
