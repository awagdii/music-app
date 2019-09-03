package com.zakzouk.music.service;

import com.zakzouk.music.domain.Track;
import com.zakzouk.music.dto.SuggestedTrackResponse;
import com.zakzouk.music.dto.TopTrackServiceResponse;
import com.zakzouk.music.util.Constants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SuggestedTracksService {
    private RestTemplate restTemplate;

    public SuggestedTracksService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Track> getSuggestedTracksBasedOnArtist(String artistName, String trackName) {
        SuggestedTrackResponse suggestedTracksRespnse =
                this.restTemplate.getForObject(Constants.GET_SUGGESTED_TRACK_URL
                        .replace("***artist***", artistName).replace("***track***", trackName), SuggestedTrackResponse.class);
        return suggestedTracksRespnse.getSimilartracks().getTrack();

    }
}
