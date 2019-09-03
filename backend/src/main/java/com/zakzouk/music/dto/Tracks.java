package com.zakzouk.music.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zakzouk.music.domain.Track;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Tracks {
    private List<Track> track;
}
