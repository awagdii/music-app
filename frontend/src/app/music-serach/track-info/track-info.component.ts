import {Component, OnInit} from '@angular/core';
import {Track} from '../../model/track.model';
import {MusicService} from '../../music.service';

@Component({
  selector: 'app-track-info',
  templateUrl: './track-info.component.html',
  styleUrls: ['./track-info.component.css']
})
export class TrackInfoComponent implements OnInit {

  topTrack: Track;

  constructor(private musicService: MusicService) {
    musicService.onRegionChanged.subscribe(
      (track: Track) => {
        this.topTrack = track;
      });
  }


  ngOnInit() {
  }

}
