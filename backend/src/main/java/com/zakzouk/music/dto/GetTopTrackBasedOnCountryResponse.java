package com.zakzouk.music.dto;

import com.zakzouk.music.domain.Track;
import lombok.Data;

@Data
public class GetTopTrackBasedOnCountryResponse {
    private Track topTrack;
}
