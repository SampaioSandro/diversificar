package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.templates.FieldValues;
import starter.templates.MergeFrom;
import starter.trades.RecordNewTrade;
import starter.trades.TradeResponse;
import starter.valida_matricula.ValidaMatricula;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;



public class ValidaMatriculaStepDefinitions {

    public static String cenarioFixo = null;
    public static String apiMethod = null;
    public static String massaCsv = null;

    @Steps
    RecordNewTrade recordNewTrade;

    @Steps
    TradeResponse theTradeDetails;

    @Steps
    ValidaMatricula validaMatricula;

    String trade;

    @Given("eu seleciono o arquivo de massa {string}")
    public void eu_seleciono_o_arquivo_de_massa(String massa) {
        massaCsv = massa;
    }

    @When("que eu execute um {string} do servico que valida matriculas com as informacoes do {string}")
    public void que_eu_execute_um_do_servico_que_valida_matriculas_com_as_informacoes_do(String httpMethod, String cenario) {
        cenarioFixo = cenario;
        apiMethod = httpMethod;
        validaMatricula.validaMatricula(cenario, httpMethod);
    }


    @Then("o response deve ter os seguintes detalhes:")
    public void o_response_deve_ter_os_seguintes_detalhes(List<Map<String, String>> tradeDetails) {
        restAssuredThat(response -> response.statusCode(200));

        Map<String, String> expectedResponse = tradeDetails.get(0);
        Map<String, String> actualResponse = theTradeDetails.returned();

        assertThat(actualResponse).containsAllEntriesOf(expectedResponse);
    }

}
