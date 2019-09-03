import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuggestedTracksComponent } from './suggested-tracks.component';

describe('SuggestedTracksComponent', () => {
  let component: SuggestedTracksComponent;
  let fixture: ComponentFixture<SuggestedTracksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuggestedTracksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuggestedTracksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
