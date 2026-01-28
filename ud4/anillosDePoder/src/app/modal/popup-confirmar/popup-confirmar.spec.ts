import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopupConfirmar } from './popup-confirmar';

describe('PopupConfirmar', () => {
  let component: PopupConfirmar;
  let fixture: ComponentFixture<PopupConfirmar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PopupConfirmar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopupConfirmar);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
