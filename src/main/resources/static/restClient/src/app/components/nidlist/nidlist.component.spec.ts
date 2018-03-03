import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NidlistComponent } from './nidlist.component';

describe('NidlistComponent', () => {
  let component: NidlistComponent;
  let fixture: ComponentFixture<NidlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NidlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NidlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
