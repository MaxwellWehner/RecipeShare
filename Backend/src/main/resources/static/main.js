let recipe = document.getElementById("recipeLink");
let cookbook = document.getElementById("cookbookLink");

recipe.addEventListener("click", () => {
	returnUrl = window.location.protocol + "//" + window.location.host + "/recipes"
	location.replace(returnUrl);
})

cookbook.addEventListener("click", () => {
	returnUrl = window.location.protocol + "//" + window.location.host + "/cookbooks"
	location.replace(returnUrl);
})