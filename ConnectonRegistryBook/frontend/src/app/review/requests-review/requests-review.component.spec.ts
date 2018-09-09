import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestsReviewComponent } from './requests-review.component';

describe('RequestsReviewComponent', () => {
  let component: RequestsReviewComponent;
  let fixture: ComponentFixture<RequestsReviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestsReviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestsReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
