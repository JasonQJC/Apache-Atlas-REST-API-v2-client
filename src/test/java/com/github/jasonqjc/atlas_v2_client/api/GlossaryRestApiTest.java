package com.github.jasonqjc.atlas_v2_client.api;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasGlossary;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasGlossaryCategory;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasGlossaryTerm;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelatedObjectId;

/**
 * API tests for GlossaryRestApi
 */
@SpringBootTest
public class GlossaryRestApiTest {

	@Autowired
    private GlossaryRestApi api;

    /**
     * Assign the given term to the provided list of entity headers.
     *
     */
    @Test
    public void assignTermToEntitiesTest() {
        String termGuid = null;
        List<JsonAtlasRelatedObjectId> body = null;
        // api.assignTermToEntities(termGuid, body);

        // TODO: test validations
    }

    /**
     * Create a glossary.
     *
     */
    @Test
    public void createGlossaryTest() {
        JsonAtlasGlossary body = null;
        // JsonAtlasGlossary response = api.createGlossary(body);

        // TODO: test validations
    }

    /**
     * Create glossary category in bulk.
     *
     */
    @Test
    public void createGlossaryCategoriesTest() {
        List<JsonAtlasGlossaryCategory> body = null;
        // List<JsonAtlasGlossaryCategory> response = api.createGlossaryCategories(body);

        // TODO: test validations
    }

    /**
     * Create glossary category.
     *
     */
    @Test
    public void createGlossaryCategoryTest() {
        JsonAtlasGlossaryCategory body = null;
        // JsonAtlasGlossaryCategory response = api.createGlossaryCategory(body);

        // TODO: test validations
    }

    /**
     * Create a glossary term.
     *
     */
    @Test
    public void createGlossaryTermTest() {
        JsonAtlasGlossaryTerm body = null;
        // JsonAtlasGlossaryTerm response = api.createGlossaryTerm(body);

        // TODO: test validations
    }

    /**
     * Create glossary terms in bulk.
     *
     */
    @Test
    public void createGlossaryTermsTest() {
        List<JsonAtlasGlossaryTerm> body = null;
        // List<JsonAtlasGlossaryTerm> response = api.createGlossaryTerms(body);

        // TODO: test validations
    }

    /**
     * Delete a glossary.
     *
     */
    @Test
    public void deleteGlossaryTest() {
        String glossaryGuid = null;
        // api.deleteGlossary(glossaryGuid);

        // TODO: test validations
    }

    /**
     * Delete a glossary category.
     *
     */
    @Test
    public void deleteGlossaryCategoryTest() {
        String categoryGuid = null;
        // api.deleteGlossaryCategory(categoryGuid);

        // TODO: test validations
    }

    /**
     * Delete a glossary term.
     *
     */
    @Test
    public void deleteGlossaryTermTest() {
        String termGuid = null;
        // api.deleteGlossaryTerm(termGuid);

        // TODO: test validations
    }

    /**
     * Remove the term assignment for the given list of entity headers.
     *
     */
    @Test
    public void disassociateTermAssignmentFromEntitiesTest() {
        String termGuid = null;
        List<JsonAtlasRelatedObjectId> body = null;
        // api.disassociateTermAssignmentFromEntities(termGuid, body);

        // TODO: test validations
    }

    /**
     * Get all terms associated with the specific category.
     *
     */
    @Test
    public void getCategoryTermsTest() {
        String categoryGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // List<JsonAtlasRelatedTermHeader> response = api.getCategoryTerms(categoryGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get all terms associated with the specific category.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getCategoryTermsTestQueryMap() {
        String categoryGuid = null;
        GlossaryRestApi.GetCategoryTermsQueryParams queryParams = new GlossaryRestApi.GetCategoryTermsQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // List<JsonAtlasRelatedTermHeader> response = api.getCategoryTerms(categoryGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Get a specific Glossary.
     *
     */
    @Test
    public void getDetailedGlossaryTest() {
        String glossaryGuid = null;
        // JsonAtlasGlossaryExtInfo response = api.getDetailedGlossary(glossaryGuid);

        // TODO: test validations
    }

    /**
     * Get all entity headers assigned with the specified term.
     *
     */
    @Test
    public void getEntitiesAssignedWithTermTest() {
        String termGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // List<JsonAtlasRelatedObjectId> response = api.getEntitiesAssignedWithTerm(termGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get all entity headers assigned with the specified term.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getEntitiesAssignedWithTermTestQueryMap() {
        String termGuid = null;
        GlossaryRestApi.GetEntitiesAssignedWithTermQueryParams queryParams = new GlossaryRestApi.GetEntitiesAssignedWithTermQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // List<JsonAtlasRelatedObjectId> response = api.getEntitiesAssignedWithTerm(termGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Retrieve all glossaries registered with Atlas.
     *
     */
    @Test
    public void getGlossariesTest() {
        String limit = null;
        String offset = null;
        String sort = null;
        // List<JsonAtlasGlossary> response = api.getGlossaries(limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Retrieve all glossaries registered with Atlas.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getGlossariesTestQueryMap() {
        GlossaryRestApi.GetGlossariesQueryParams queryParams = new GlossaryRestApi.GetGlossariesQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // List<JsonAtlasGlossary> response = api.getGlossaries(queryParams);

    // TODO: test validations
    }
    /**
     * Get a specific Glossary.
     *
     */
    @Test
    public void getGlossaryTest() {
        String glossaryGuid = null;
        // JsonAtlasGlossary response = api.getGlossary(glossaryGuid);

        // TODO: test validations
    }

    /**
     * Get the categories belonging to a specific glossary.
     *
     */
    @Test
    public void getGlossaryCategoriesTest() {
        String glossaryGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // List<JsonAtlasGlossaryCategory> response = api.getGlossaryCategories(glossaryGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get the categories belonging to a specific glossary.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getGlossaryCategoriesTestQueryMap() {
        String glossaryGuid = null;
        GlossaryRestApi.GetGlossaryCategoriesQueryParams queryParams = new GlossaryRestApi.GetGlossaryCategoriesQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // List<JsonAtlasGlossaryCategory> response = api.getGlossaryCategories(glossaryGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Get the categories belonging to a specific glossary.
     *
     */
    @Test
    public void getGlossaryCategoriesHeadersTest() {
        String glossaryGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // List<JsonAtlasRelatedCategoryHeader> response = api.getGlossaryCategoriesHeaders(glossaryGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get the categories belonging to a specific glossary.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getGlossaryCategoriesHeadersTestQueryMap() {
        String glossaryGuid = null;
        GlossaryRestApi.GetGlossaryCategoriesHeadersQueryParams queryParams = new GlossaryRestApi.GetGlossaryCategoriesHeadersQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // List<JsonAtlasRelatedCategoryHeader> response = api.getGlossaryCategoriesHeaders(glossaryGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Get specific glossary category.
     *
     */
    @Test
    public void getGlossaryCategoryTest() {
        String categoryGuid = null;
        // JsonAtlasGlossaryCategory response = api.getGlossaryCategory(categoryGuid);

        // TODO: test validations
    }

    /**
     * Get specific glossary term.
     */
    @Test
    public void getGlossaryTermTest() {
        String termGuid = null;
        // JsonAtlasGlossaryTerm response = api.getGlossaryTerm(termGuid);

        // TODO: test validations
    }

    /**
     * Get term headers belonging to a specific glossary.
     *
     */
    @Test
    public void getGlossaryTermHeadersTest() {
        String glossaryGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // List<JsonAtlasRelatedTermHeader> response = api.getGlossaryTermHeaders(glossaryGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get term headers belonging to a specific glossary.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getGlossaryTermHeadersTestQueryMap() {
        String glossaryGuid = null;
        GlossaryRestApi.GetGlossaryTermHeadersQueryParams queryParams = new GlossaryRestApi.GetGlossaryTermHeadersQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // List<JsonAtlasRelatedTermHeader> response = api.getGlossaryTermHeaders(glossaryGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Get terms belonging to a specific glossary.
     *
     */
    @Test
    public void getGlossaryTermsTest() {
        String glossaryGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // List<JsonAtlasGlossaryTerm> response = api.getGlossaryTerms(glossaryGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get terms belonging to a specific glossary.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getGlossaryTermsTestQueryMap() {
        String glossaryGuid = null;
        GlossaryRestApi.GetGlossaryTermsQueryParams queryParams = new GlossaryRestApi.GetGlossaryTermsQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // List<JsonAtlasGlossaryTerm> response = api.getGlossaryTerms(glossaryGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Get all related categories (parent and children).
     *
     */
    @Test
    public void getRelatedCategoriesTest() {
        String categoryGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // Map<String, List<JsonAtlasRelatedCategoryHeader>> response = api.getRelatedCategories(categoryGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get all related categories (parent and children).
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getRelatedCategoriesTestQueryMap() {
        String categoryGuid = null;
        GlossaryRestApi.GetRelatedCategoriesQueryParams queryParams = new GlossaryRestApi.GetRelatedCategoriesQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // Map<String, List<JsonAtlasRelatedCategoryHeader>> response = api.getRelatedCategories(categoryGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Get all related terms for a specific term.
     *
     */
    @Test
    public void getRelatedTermsTest() {
        String termGuid = null;
        String limit = null;
        String offset = null;
        String sort = null;
        // Map<String, List<JsonAtlasRelatedTermHeader>> response = api.getRelatedTerms(termGuid, limit, offset, sort);

        // TODO: test validations
    }

    /**
     * Get all related terms for a specific term.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getRelatedTermsTestQueryMap() {
        String termGuid = null;
        GlossaryRestApi.GetRelatedTermsQueryParams queryParams = new GlossaryRestApi.GetRelatedTermsQueryParams()
            .limit(null)
            .offset(null)
            .sort(null);
        // Map<String, List<JsonAtlasRelatedTermHeader>> response = api.getRelatedTerms(termGuid, queryParams);

    // TODO: test validations
    }
    /**
     * Upload glossary file for creating AtlasGlossaryTerms in bulk.
     *
     */
    @Test
    public void importGlossaryDataTest() {
        File fileDetail = null;
        File inputStream = null;
        // List<JsonAtlasGlossaryTerm> response = api.importGlossaryData(fileDetail, inputStream);

        // TODO: test validations
    }

    /**
     * Partially update the glossary.
     *
     */
    @Test
    public void partialUpdateGlossaryTest() {
        String glossaryGuid = null;
        Map<String, String> body = null;
        // JsonAtlasGlossary response = api.partialUpdateGlossary(glossaryGuid, body);

        // TODO: test validations
    }

    /**
     * Partially update the glossary category.
     *
     */
    @Test
    public void partialUpdateGlossaryCategoryTest() {
        String categoryGuid = null;
        Map<String, String> body = null;
        // JsonAtlasGlossaryCategory response = api.partialUpdateGlossaryCategory(categoryGuid, body);

        // TODO: test validations
    }

    /**
     * Partially update the glossary term.
     *
     */
    @Test
    public void partialUpdateGlossaryTermTest() {
        String termGuid = null;
        Map<String, String> body = null;
        // JsonAtlasGlossaryTerm response = api.partialUpdateGlossaryTerm(termGuid, body);

        // TODO: test validations
    }

    /**
     * Get sample template for uploading/creating bulk AtlasGlossaryTerm.
     *
     */
    @Test
    public void produceTemplate2Test() {
        // api.produceTemplate2();

        // TODO: test validations
    }

    /**
     * Remove the term assignment for the given list of entity headers.
     *
     */
    @Test
    public void removeTermAssignmentFromEntitiesTest() {
        String termGuid = null;
        List<JsonAtlasRelatedObjectId> body = null;
        // api.removeTermAssignmentFromEntities(termGuid, body);

        // TODO: test validations
    }

    /**
     * Update the given glossary.
     *
     */
    @Test
    public void updateGlossaryTest() {
        String glossaryGuid = null;
        JsonAtlasGlossary body = null;
        // JsonAtlasGlossary response = api.updateGlossary(glossaryGuid, body);

        // TODO: test validations
    }

    /**
     * Update the given glossary category.
     */
    @Test
    public void updateGlossaryCategoryTest() {
        String categoryGuid = null;
        JsonAtlasGlossaryCategory body = null;
        // JsonAtlasGlossaryCategory response = api.updateGlossaryCategory(categoryGuid, body);

        // TODO: test validations
    }

    /**
     * Update the given glossary term.
     */
    @Test
    public void updateGlossaryTermTest() {
        String termGuid = null;
        JsonAtlasGlossaryTerm body = null;
        // JsonAtlasGlossaryTerm response = api.updateGlossaryTerm(termGuid, body);

        // TODO: test validations
    }

}
