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
package org.openmrs.module.cohort.definition;

import java.util.Date;
import java.util.List;

import org.openmrs.Program;
import org.openmrs.module.cohort.definition.configuration.ConfigurationProperty;

/**
 * 
 */
public class ProgramsStartedCohortDefinition extends BaseCohortDefinition {

    private static final long serialVersionUID = 1L;
    
	//***** PROPERTIES *****
	
	@ConfigurationProperty(required=true)
	private List<Program> programs;

	@ConfigurationProperty(required=false)
	private Date startedOnOrAfter;

	@ConfigurationProperty(required=false)
	private Date startedOnOrBefore;

	//***** CONSTRUCTORS *****

	/**
	 * Default constructor
	 */
	public ProgramsStartedCohortDefinition() {
		super();
	}
	
	//***** INSTANCE METHODS *****
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		StringBuilder ret = new StringBuilder();
		ret.append("Patients that enrolled or completed program(s).");		
		return ret.toString();
	}

	//***** PROPERTY ACCESS *****
	
    /**
     * @return the program
     */
    public List<Program> getPrograms() {
    	return programs;
    }

    /**
     * @param program the program to set
     */
    public void setPrograms(List<Program> programs) {
    	this.programs = programs;
    }

	public Date getStartedOnOrAfter() {
		return startedOnOrAfter;
	}

	public void setStartedOnOrAfter(Date startedOnOrAfter) {
		this.startedOnOrAfter = startedOnOrAfter;
	}

	public Date getStartedOnOrBefore() {
		return startedOnOrBefore;
	}

	public void setStartedOnOrBefore(Date startedOnOrBefore) {
		this.startedOnOrBefore = startedOnOrBefore;
	}    
}
