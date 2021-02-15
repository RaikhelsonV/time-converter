package com.example.HebrewDateConverter.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class DateService {

    public String converterGregToJew(String gy, String gm, String gd) throws UnirestException {
        UriTemplate template = new UriTemplate("https://www.hebcal.com/converter?cfg=json&gy={gy}&gm={gm}&gd={gd}&g2h=1");

        Map<String, String> uriVariables = new HashMap<>();

        if (uriVariables == null) {
            throw new IllegalArgumentException();
        }

        uriVariables.put("gy", gy);
        uriVariables.put("gm", gm);
        uriVariables.put("gd", gd);

        URI expand = template.expand(uriVariables);
        System.out.println(expand);

        HttpResponse<JsonNode> response = Unirest.get(expand.toString()).header("accept", "application/json").asJson();

        return response.getBody().getObject().get("hebrew").toString();
    }
}
