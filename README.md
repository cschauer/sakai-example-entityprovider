# sakai-example-entityprovider
An example of creating an EntityProvider that provides a RESTful api to some resource in Sakai. This assumes you have an environment set up for sakai development.

```
cd into your sakai source directory
git clone https://github.com/cschauer/sakai-example-entityprovider sakai-example-entityprovider
cd sakai-example-entityprovider
mvn clean install sakai:deploy -Dmaven.tomcat.home=/path/to/your/tomcat
```

Restart tomcat and you should see example-entityprovider listed at /direct/describe.
