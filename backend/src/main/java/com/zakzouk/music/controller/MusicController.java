package com.zakzouk.music.controller;

import com.zakzouk.music.domain.Track;
import com.zakzouk.music.service.SuggestedTracksService;
import com.zakzouk.music.service.TopTrackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@RestController()
@RequestMapping("/api/music")
@AllArgsConstructor
public class MusicController {

    private TopTrackService topTrackService;
    private SuggestedTracksService suggestedTracksService;

    @GetMapping(value = "/top/track")
    public Track getTopTrackInTheRegion(@RequestParam String country) {
        return topTrackService.getTopTrackBasedOnCountry(country);
    }

    @GetMapping(value = "/suggested/tracks")
    public List<Track> getSuggestedTracksBasedOnArtist(String artistName, String trackName) {
        return suggestedTracksService.getSuggestedTracksBasedOnArtist(artistName, trackName);
    }

}
