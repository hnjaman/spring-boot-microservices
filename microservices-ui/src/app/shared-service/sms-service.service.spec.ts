import { TestBed, inject } from '@angular/core/testing';

import { SmsServiceService } from './sms-service.service';

describe('SmsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SmsServiceService]
    });
  });

  it('should be created', inject([SmsServiceService], (service: SmsServiceService) => {
    expect(service).toBeTruthy();
  }));
});
