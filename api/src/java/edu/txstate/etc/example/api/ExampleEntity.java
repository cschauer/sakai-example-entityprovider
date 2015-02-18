package edu.txstate.etc.example.api;

/**
 * Example entity class. Public fields and fields with a getter/setter
 * can be mapped to/from a JSON object. The following JSON corresponds
 * equivalent to an object created with new ExampleEntity("1", "hello", 3).
 *
 * {
 *  "id": "1",
 *  "aString": "hello",
 *  "anInteger": 3
 * }
 */
public class ExampleEntity {
  private String id;
  public String getId() { return id; }
  public void setId(String s) { id = s; }

  private String aString;
  public String getSomeString() { return aString; }
  public void setSomeString(String s) { aString = s; }

  private int anInteger;
  public int getSomeInteger() { return anInteger; }
  public void setSomeInteger(int i) { anInteger = i; }

  public ExampleEntity() {}
  public ExampleEntity(String id, String s, int i) {
    this.id = id;
    aString = s;
    anInteger = i;
  }
}
