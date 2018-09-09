import { TestBed, inject } from '@angular/core/testing';

import { ConnectionDetailsService } from './connection-details.service';

describe('ConnectionDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ConnectionDetailsService]
    });
  });

  it('should be created', inject([ConnectionDetailsService], (service: ConnectionDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
