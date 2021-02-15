package starter.stepdefinitions;

import utils.BPData;

import java.io.IOException;
import java.util.HashMap;

public class GeraMap {

    public static HashMap<String, Object> linha = new HashMap<>();

    public static HashMap<String, Object> montaCenario(String cenario) {
        HashMap<String, Object> payloadMontado = new HashMap<>();
        try {
            linha = BPData.searchCsvLine(cenario);
            payloadMontado.clear();
            payloadMontado = geraMapDiversificacao();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payloadMontado;
    }

    public static HashMap<String, Object> geraMapDiversificacao() throws IOException {
        HashMap<String, Object> payLoadFinal = new HashMap<>();
        payLoadFinal.put("cpf", BPData.values[1]);
        payLoadFinal.put("matricula", BPData.values[2]);
        System.out.println("PAYLOAD INFORMAÇÃO: " + payLoadFinal);
        return payLoadFinal;
    }
}
