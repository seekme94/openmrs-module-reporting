/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.cohort.definition.evaluator;

import java.util.Date;

import org.openmrs.Cohort;
import org.openmrs.annotation.Handler;
import org.openmrs.api.PatientSetService;
import org.openmrs.api.context.Context;
import org.openmrs.module.cohort.definition.CohortDefinition;
import org.openmrs.module.cohort.definition.DrugsCompletedCohortDefinition;
import org.openmrs.module.cohort.definition.ProgramStateCohortDefinition;
import org.openmrs.module.cohort.definition.ProgramsStartedCohortDefinition;
import org.openmrs.module.cohort.query.service.CohortQueryService;
import org.openmrs.module.evaluation.EvaluationContext;

/**
 * Evaluates an ProgramStateCohortDefinition and produces a Cohort
 */
@Handler(supports={ProgramsStartedCohortDefinition.class})
public class ProgramsStartedCohortDefinitionEvaluator implements CohortDefinitionEvaluator {

	/**
	 * Default Constructor
	 */
	public ProgramsStartedCohortDefinitionEvaluator() {}
	
	/**
     * @see CohortDefinitionEvaluator#evaluateCohort(CohortDefinition, EvaluationContext)
     */
    public Cohort evaluate(CohortDefinition cohortDefinition, EvaluationContext context) {
    	ProgramsStartedCohortDefinition definition = (ProgramsStartedCohortDefinition) cohortDefinition;
		
    	return Context.getService(CohortQueryService.class).getPatientsHavingStartedPrograms(
    			definition.getPrograms(), 
    			definition.getStartedOnOrAfter(), 
    			definition.getStartedOnOrBefore());
		
    }
}