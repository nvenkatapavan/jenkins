#!/usr/bin/env groovy

import org.foo.Deployer
import org.foo.OdsLogger

def call(Map config, Closure body) {
  config.debug = config.debug ?: false
  def logger = new OdsLogger(this, config.debug)
  def bp = new Deployer(this, config, logger)
  bp.getsecrets(body)
  return this
}

return this