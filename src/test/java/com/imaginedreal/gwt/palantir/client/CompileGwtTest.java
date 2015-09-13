package com.imaginedreal.gwt.palantir.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileGwtTest extends GWTTestCase {
  
  @Override
  public String getModuleName() {
    return "com.imaginedreal.gwt.palantir.Basic";
  }

  public void testSandbox() {
    assertTrue(true);
  }
  
}
