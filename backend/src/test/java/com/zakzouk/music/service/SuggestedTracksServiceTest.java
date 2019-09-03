package com.zakzouk.music.service;

import com.zakzouk.music.controller.MusicController;
import com.zakzouk.music.domain.Track;
import com.zakzouk.music.dto.SuggestedTrackResponse;
import com.zakzouk.music.dto.Tracks;
import com.zakzouk.music.util.Constants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.*;


public class SuggestedTracksServiceTest {


    private static final String TRACK_NAME = "Track Name";
    private static final String ARTIST_NAME = "Artist Name";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    private SuggestedTracksService suggestedTracksService;
    private RestTemplate restTemplate = mock(RestTemplate.class);
    private RestTemplateBuilder restTemplateBuilder = mock(RestTemplateBuilder.class);


    @Before
    public void setUp() throws Exception {
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        suggestedTracksService = new SuggestedTracksService(restTemplateBuilder);
    }

    @Test
    public void whenNewObjectCreatedThenSetRestTemplate() {
        //Act
        SuggestedTracksService actual = spy(new SuggestedTracksService(restTemplateBuilder));
        //Assert
        RestTemplate actualRestTemplate = (RestTemplate) Whitebox.getInternalState(actual, "restTemplate");
        collector.checkThat(actualRestTemplate, equalTo(restTemplate));
    }

    @Test
    public void givenTrackAndArtistNameWhenCallGetSuggestedTracksBasedOnArtistThenReturnTrackList() {
        //Arrange
        String serviceUrl = Constants.GET_SUGGESTED_TRACK_URL
                .replace("***artist***", ARTIST_NAME).replace("***track***", TRACK_NAME);
        SuggestedTrackResponse suggestedTrackResponse = spy(new SuggestedTrackResponse());
        Track track = new Track();
        track.setName(TRACK_NAME);
        List<Track> trackList = Collections.singletonList(track);
        Tracks tracks = new Tracks();
        tracks.setTrack(trackList);
        suggestedTrackResponse.setSimilartracks(tracks);

        when(restTemplate.getForObject(serviceUrl, SuggestedTrackResponse.class)).thenReturn(suggestedTrackResponse);
        //Act
        List<Track> actual = suggestedTracksService.getSuggestedTracksBasedOnArtist(ARTIST_NAME, TRACK_NAME);
        //Assert
        collector.checkThat(actual, equalTo(trackList));
        collector.checkThat(actual.get(0), equalTo(track));
        verify(restTemplate).getForObject(serviceUrl, SuggestedTrackResponse.class);
        verify(suggestedTrackResponse).getSimilartracks();
    }
}