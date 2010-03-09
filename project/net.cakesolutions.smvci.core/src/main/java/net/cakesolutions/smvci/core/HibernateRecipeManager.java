package net.cakesolutions.smvci.core;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import net.cakesolutions.smvci.api.RecipeManager;
import net.cakesolutions.smvci.domain.Recipe;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

@Service("recipeManager")
public class HibernateRecipeManager implements RecipeManager {
	private final HibernateTemplate hibernateTemplate;

	@Autowired
	public HibernateRecipeManager(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> findTop(final int howMany) {
		return this.hibernateTemplate.executeFind(new HibernateCallback<List<Recipe>>() {

			@Override
			public List<Recipe> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria select = session.createCriteria(Recipe.class);
				select.addOrder(Order.asc("name"));
				select.setMaxResults(howMany);
				return select.list();
			}
		});
	}

	@Override
	public <T> T get(Class<T> entity, Serializable id) {
		return this.hibernateTemplate.get(entity, id);
	}

	@Override
	public void save(Object entity) {
		this.hibernateTemplate.saveOrUpdate(entity);
	}
}
