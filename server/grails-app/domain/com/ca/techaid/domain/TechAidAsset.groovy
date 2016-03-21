package com.ca.techaid.domain

import grails.rest.Resource;

@Resource()
class TechAidAsset {
	
	String uniqueName
	String typeOfAsset
	Double price

    static constraints = {
		uniqueName blank:false 
		typeOfAsset blank:false   
    }
}
