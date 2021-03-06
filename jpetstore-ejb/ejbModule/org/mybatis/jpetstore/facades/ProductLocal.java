package org.mybatis.jpetstore.facades;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ProductLocal {

	public List<Product> getProducts();
	
	public List<Product> getProductsPaginated(Integer start, Integer max);
}
