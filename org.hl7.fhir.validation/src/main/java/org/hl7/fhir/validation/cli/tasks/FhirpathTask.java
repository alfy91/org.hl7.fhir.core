package org.hl7.fhir.validation.cli.tasks;

import java.io.PrintStream;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.EngineMode;

public class FhirpathTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "fhirpath";
  }

  @Override
  public String getDisplayName() {
    return "FHIRPath";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return cliContext.getMode() == EngineMode.FHIRPATH;
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/fhirpath.txt");
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    validationService.evaluateFhirpath(cliContext, validationEngine);
  }

}
