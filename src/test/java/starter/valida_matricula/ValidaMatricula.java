package starter.valida_matricula;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.WebServiceEndPoints;
import starter.stepdefinitions.GeraMap;

import java.util.HashMap;

public class ValidaMatricula {

    private static HashMap<String, Object> dadosCSV;

    @Step("Validação de Matrículas")
    public void validaMatricula(String cenario, String httpMethod) {
        switch (httpMethod) {
            case "GET":
                dadosCSV = GeraMap.montaCenario(cenario);
                SerenityRest.given()
                        .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjYW5hbFNvbGljaXRhY2FvIjoiMiIsImlzcyI6ImJyYXNpbHByZXYuY29tLmJyIiwiY2FuYWxWZW5kYSI6IjIiLCJpYXQiOjE1NTIwNjg3ODIsImNhbmFsRGlzdHJpYnVpY2FvIjoiMSJ9.UCqrcufKjeq-8cMXStOLf07TuG5yvgtC0gwL9ZiHF5A")
                        .header("Content-Type", "application/json")
                        .when()
                        .get(WebServiceEndPoints.VALIDAMATRICULA.getUrl() + "/" + dadosCSV.get("cpf") + "/"
                                + dadosCSV.get("matricula"));
                break;
        }
    }
}
