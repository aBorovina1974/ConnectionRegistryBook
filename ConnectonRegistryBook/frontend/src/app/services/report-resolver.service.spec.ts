import { TestBed, inject } from '@angular/core/testing';

import { ReportResolverService } from './report-resolver.service';

describe('ReportResolverService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReportResolverService]
    });
  });

  it('should be created', inject([ReportResolverService], (service: ReportResolverService) => {
    expect(service).toBeTruthy();
  }));
});
