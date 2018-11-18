import { TestBed, inject } from '@angular/core/testing';

import { SmsService } from './sms.service';

describe('SmsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SmsService]
    });
  });

  it('should be created', inject([SmsService], (service: SmsService) => {
    expect(service).toBeTruthy();
  }));
});
