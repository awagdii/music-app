import {Component, OnInit, ɵdetectChanges} from '@angular/core';
import {MusicService} from '../../music.service';
import {Track} from '../../model/track.model';

@Component({
  selector: 'app-region-input',
  templateUrl: './region-input.component.html',
  styleUrls: ['./region-input.component.css']
})
export class RegionInputComponent implements OnInit {

  private regionName: string = null;

  constructor(private musicService: MusicService) {
  }

  ngOnInit() {
  }

  getTopTrackInRegion(event) {
    const country: string = event.target.value;
    this.musicService.getTopTrackInRegion(country).subscribe((track: Track) => {
      console.log(track);
      this.musicService.onRegionChanged.emit(track);
      this.regionName = '';
    });
  }
}
