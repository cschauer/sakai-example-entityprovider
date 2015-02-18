package edu.txstate.etc.example;

import edu.txstate.etc.example.api.ExampleEntity;
import edu.txstate.etc.example.api.ExampleEntityProvider;

import org.sakaiproject.entitybroker.EntityReference;
import org.sakaiproject.entitybroker.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.capabilities.AutoRegisterEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.extension.Formats;
import org.sakaiproject.entitybroker.entityprovider.search.Search;

import java.util.List;
import java.util.Map;

public class ExampleEntityProviderImpl implements ExampleEntityProvider, CoreEntityProvider, AutoRegisterEntityProvider {

  public String getEntityPrefix() {
    return ENTITY_PREFIX;
  }

  /**
   * Supported formats input/output formats for this
   * entity provider.
   */
  public String[] getHandledOutputFormats() {
    return new String[] { Formats.JSON };
  }

  public String[] getHandledInputFormats() {
    return new String[] { Formats.JSON };
  }

  public boolean entityExists(String id) {
    return true;
  }

  /**
   * This method is used by the entity broker system to get an empty class for your entity.
   * This is the class that will be used for the entity parameter in the other methods.
   * JSON objects are mapped to java classes using the reflectutils package:
   * https://code.google.com/p/reflectutils/
   */
  public Object getSampleEntity() {
    return new ExampleEntity();
  }

  public List getEntities(EntityReference ref, Search search) {
    return null;
  }

  /**
   * A POST request to /direct/ENTITY_PREFIX.json will be routed here.
   */
  public String createEntity(EntityReference ref, Object entity, Map<String,Object> params) {
    ExampleEntity e = (ExampleEntity)entity;
    // Insert entity into db or call some service
    return e.getId();
  }

  /**
   * A PUT request to /direct/ENTITY_PREFIX.json will be routed here.
   */
  public void updateEntity(EntityReference ref, Object entity, Map<String, Object> params) {
    ExampleEntity e = (ExampleEntity)entity;
    // Update entity in db or call some service
  }

  /**
   * A GET request to /direct/ENTITY_PREFIX/id.json will be routed here.
   */
  public Object getEntity(EntityReference ref) {
    String id = getIdFromReference(ref);
    ExampleEntity e = new ExampleEntity(id, "someinterestingstring", 23);
    return e;
  }

  /**
   * A DELETE request to /direct/ENTITY_PREFIX/id.json will be routed here.
   */
  public void deleteEntity(EntityReference ref, Map<String, Object> params) {
    String id = getIdFromReference(ref);
    // Delete entity with id
  }

  private String getIdFromReference(EntityReference ref) {
    if (ref == null || ref.getId() == null) throw new IllegalArgumentException("Id cannot be null.");
    return ref.getId();
  }
}
