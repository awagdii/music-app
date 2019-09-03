package com.zakzouk.music.controller;

import com.zakzouk.music.domain.Track;
import com.zakzouk.music.service.SuggestedTracksService;
import com.zakzouk.music.service.TopTrackService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.*;

public class MusicControllerTest {

    private static final String UNITED_STATES = "United States";
    private static final String TRACK_NAME = "Track Name";
    private static final String ARTIST_NAME = "Artist Name";
    private MusicController musicController;

    private TopTrackService topTrackService = mock(TopTrackService.class);
    private SuggestedTracksService suggestedTracksService = mock(SuggestedTracksService.class);


    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() {
        musicController = new MusicController(topTrackService, suggestedTracksService);
    }

    @Test
    public void givenCountryNameWhenCallGetTopTrackInTheRegionThenReturnTrack() {
        //Arrange
        Track track = new Track();
        track.setName(TRACK_NAME);
        when(topTrackService.getTopTrackBasedOnCountry(UNITED_STATES)).thenReturn(track);
        //Act
        Track actual = musicController.getTopTrackInTheRegion(UNITED_STATES);
        //Assert
        collector.checkThat(track, equalTo(track));
        verify(topTrackService).getTopTrackBasedOnCountry(UNITED_STATES);
    }

    @Test
    public void givenTrackAndArtistNameWhenCallGetSuggestedTracksBasedOnArtistThenReturnTrackList() {
        //Arrange
        Track track = new Track();
        track.setName(TRACK_NAME);
        List<Track> trackList = Collections.singletonList(track);
        when(suggestedTracksService.getSuggestedTracksBasedOnArtist(TRACK_NAME, ARTIST_NAME)).thenReturn(trackList);
        //Act

        List<Track> actual = musicController.getSuggestedTracksBasedOnArtist(TRACK_NAME, ARTIST_NAME);
        //Assert
        collector.checkThat(actual.size(), equalTo(1));
        collector.checkThat(actual, equalTo(trackList));
        collector.checkThat(actual.get(0), equalTo(track));
        verify(suggestedTracksService).getSuggestedTracksBasedOnArtist(TRACK_NAME, ARTIST_NAME);
    }

}