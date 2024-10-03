package googlesearchtests;

import googlesearchtests.core.GoogleBaseWebTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTermTests extends GoogleBaseWebTest {

    @Test
    public void searchTermFoundInFirstResult_when_enteredInMainSearch(){
        String searchTerm = "Programming";
        searchPage.searchForTerm(searchTerm);
        var results = resultsPage.getSearchResults();

        // Add Assert
        Assertions.assertFalse(results.isEmpty(), "No results were found.");
        Assertions.assertTrue(results.get(0).getText().toLowerCase().contains(searchTerm.toLowerCase()), "Search term was not found within first result.");
    }
}