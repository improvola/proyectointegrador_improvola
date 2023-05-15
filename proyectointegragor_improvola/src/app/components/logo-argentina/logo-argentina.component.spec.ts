import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoArgentinaComponent } from './logo-argentina.component';

describe('LogoArgentinaComponent', () => {
  let component: LogoArgentinaComponent;
  let fixture: ComponentFixture<LogoArgentinaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LogoArgentinaComponent]
    });
    fixture = TestBed.createComponent(LogoArgentinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
