import {Component, OnInit} from '@angular/core';
import {Track} from '../../model/track.model';
import {MusicService} from '../../music.service';

@Component({
  selector: 'app-suggested-tracks',
  templateUrl: './suggested-tracks.component.html',
  styleUrls: ['./suggested-tracks.component.css']
})
export class SuggestedTracksComponent implements OnInit {

  public tracks: Track[] = [];

  constructor(private musicService: MusicService) {

  }

  ngOnInit() {
    this.musicService.onRegionChanged.subscribe(
      (track: Track) => {
        this.musicService.getSimilerTracks(track.artist.name, track.name).subscribe((track: Track) => {
          this.tracks.push(track);
          console.log(track);
        });
      });
  }

}
