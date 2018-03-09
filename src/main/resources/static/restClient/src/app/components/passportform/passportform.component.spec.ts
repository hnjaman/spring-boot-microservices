import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassportformComponent } from './passportform.component';

describe('PassportformComponent', () => {
  let component: PassportformComponent;
  let fixture: ComponentFixture<PassportformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassportformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassportformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
