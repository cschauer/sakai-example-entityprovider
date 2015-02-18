package edu.txstate.etc.example.api;

import org.sakaiproject.entitybroker.entityprovider.capabilities.RESTful;

public interface ExampleEntityProvider extends RESTful {
  public final static String ENTITY_PREFIX = "example-entityprovider";
}
