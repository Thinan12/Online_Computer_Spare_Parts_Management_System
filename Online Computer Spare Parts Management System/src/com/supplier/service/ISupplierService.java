package com.supplier.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.supplier.model.Supplier;


public interface ISupplierService {


	public static final Logger log = Logger.getLogger(ISupplierService.class.getName());


	public void addSupplier(Supplier supplier);


	public Supplier getSupplierByID(String supplierID);
	

	public ArrayList<Supplier> getSuppliers();
	
	public Supplier updateSuppliers(String supplierID, Supplier supplier);

	public void removeSupplier(String supplierID);

}
