package com.fag.infra.celcoin;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.repositories.IBassRepository;
import com.fag.utils.JsonUtils;


public class CelcoinBassRepositorory implements IBassRepository {

    
    

    @Override
    public String consultarBoleto(String linhaDigitada)throws Exception  {
        
        //     System.out.println("Consultando boleto " + linhaDigitada + " na celcoin");
        //     Map <String, Object> json = JsonUtils.srtToMap(genToken());
        //     String token = json.get("access_token").toString();
        
        //     String payLoad = "{\r\n" + //
        //                         "  \"barCode\": {\r\n" + //
        //                         "    \"type\": 0,\r\n" + //
        //                         "    \"digitable\": \""+linhaDigitada+"\"\r\n" + //
        //                         "  }\r\n" + //
        //                         "}";
        // HttpClient client = HttpClient.newHttpClient();
        // URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");
        // HttpRequest request = HttpRequest.newBuilder(uri).header("Content-type", "application/json").header("Authorization", "bearer "+token).header("accept", "application/json").POST(BodyPublishers.ofString(payLoad)).build();
        // HttpResponse <String> response = client.send(request, BodyHandlers.ofString());
        // return response.body();
        Map<String, Object> json = JsonUtils.srtToMap(genToken());
        String token = json.get("access_token").toString();
        HttpClient client = HttpClient.newHttpClient();

        String payLoad = "{\r\n" + //
                "  \"barCode\": {\r\n" + //
                "    \"type\": 0,\r\n" + //
                "    \"digitable\": \"" + linhaDigitada + "\"\r\n" + //
                "  }\r\n" + //
                "}";

        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

        HttpRequest request = HttpRequest.newBuilder(uri).header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token).header("accept", "application/json")
                .POST(BodyPublishers.ofString(payLoad)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();

    
    }
    
    
        public static String genToken() throws Exception {
            HttpClient client = HttpClient.newHttpClient();

            URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");
            String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8) +
                    "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8) +
                    "&client_secret=" + URLEncoder.encode(
                            "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8);
    
            HttpRequest request = HttpRequest.newBuilder(uri).header("Content-type", "application/x-www-form-urlencoded")
                    .POST(BodyPublishers.ofString(params)).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    
            return response.body();
    }

    

    @Override
    public String pagarBoleto(BankslipDTO dadosBoletoConsultado) throws Exception {

        Map<String, Object> json = JsonUtils.srtToMap(genToken());
        String token = json.get("access_token").toString();
        HttpClient client = HttpClient.newHttpClient();

        String payLoad = "{\n" + //
                        "  \"cpfCnpj\": \"24602516025\",\n" + //
                        "  \"billData\": {\n" + //
                        "    \"value\": 688.6,\n" + //
                        "    \"originalValue\": 0,\n" + //
                        "    \"valueWithDiscount\": 0,\n" + //
                        "    \"valueWithAdditional\": 0\n" + //
                        "  },\n" + //
                        "  \"barCode\": {\n" + //
                        "    \"type\": 0,\n" + //
                        "    \"digitable\": \""+dadosBoletoConsultado.getBarcode()+"\"\n" + //
                        "  },\n" + //
                        "  \"dueDate\": \"2021-05-25T00:00:00Z\",\n" + //
                        "  \"transactionIdAuthorize\": "+dadosBoletoConsultado.getTransactionId()+"\n" + //
                        "}";

        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments");

        HttpRequest request = HttpRequest.newBuilder(uri).header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token).header("accept", "application/json")
                .POST(BodyPublishers.ofString(payLoad)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
        // try {
        //     System.out.println("Pagando boleto " + dadosBoletoConsultado + " na celcoin");
            
        // } catch (Exception e) {
        //     throw new RuntimeException("Erro ao consultar boleto");
        // }

        // return "";
    }

    


    @Override
    public String gerarQRCode(Double dadosPix)throws Exception {
        Map<String, Object> json = JsonUtils.srtToMap(genToken());
        String token = json.get("access_token").toString();
       
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(BodyPublishers.ofString("{\n" + //
                        "  \"key\": \"testepix@celcoin.com.br\",\n" + //
                        "  \"amount\": "+dadosPix+",\n" + //
                        "  \"merchant\": {\n" + //
                        "    \"postalCode\": \"01201005\",\n" + //
                        "    \"city\": \"Barueri\",\n" + //
                        "    \"merchantCategoryCode\": 0,\n" + //
                        "    \"name\": \"Celcoin Pagamentos\"\n" + //
                        "  }\n" + //
                        "}"))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    }
    

    
}
