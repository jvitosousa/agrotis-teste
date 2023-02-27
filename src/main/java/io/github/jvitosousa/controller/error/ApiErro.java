package io.github.jvitosousa.controller.error;

import java.util.Arrays;
import java.util.List;

public class ApiErro {
  private List<String> messages;
  
  
  public ApiErro(String error) {
	  this.messages = Arrays.asList(error);
  }
}
