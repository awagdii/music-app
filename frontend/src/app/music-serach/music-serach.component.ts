import {Component, OnInit} from '@angular/core';
import {Track} from '../model/track.model';
import {MusicService} from '../music.service';

@Component({
  selector: 'app-music-serach',
  templateUrl: './music-serach.component.html',
  styleUrls: ['./music-serach.component.css']
})
export class MusicSerachComponent implements OnInit {

  constructor(private musicService: MusicService) {
    musicService.onRegionChanged.subscribe(
      (track: Track) => {
      });
  }

  ngOnInit() {
  }

}
