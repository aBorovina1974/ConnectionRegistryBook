import { TestBed, inject } from '@angular/core/testing';

import { EditRequestResolverService } from './edit-request-resolver.service';

describe('EditRequestResolverService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditRequestResolverService]
    });
  });

  it('should be created', inject([EditRequestResolverService], (service: EditRequestResolverService) => {
    expect(service).toBeTruthy();
  }));
});
