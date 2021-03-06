import { Component, OnInit, Input, ViewChild, Injectable } from '@angular/core';

import { Field } from '../models/field.model';
import { DocumentDefinition } from '../models/document.definition.model';
import { MappingModel } from '../models/mapping.model';
import { TransitionModel, TransitionMode, TransitionDelimiter } from '../models/transition.model';
import { MappingDefinition } from '../models/mapping.definition.model';
import { ConfigModel } from '../models/config.model';

import { MappingManagementService } from '../services/mapping.management.service';
import { DocumentManagementService } from '../services/document.management.service';
import { ErrorHandlerService } from '../services/error.handler.service';

import { DocumentDefinitionComponent } from './document.definition.component';
import { MappingDetailComponent } from './mapping.detail.component';
import { ModalWindowComponent } from './modal.window.component';
import { DataMapperErrorComponent } from './data.mapper.error.component';
import { TransitionSelectionComponent } from './transition.selection.component';
import { LineMachineComponent } from './line.machine.component';
import { DocumentFieldDetailComponent } from './document.field.detail.component';
import { MappingSelectionComponent } from './mapping.selection.component';
import { ToolbarComponent } from './toolbar.component';

@Component({
  selector: 'data-mapper',
  template: `
  	<toolbar [buttonClickedHandler]="buttonClickedHandler" #toolbarComponent [cfg]="cfg"></toolbar>
  	<div style='height:100%; position:relative;'>
  		<div class="row"><data-mapper-error #errorPanel [errorService]="cfg.errorService"></data-mapper-error></div>
  		<div class="row"><div class="col-md-12"><modal-window #modalWindow></modal-window></div></div>
  		<div class="row" style='height:100%; position:relative;'>
	  		<div class="col-md-9" style='height:100%; padding:0;'>  		
	  			<div style="float:left; width:40%; padding-left:10px; height:100%;">
		  			<document-definition #docDefInput [cfg]="cfg"
		  				[docDef]="cfg.inputDoc" [lineMachine]="lineMachine"></document-definition>
		  		</div>
		  		<div style="float:left; width:20%; height:100%; margin-left:-5px; margin-right:-5px;">
		  			<line-machine #lineMachine [cfg]="cfg" 
		  				[docDefInput]="docDefInput" [docDefOutput]="docDefOutput"></line-machine>
		  		</div>
		  		<div style="float:left; width:40%; height:100%;">
		  			<document-definition #docDefOutput [cfg]="cfg"
		  				[docDef]="cfg.outputDoc" [lineMachine]="lineMachine"></document-definition>
		  		</div>
		  		<div style="clear:both; height:0px; display:none;">&nbsp;</div>
		  	</div>
		  	<div class="col-md-3" style="padding:0px; height:100%;">
		  		<mapping-detail #mappingDetailComponent [cfg]="cfg"></mapping-detail>
		  	</div>
		 </div>
  	</div>
  `
})

export class DataMapperAppComponent implements OnInit {

	@Input() cfg:ConfigModel;

	@ViewChild('lineMachine')
  	private lineMachine: LineMachineComponent;

	@ViewChild('errorPanel')
  	private errorPanel: DataMapperErrorComponent;

  	@ViewChild('modalWindow')
  	private modalWindow: ModalWindowComponent;

	@ViewChild('docDefInput')
  	private docDefInput: DocumentDefinitionComponent;

  	@ViewChild('docDefOutput')
  	private docDefOutput: DocumentDefinitionComponent;

  	@ViewChild('mappingDetailComponent')
  	private mappingDetailComponent: MappingDetailComponent;

  	@ViewChild('toolbarComponent')
  	private toolbarComponent: ToolbarComponent;

	ngOnInit(): void {				
		this.toolbarComponent.parentComponent = this;		
		this.mappingDetailComponent.modalWindow = this.modalWindow;

		this.cfg.mappingService.mappingSelectionRequired$.subscribe((mappings: MappingModel[]) => {
			this.selectMapping(mappings);
		});		

		this.cfg.documentService.documentsFetched$.subscribe(() => {
			this.updateFromConfig();			
		});	
	}        

	private selectMapping(mappingsForField: MappingModel[]): void {
		this.modalWindow.reset();
		this.modalWindow.parentComponent = this;
		this.modalWindow.headerText = "Select Mapping";
		this.modalWindow.nestedComponentInitializedCallback = (mw: ModalWindowComponent) => {
			var self: DataMapperAppComponent = mw.parentComponent as DataMapperAppComponent;
			var c: MappingSelectionComponent = mw.nestedComponent as MappingSelectionComponent;
			c.mappings = mappingsForField;
			c.selectedMapping = mappingsForField[0];
		};
		this.modalWindow.nestedComponentType = MappingSelectionComponent;	
		this.modalWindow.okButtonHandler = (mw: ModalWindowComponent) => {
			var self: DataMapperAppComponent = mw.parentComponent as DataMapperAppComponent;
			var c: MappingSelectionComponent = mw.nestedComponent as MappingSelectionComponent;
			var mapping: MappingModel = c.selectedMapping;
			self.cfg.mappingService.selectMapping(mapping, false);
		};
		this.modalWindow.cancelButtonHandler = (mw: ModalWindowComponent) => {
			var self: DataMapperAppComponent = mw.parentComponent as DataMapperAppComponent;	
			self.cfg.mappingService.selectMapping(null, false);
		};
		this.modalWindow.show();
	}	

	public updateFromConfig(): void {
		this.lineMachine.updateHeight();
		this.mappingDetailComponent.updateHeight();
		
		// update the mapping line drawing after our fields have redrawn themselves
        // without this, the x/y from the field dom elements is messed up / misaligned.
        setTimeout(()=> { this.lineMachine.redrawLinesForMappings(); }, 1);        
	}

	public buttonClickedHandler(action: string, component: ToolbarComponent): void {
		var self = component.parentComponent as DataMapperAppComponent;
		if ("showDetails" == action) {
			if (self.cfg.mappings.activeMapping == null) {
				console.log("Creating new mapping.")
				this.cfg.mappingService.deselectMapping();
				this.cfg.mappings.activeMapping = this.cfg.mappingService.createMapping();
				this.cfg.mappingService.notifyActiveMappingUpdated(true);
			}
			self.cfg.showMappingDetailTray = !self.cfg.showMappingDetailTray;
		} else if ("showLines" == action) {
			self.cfg.showLinesAlways = !self.cfg.showLinesAlways;
			self.lineMachine.redrawLinesForMappings();
		}
	}
}
