
/**
 * ComparateurWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
package org.example.www.comparateurws;
/**
 *  ComparateurWSSkeleton java skeleton for the axisService
 */
public class ComparateurWSSkeleton{


	/**
	 * Auto generated method signature
	 * 
	 * @param compareRequest 
	 * @return compareResponse 
	 */

	public org.example.www.comparateurws.CompareResponse compare
	(
			org.example.www.comparateurws.CompareRequest compareRequest
			)
	{
		CompareRequestType requestType = compareRequest.getCompareRequest();
		
		String chaine = requestType.getChaine();
		String sousChaine = requestType.getSousChaine();
		
		boolean isSubChaine = chaine.contains(sousChaine);
		
		int position = chaine.indexOf(sousChaine);
		
		CompareResponse response = new CompareResponse();
		response.setEstSousChaine(isSubChaine);
		response.setPositionSousChaine(position);
		
		return response;
	}

}
