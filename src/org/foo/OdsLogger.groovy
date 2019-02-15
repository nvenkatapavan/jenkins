package org.foo;

class OdsLogger implements Logger {

  private Object script
  private boolean debug

  OdsLogger(script, debug) {
    this.debug = debug
    this.script = script
  }

  void debug(String message) {
    if (debug) {
      script.echo message
    }
  }

  void info(String message) {
    script.echo message
  }

  void error(String message) {
    script.error message
  }

}