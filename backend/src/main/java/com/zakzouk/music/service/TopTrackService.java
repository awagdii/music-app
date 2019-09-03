package com.zakzouk.music.service;

import com.zakzouk.music.domain.Track;
import com.zakzouk.music.dto.TopTrackServiceResponse;
import com.zakzouk.music.util.Constants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TopTrackService {

    RestTemplate restTemplate;

    public TopTrackService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Track getTopTrackBasedOnCountry(String country) {
        TopTrackServiceResponse topTrackServiceResponse =
                this.restTemplate.getForObject(Constants.GET_TOP_TRACK_URL.replace("***country***", country), TopTrackServiceResponse.class);
        Track topTrack = topTrackServiceResponse.getTracks().getTrack().get(0);

        return topTrack;

    }


}
