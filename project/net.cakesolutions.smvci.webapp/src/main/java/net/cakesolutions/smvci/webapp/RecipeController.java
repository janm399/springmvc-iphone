package net.cakesolutions.smvci.webapp;

import java.util.List;

import net.cakesolutions.smvci.api.RecipeManager;
import net.cakesolutions.smvci.domain.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {
	private final RecipeManager recipeManager;

	@Autowired
	public RecipeController(RecipeManager recipeManager) {
		this.recipeManager = recipeManager;
	}

	@ModelAttribute("recipes")
	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public List<Recipe> home() {
		return this.recipeManager.findTop(25);
	}

	@RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
	public String show(@PathVariable final long id, Model model) {
		model.addAttribute(this.recipeManager.get(Recipe.class, id));
		return "recipes/show";
	}

	@RequestMapping(value = "/recipes/generate", method = RequestMethod.POST)
	public String generate() {
		Recipe recipe = new Recipe();
		recipe.setName("Generated " + System.currentTimeMillis());
		recipe.setSteps("1, 2, 3... how difficult can it be?");
		recipe.setTeaser("The tastiest thing ever");
		this.recipeManager.save(recipe);
		return "redirect:/recipes.html";
	}

}
