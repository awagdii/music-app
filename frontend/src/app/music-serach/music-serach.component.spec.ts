import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicSerachComponent } from './music-serach.component';

describe('MusicSerachComponent', () => {
  let component: MusicSerachComponent;
  let fixture: ComponentFixture<MusicSerachComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MusicSerachComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicSerachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
