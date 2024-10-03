
### Google Search Tests
- `GoogleBaseWebTest.java`: Base class for Google search web tests.
- `SearchTermTests.java`: Contains tests for Google search functionality.

### Sauce Demo Tests
This package contains tests for the Sauce Demo application, covering both API and web testing.

#### API Tests
- `SauceDemoApiTests.java`: API tests for the Sauce Demo application.

#### Core
- `SauceDemoBaseApiTest.java`: Base class for Sauce Demo API tests.
- `SauceDemoBaseWebTest.java`: Base class for Sauce Demo web tests.

#### Enums
- `TestData.java`: Contains enumerated test data for Sauce Demo tests.

#### Web Tests
- `LoginTests.java`: Tests for the login functionality of Sauce Demo.
- `ProductsTests.java`: Tests related to product functionality in Sauce Demo.

#### Resources
- `config.properties`: Configuration file for test execution settings.

## Usage

This test structure demonstrates a well-organized approach to testing multiple applications:

1. **Google Search Tests**: Focused on testing Google search functionality.
2. **Sauce Demo Tests**: A comprehensive test suite for the Sauce Demo application, including:
   - API testing
   - Web UI testing
   - Separate base classes for API and Web tests
   - Enumerated test data
   - Configuration properties

Developers can add new test classes to the respective packages and extend the base classes as needed. The structure allows for easy maintenance and scalability of the test suite.