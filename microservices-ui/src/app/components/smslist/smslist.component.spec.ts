import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmslistComponent } from './smslist.component';

describe('SmslistComponent', () => {
  let component: SmslistComponent;
  let fixture: ComponentFixture<SmslistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmslistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
