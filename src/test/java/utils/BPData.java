package utils;

import starter.stepdefinitions.ValidaMatriculaStepDefinitions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BPData {

    public static String currentDir = System.getProperty("user.dir");
    public static String[] values;
    public static String[] cabecalhocsv;

    public static HashMap<String, Object> searchCsvLine(String cenario) throws IOException {
        String line;
        Boolean achou = false;
        BufferedReader br = null;
        HashMap<String, Object> hash_map = new HashMap<String, Object>();
        String file = currentDir + "/data/diversificacao/" + ValidaMatriculaStepDefinitions.massaCsv + ".csv";
        br = new BufferedReader(new FileReader(file));
        if ((line = br.readLine()) != null) {
            if (line.contains("page")) {
                cabecalhocsv = line.split(";");
            }
        }
        while ((line = br.readLine()) != null && !achou) {
            values = line.split(";");
            if (values[1].equals(cenario)) {
                int nOfColumns = values.length;
                achou = true;
                for (int k = 0; k < nOfColumns; k++) {
                    hash_map.put(cabecalhocsv[k], values[k]);
                    System.out.println(k + " - " + cabecalhocsv[k] + " - " + values[k]);
                }
            }
        }
        br.close();
        return hash_map;
    }
}