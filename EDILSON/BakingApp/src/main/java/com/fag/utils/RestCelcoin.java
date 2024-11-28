// package com.fag.utils;

// import java.net.URI;
// import java.net.URLEncoder;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.net.http.HttpRequest.BodyPublishers;
// import java.net.http.HttpResponse.BodyHandlers;
// import java.nio.charset.StandardCharsets;


// public class RestCelcoin {
   
    
//     public static String genToken()throws Exception{

//         HttpClient client = HttpClient.newHttpClient();

//         URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");
//         String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8) +
//         "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8)+
//         "&client_secret=" + URLEncoder.encode("e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8) ;

//         HttpRequest request = HttpRequest.newBuilder(uri).header("Content-type", "application/x-www-form-urlencoded").POST(BodyPublishers.ofString(params)).build();

//         HttpResponse <String> response = client.send(request, BodyHandlers.ofString());


//         return response.body();
//     }

    
// }
