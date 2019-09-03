import {BrowserModule} from '@angular/platform-browser';
import {EventEmitter, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {MusicSerachComponent} from './music-serach/music-serach.component';
import {RegionInputComponent} from './music-serach/region-input/region-input.component';
import {MusicService} from './music.service';
import { TrackInfoComponent } from './music-serach/track-info/track-info.component';
import {SuggestedTracksComponent} from './music-serach/suggested-tracks/suggested-tracks.component';
import {ToastrService} from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    MusicSerachComponent,
    RegionInputComponent,
    TrackInfoComponent,
    SuggestedTracksComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [MusicService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
