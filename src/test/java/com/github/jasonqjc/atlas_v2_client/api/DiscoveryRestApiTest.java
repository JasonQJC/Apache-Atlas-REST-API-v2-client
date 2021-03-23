package com.github.jasonqjc.atlas_v2_client.api;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasSearchResult;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasUserSavedSearch;
import com.github.jasonqjc.atlas_v2_client.model.JsonQuickSearchParameters;
import com.github.jasonqjc.atlas_v2_client.model.JsonSearchParameters;

/**
 * API tests for DiscoveryRestApi
 */
@SpringBootTest
public class DiscoveryRestApiTest {

	@Autowired
    private DiscoveryRestApi api;

    /**
     * 
     *
     * 
     */
    @Test
    public void addSavedSearchTest() {
        JsonAtlasUserSavedSearch body = null;
        // JsonAtlasUserSavedSearch response = api.addSavedSearch(body);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void deleteSavedSearchTest() {
        String guid = null;
        // api.deleteSavedSearch(guid);

        // TODO: test validations
    }

    /**
     * Attribute based search for entities satisfying the search parameters
     */
    @Test
    public void executeSavedSearchByGuidTest() {
        String guid = null;
        // JsonAtlasSearchResult response = api.executeSavedSearchByGuid(guid);

        // TODO: test validations
    }

    /**
     * Attribute based search for entities satisfying the search parameters
     */
    @Test
    public void executeSavedSearchByNameTest() {
        String name = null;
        String user = null;
        // JsonAtlasSearchResult response = api.executeSavedSearchByName(name, user);

        // TODO: test validations
    }

    /**
     * Attribute based search for entities satisfying the search parameters
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void executeSavedSearchByNameTestQueryMap() {
        String name = null;
        DiscoveryRestApi.ExecuteSavedSearchByNameQueryParams queryParams = new DiscoveryRestApi.ExecuteSavedSearchByNameQueryParams()
            .user(null);
        // JsonAtlasSearchResult response = api.executeSavedSearchByName(name, queryParams);

    // TODO: test validations
    }
    
    @Test
    public void getSavedSearchTest() {
        String name = null;
        String user = null;
        // JsonAtlasUserSavedSearch response = api.getSavedSearch(name, user);

        // TODO: test validations
    }

    /**
     * 
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getSavedSearchTestQueryMap() {
        String name = null;
        DiscoveryRestApi.GetSavedSearchQueryParams queryParams = new DiscoveryRestApi.GetSavedSearchQueryParams()
            .user(null);
        // JsonAtlasUserSavedSearch response = api.getSavedSearch(name, queryParams);

    // TODO: test validations
    }
    
    
    @Test
    public void getSavedSearchesTest() {
        String user = null;
        // List<JsonAtlasUserSavedSearch> response = api.getSavedSearches(user);

        // TODO: test validations
    }

    /**
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getSavedSearchesTestQueryMap() {
        DiscoveryRestApi.GetSavedSearchesQueryParams queryParams = new DiscoveryRestApi.GetSavedSearchesQueryParams()
            .user(null);
        // List<JsonAtlasUserSavedSearch> response = api.getSavedSearches(queryParams);

    // TODO: test validations
    }
    
    @Test
    public void getSuggestionsTest() {
        String fieldName = null;
        String prefixString = null;
        // JsonAtlasSuggestionsResult response = api.getSuggestions(fieldName, prefixString);

        // TODO: test validations
    }

    /**
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getSuggestionsTestQueryMap() {
        DiscoveryRestApi.GetSuggestionsQueryParams queryParams = new DiscoveryRestApi.GetSuggestionsQueryParams()
            .fieldName(null)
            .prefixString(null);
        // JsonAtlasSuggestionsResult response = api.getSuggestions(queryParams);

    // TODO: test validations
    }
    /**
     *
     * Attribute based search for entities satisfying the search parameters
     */
    @Test
    public void quickSearchTest() {
        Boolean excludeDeletedEntities = null;
        Integer limit = null;
        Integer offset = null;
        String query = null;
        String typeName = null;
        // JsonAtlasQuickSearchResult response = api.quickSearch(excludeDeletedEntities, limit, offset, query, typeName);

        // TODO: test validations
    }

    /**
     * Attribute based search for entities satisfying the search parameters
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void quickSearchTestQueryMap() {
        DiscoveryRestApi.QuickSearchQueryParams queryParams = new DiscoveryRestApi.QuickSearchQueryParams()
            .excludeDeletedEntities(null)
            .limit(null)
            .offset(null)
            .query(null)
            .typeName(null);
        // JsonAtlasQuickSearchResult response = api.quickSearch(queryParams);

    // TODO: test validations
    }
    /**
     * Attribute based search for entities satisfying the search parameters
     */
    @Test
    public void quickSearch2Test() {
        JsonQuickSearchParameters body = null;
        // JsonAtlasQuickSearchResult response = api.quickSearch2(body);

        // TODO: test validations
    }

    /**
     * Relationship search to search for related entities satisfying the search parameters
     */
    @Test
    public void searchRelatedEntitiesTest() {
        List<String> attributes = null;
        Boolean excludeDeletedEntities = null;
        String guid = null;
        Integer limit = null;
        Integer offset = null;
        String relation = null;
        String sortBy = null;
        String sortOrder = null;
        // JsonAtlasSearchResult response = api.searchRelatedEntities(attributes, excludeDeletedEntities, guid, limit, offset, relation, sortBy, sortOrder);

        // TODO: test validations
    }

    /**
     * Relationship search to search for related entities satisfying the search parameters
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void searchRelatedEntitiesTestQueryMap() {
        DiscoveryRestApi.SearchRelatedEntitiesQueryParams queryParams = new DiscoveryRestApi.SearchRelatedEntitiesQueryParams()
            .attributes(null)
            .excludeDeletedEntities(null)
            .guid(null)
            .limit(null)
            .offset(null)
            .relation(null)
            .sortBy(null)
            .sortOrder(null);
        // JsonAtlasSearchResult response = api.searchRelatedEntities(queryParams);

    // TODO: test validations
    }
    /**
     * Retrieve data for the specified attribute search query
     */
    @Test
    public void searchUsingAttributeTest() {
        String attrName = null;
        String attrValuePrefix = null;
        Integer limit = null;
        Integer offset = null;
        String typeName = null;
        // JsonAtlasSearchResult response = api.searchUsingAttribute(attrName, attrValuePrefix, limit, offset, typeName);

        // TODO: test validations
    }

    /**
     * Retrieve data for the specified attribute search query
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void searchUsingAttributeTestQueryMap() {
        DiscoveryRestApi.SearchUsingAttributeQueryParams queryParams = new DiscoveryRestApi.SearchUsingAttributeQueryParams()
            .attrName(null)
            .attrValuePrefix(null)
            .limit(null)
            .offset(null)
            .typeName(null);
        // JsonAtlasSearchResult response = api.searchUsingAttribute(queryParams);

    // TODO: test validations
    }
    /**
     * Retrieve data for the specified fulltext query
     */
    @Test
    public void searchUsingBasicTest() {
        String classification = null;
        Boolean excludeDeletedEntities = true;
        Integer limit = 25;
        Integer offset = 0;
        String query = null;
        String sortBy = null;
        String sortOrder = null;
        String typeName = "Table";
        JsonAtlasSearchResult response = api.searchUsingBasic(classification, excludeDeletedEntities, limit, offset, query, sortBy, sortOrder, typeName);
        
        System.out.println(response);
    }

    /**
     * Retrieve data for the specified fulltext query
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void searchUsingBasicTestQueryMap() {
        DiscoveryRestApi.SearchUsingBasicQueryParams queryParams = new DiscoveryRestApi.SearchUsingBasicQueryParams()
            .classification(null)
            .excludeDeletedEntities(true)
            .limit(25)
            .offset(0)
            .query(null)
            .sortBy(null)
            .sortOrder(null)
            .typeName("Table");
         JsonAtlasSearchResult response = api.searchUsingBasic(queryParams);
         System.out.println(response);
    }
    /**
     * Retrieve data for the specified DSL
     */
    @Test
    public void searchUsingDSLTest() {
        String classification = null;
        Integer limit = null;
        Integer offset = null;
        String query = null;
        String typeName = null;
        // JsonAtlasSearchResult response = api.searchUsingDSL(classification, limit, offset, query, typeName);

        // TODO: test validations
    }

    /**
     * Retrieve data for the specified DSL
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void searchUsingDSLTestQueryMap() {
        DiscoveryRestApi.SearchUsingDSLQueryParams queryParams = new DiscoveryRestApi.SearchUsingDSLQueryParams()
            .classification(null)
            .limit(null)
            .offset(null)
            .query(null)
            .typeName(null);
        // JsonAtlasSearchResult response = api.searchUsingDSL(queryParams);

    // TODO: test validations
    }
    /**
     * Retrieve data for the specified fulltext query
     */
    @Test
    public void searchUsingFullTextTest() {
        Boolean excludeDeletedEntities = null;
        Integer limit = null;
        Integer offset = null;
        String query = null;
        // JsonAtlasSearchResult response = api.searchUsingFullText(excludeDeletedEntities, limit, offset, query);

        // TODO: test validations
    }

    /**
     * Retrieve data for the specified fulltext query
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void searchUsingFullTextTestQueryMap() {
        DiscoveryRestApi.SearchUsingFullTextQueryParams queryParams = new DiscoveryRestApi.SearchUsingFullTextQueryParams()
            .excludeDeletedEntities(null)
            .limit(null)
            .offset(null)
            .query(null);
        // JsonAtlasSearchResult response = api.searchUsingFullText(queryParams);

    // TODO: test validations
    }
    
    /**
     * Attribute based search for entities satisfying the search parameters
     */
    @Test
    public void searchWithParametersTest() {
        JsonSearchParameters body = null;
        // JsonAtlasSearchResult response = api.searchWithParameters(body);

        // TODO: test validations
    }

    @Test
    public void updateSavedSearchTest() {
        JsonAtlasUserSavedSearch body = null;
        // JsonAtlasUserSavedSearch response = api.updateSavedSearch(body);

        // TODO: test validations
    }

}
