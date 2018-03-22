import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarDetailsComponent } from './vehicle-details.component';

describe('CarDetailsComponent', () => {
  let component: CarDetailsComponent;
  let fixture: ComponentFixture<CarDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
