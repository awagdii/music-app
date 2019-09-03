import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Track} from './model/track.model';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  public onRegionChanged = new EventEmitter<Track>();

  constructor(private http: HttpClient) {
  }

  getTopTrackInRegion(country) {


    const params = new HttpParams().set('country', country);

    return this.http.get('/api/music/top/track', {params});
  }

  getSimilerTracks(artistName, trackName) {


    const params = new HttpParams().set('artistName', artistName).set('trackName', trackName);

    return this.http.get('/api/music/suggested/tracks', {params});
  }
}
