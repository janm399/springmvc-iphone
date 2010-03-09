package net.cakesolutions.smvci.api;

import java.io.Serializable;
import java.util.List;

import net.cakesolutions.smvci.domain.Recipe;

public interface RecipeManager {

	/**
	 * Finds top <i>n</i> recipes, ordered by some secret algorithm (possibly ease of cooking or something equally complicated and intangible).
	 * 
	 * @param howMany how many recipes to return at most, always positive.
	 * @return the matching recipes
	 */
	List<Recipe> findTop(int howMany);

	/**
	 * Loads one entity of type {@code entity} whose identity is equal to the given {@code id}
	 * 
	 * @param entity the type of the [mapped] identity, never {@code null}.
	 * @param id the entity's identity, never {@code null}.
	 * @return the loaded entity, {@code null} if there is no such entity
	 */
	<T> T get(Class<T> entity, Serializable id);

	/**
	 * Saves the given entity
	 * 
	 * @param entity the entity to be saved, never {@code null}.
	 */
	void save(Object entity);
}
