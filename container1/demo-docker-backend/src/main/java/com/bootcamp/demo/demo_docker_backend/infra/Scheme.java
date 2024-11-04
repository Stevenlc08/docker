package com.bootcamp.demo.demo_docker_backend.infra;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTPS("https"), //
  HTTP("http"), //
  ;

  private String value;

  private Scheme(String value) {
    this.value = value;
  }

  public String lowercase() {
    return this.value.toLowerCase();
  }

}
