## Functional Requirements

Before using the app, users need to create an account. During the account creation process, users need to provide information about the number of people they need to cook for in their household, their monthly budget, and whether they follow a specific diet.

The application should have a main menu where users can log in or create a new account. Once the user is logged in, they should be able to plan a meal schedule for their family or themselves. Users can choose recipes from the application's database, add their own recipe (manually entering the recipe), or add a recipe via a link. Once the recipes are selected, the application should generate a shopping list based on the ingredients.

After the meal plan is created, the app should provide a financial estimate of how much the user will spend on groceries for the week. It should also be possible to plan for multiple weeks in the future.

When the user wants to create a meal plan for the week, the application will ask for preferences regarding micronutrients, such as low carb options, vegetarian options, etc. The application should provide recommendations based on these preferences and previously selected recipes.

Users should be able to share a meal plan by granting access to other users. To be connected to a shared meal plan, users need to be registered in the application. Users should also have the ability to adjust personal settings continuously, such as the number of people in the household and the budget.

(Settings class to assist with modifying household/user settings.)

Object Analysis (subheadings represent classes)


| Danish    | English     |
|-----------|-------------|
| App’en    | Application |
| Bruger    | User        |
| Mad       | Food        |
| Husstand  | Household   |
| Diæst     | Diet        |
| Hovedmenu | MainMenu    |
| Madplan   | MealPlan    |
| Familien  | Family      |
| Database  | Database    |
| Opskrift  | Recipe      |
| Uger      | Weeks       |
|Anbefalinger|Recommendation|
|indkøbsliste|GroceryList|

