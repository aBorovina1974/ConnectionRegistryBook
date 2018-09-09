import { RequestsRoutingModule } from './requests-routing.module';

describe('RequestsRoutingModule', () => {
  let requestsRoutingModule: RequestsRoutingModule;

  beforeEach(() => {
    requestsRoutingModule = new RequestsRoutingModule();
  });

  it('should create an instance', () => {
    expect(requestsRoutingModule).toBeTruthy();
  });
});
