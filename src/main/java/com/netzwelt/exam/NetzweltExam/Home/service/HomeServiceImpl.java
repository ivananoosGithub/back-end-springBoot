package com.netzwelt.exam.NetzweltExam.Home.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netzwelt.exam.NetzweltExam.Territory.Territory;
import com.netzwelt.exam.NetzweltExam.Territory.TerritoryResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final RestTemplate restTemplate;

    public HomeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Territory> getTerritoryHierarchy() {
        try {
            String apiUrl = "https://netzwelt-devtest.azurewebsites.net/Territories/All";
            TerritoryResponse response = restTemplate.getForObject(apiUrl, TerritoryResponse.class);
            if (response != null && response.getData() != null) {
                return buildTerritoryHierarchy(response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<Territory> buildTerritoryHierarchy(List<Territory> territories) {
        List<Territory> rootTerritories = new ArrayList<>();
        for (Territory territory : territories) {
            if (territory.getParent() == null) {
                rootTerritories.add(territory);
            } else {
                Territory parent = findTerritoryById(territories, territory.getParent());
                if (parent != null) {
                    parent.addChild(territory);
                }
            }
        }
        return rootTerritories;
    }

    private Territory findTerritoryById(List<Territory> territories, String id) {
        for (Territory territory : territories) {
            if (id.equals(territory.getId())) {
                return territory;
            }
        }
        return null;
    }
}

