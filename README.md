# Youxel_Task

## Project Structure

The project follows the following structure:

- The `test` directory contains two packages: `pages` and `tests`.
    - The `pages` package includes the page classes: `HomePage`, `LoginPage`, `RegistrationPage`, and `SearchResultsPage`.
      Each page class encapsulates the locators and methods related to a specific page of the website.
    - The `tests` package contains the test case classes.
      Each test case class, such as `LoginTest`, `RegistrationTest`, `SearchProductTest`, `CurrencySwitchTest`,
      and `CategorySelectionTest`, represents a specific test scenario and contains the main method where the test logic is implemented.

By organizing the project into separate packages for pages and tests, we maintain a modular structure, allowing easy maintenance and readability of the code.



## Todo

- Improve the test case setup by initiating and opening the browser before each test case to ensure a clean and consistent test environment.
- Replace hardcoded data with dynamic data or test data from external sources to make the tests more flexible and reusable.
- Complete the implementation of the remaining test cases to cover all desired scenarios and functionalities of the website.