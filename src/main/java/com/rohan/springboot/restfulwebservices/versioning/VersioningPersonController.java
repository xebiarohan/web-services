package com.rohan.springboot.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "charlie"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonUsingParams() {
        return new PersonV1("Bob charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonUsingParams() {
        return new PersonV2(new Name("Bob", "charlie"));
    }

    @GetMapping(path = "/person", headers = "X_API_VERSION=1")
    public PersonV1 getFirstVersionOfPersonUsingHeaders() {
        return new PersonV1("Bob charlie");
    }

    @GetMapping(path = "/person", headers = "X_API_VERSION=2")
    public PersonV2 getSecondVersionOfPersonUsingHeaders() {
        return new PersonV2(new Name("Bob", "charlie"));
    }

    @GetMapping(path = "/person", produces = "application/app-v1+json")
    public PersonV1 getFirstVersionOfPersonUsingMediaType() {
        return new PersonV1("Bob charlie");
    }

    @GetMapping(path = "/person", produces = "application/app-v2+json")
    public PersonV2 getSecondVersionOfPersonUsingMediaType() { return new PersonV2(new Name("Bob", "charlie")); }

}
