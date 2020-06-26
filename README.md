# Quarkus insights demo

## Creation

Using code.quarkus.io:

- RESTEasy JAX-RS
- RESTEasy JSON-B
- SmallRye OpenAPI
- SmallRye GraphQL
- Also later OpenTracing, Metrics, Security

## Context

- Show Person size [javadoc](file:///home/pkruger/Projects/quarkus.io/customer-service/target/apidocs/graphql/demo/model/package-summary.html)
- Draw use case [excalidraw](https://excalidraw.com/)

## Queries
- Basic REST Endpoint (person)
- Convert to GraphQL (Show schema)
- Add another service (score)
- Convert to GraphQL (boundary)
- Break score (partial results)
- More that one person
- List of people

## Mutation

Create: 
```
mutation CreatePerson{
  mutatePerson(person : 
    {
      names: "Phillip"
    }
  ){
    id
    names
    surname
    profilePictures
    website
  }
}
```

Update:

```
mutation UpdatePerson{
  mutatePerson(person : 
    {
      id: 11, 
      names:"Phillip",
      surname: "Kruger", 
      profilePictures: [
        "https://pbs.twimg.com/profile_images/1170690050524405762/I8KJ_hF4_400x400.jpg"
      ],
      website: "http://www.phillip-kruger.com"
    }){
    id
    names
    surname
    profilePictures
    website
  }
}
```

## Metrics

```
@Timed(name = "restTimer", description = "How long does it take to get a Customer.", unit = MetricUnits.SECONDS)
@Timed(name = "graphQLTimer", description = "How long does it take to get a Customer.", unit = MetricUnits.SECONDS)
```

[View here](moz-extension://1a06ab1b-bfdc-43de-9872-c41eb25e3afb/dist/index.html)

## Security

```
@RolesAllowed("admin")
```

## Tracing

docker run -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 jaegertracing/all-in-one:latest
http://localhost:16686/search

## Client

(Start server with java -jar)

```
//@Inject
CustomerGraphQLClient graphQLClient = GraphQlClientBuilder.newBuilder().build(CustomerGraphQLClient.class);
```

# Introspection
