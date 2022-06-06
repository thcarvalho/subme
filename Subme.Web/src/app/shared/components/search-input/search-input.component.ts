import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SearchParams } from '../../classes/params/search-params';
import { SearchInputConfig } from './classes/search-input-config';

@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styleUrls: ['./search-input.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SearchInputComponent implements OnInit {
  @Input() config!: SearchInputConfig;

  params!: SearchParams[];
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private cdRef: ChangeDetectorRef
  ) {
    this.form = this.formBuilder.group({
      param: [null, [Validators.required]],
      value: [null]
    });
  }

  ngOnInit(): void {
  }

  search(): void {
    this.config.searchAction(this.form.value);
    this.cdRef.detectChanges();
  }
}
