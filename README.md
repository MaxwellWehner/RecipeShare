# RecipeShare
A small app used to create and share recipes and organize them in cookbooks.

## User Stories
1. As a admin I wasnt to beable to naviagte to /admin and see all users.
   From there I want the ablity to delete any user I want.
2. As a user I want to be able to view all cookbooks from the /cookbooks page
3. As a user I want to be able to view all recipes from the /recipes page
4. As a user I want to be acle to create new recipes
5. As a user I want to be able to edit and delete recipes that I have created.
6. As a user I want to be able to create new cookbooks
7. As a user I want to be able to edit and delete cookbooks that I have created.
8. As a user I want to add and remove recipes to cookbooks that I own.
9. As a user I want to view an indepth view of a recipe
10. As a user I want to view an indepth view of a cookbook
11. As a user I want to have the ablilty to log in and out.

## A few Challenges
No major bugs happened durring development, but many minor ones. Use of stackoverflow and with the Thymeleaf and Spring docs helped a ton.

Thymleaf exaple use of Th:if and url paraters to create a form that appears on a button click and alos wont show if the user doesn't have any cookbokks
```<a th:if="${param.add == null and cookbooks.size() != 0}"
					th:href="@{?add}" class="btn btn-primary">Add to Cookbook</a>
				<div th:if="${cookbooks.size() == 0}">
					<h4>You currently have no cookbooks</h4>
					<a th:href="@{/showNewCookbookForm}" class="btn btn-primary">Create
						a bookbook</a>
				</div>
				<form th:if="${param.add}"
					th:action="@{/addToCookbook/{id}(id=${recipe.id})}" method="POST">
					<label for="cookbookId">Cookbook:</label> <select name="cookbookId"
						class="form-control" id="form_select">
						<option th:each="cookbook : ${cookbooks}"
							th:text="${cookbook.title}" th:value="${cookbook.id}"></option>
					</select>
					<div>
						<button type="submit" class="btn btn-info col-2">Add to
							Cookbook</button>
						<a th:if="${param.add}" th:href="@{/recipe/{id}(id=${recipe.id})}"
							class="btn btn-danger">Cancel</a>
					</div>
				</form>
   ``` 
        
Use of ```SecurityContextHolder.getContext().getAuthentication().getName();``` to access the logged in user to be added when a user creates a recipe or cookbook      
```	@Override
	public void saveCookbook(Cookbook cookbook) {
		// gets the logged in user and then gets the email(getName is the email);
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByEmail(email);
		cookbook.setUserId(user);
		cookbookRepository.save(cookbook);
	}
  ```
