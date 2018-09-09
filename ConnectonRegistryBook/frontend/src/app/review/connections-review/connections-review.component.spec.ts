import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionsReviewComponent } from './connections-review.component';

describe('ConnectionsReviewComponent', () => {
  let component: ConnectionsReviewComponent;
  let fixture: ComponentFixture<ConnectionsReviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionsReviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionsReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
