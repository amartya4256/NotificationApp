import { TestBed } from '@angular/core/testing';

import { WebClientService } from './web-client.service';

describe('WebClientService', () => {
  let service: WebClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WebClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
