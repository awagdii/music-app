package com.zakzouk.music.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zakzouk.music.dto.Tracks;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Track {
    String name;
    String duration;
    Integer listeners;
    String lyrics;
    Artist artist;
}
