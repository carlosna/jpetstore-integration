package org.mybatis.jpetstore.facades;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.logging.Logger;
/**
 * Session Bean implementation class ProductBean
 */
@Stateless
@LocalBean
public class ProductBean implements ProductLocal {
	 
	@PersistenceContext
	private EntityManager em;

    public ProductBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Product> getProducts() {
		return this.em.createQuery("select p from Product p order by p.categoryId", Product.class).getResultList();
	}

	@Override
	public List<Product> getProductsPaginated(Integer start, Integer max) {
		long count = (long) em.createQuery("select count(p.productId) from Product p").getSingleResult();
		int maxPageNumber = (int) (( count / max ) + 1);
		
		if(start >= maxPageNumber) {
			start = maxPageNumber;
		}
		
		return this.em.createQuery("select p from Product p order by p.categoryId", Product.class)
				.setFirstResult( (start -1) * max)
				.setMaxResults(max)
				.getResultList();

	}

}
