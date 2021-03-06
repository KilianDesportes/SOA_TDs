package org.example.www.comparateurws;

import java.rmi.RemoteException;

import org.example.www.comparateurws.ComparateurWSStub.CompareRequest;
import org.example.www.comparateurws.ComparateurWSStub.CompareResponse;
import org.example.www.comparateurws.ComparateurWSStub.CompareRequestType;

public class TestComparateur {

	public static void main(String[] args) throws RemoteException {
		
		ComparateurWSStub comparateurWS = new ComparateurWSStub();
		
		CompareRequestType requestType = new CompareRequestType();
		requestType.setChaine("aabbbccc");
		requestType.setSousChaine("bbb");
	
		CompareRequest request = new CompareRequest();
		request.setCompareRequest(requestType);
		
		CompareResponse response = comparateurWS.compare(request);
		
		System.out.println("La sous chaine se trouve � " + (response.getPositionSousChaine()+1));
	}

}
