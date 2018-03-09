import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NidformComponent } from './nidform.component';

describe('NidformComponent', () => {
  let component: NidformComponent;
  let fixture: ComponentFixture<NidformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NidformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NidformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
