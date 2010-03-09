package net.cakesolutions.smvci.domain;

public class Recipe {
	private Long id;
	private int version;
	private String name;
	private String teaser;
	private String steps;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeaser() {
		return this.teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSteps() {
		return this.steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

}
