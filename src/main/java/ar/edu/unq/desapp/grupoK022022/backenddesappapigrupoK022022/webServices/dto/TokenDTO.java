package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices.dto;

import java.io.Serializable;

public class TokenDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String jwtToken;

  public TokenDTO(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  public String getJwtToken() {
    return this.jwtToken;
  }
}