/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spun


def app = '@modulename@'

def version = '@version@'

def module = "${app}-${version}"



println "Deploying module"

// Our application config - you can maintain it here or alternatively you could
// stick it in a conf.json text file and specify that on the command line when
// starting this verticle

// Configuration for the web server

println container.config.dump()
def spunAppConf = [ 'testparam':'foovalue' ]
spunAppConf.putAll(container.config)


container.deployModule(module.toString(), spunAppConf,1) { deploymentID ->
  println "This gets called when deployment is complete, deployment id is $deploymentID"
}

  // Deploy an auth manager to handle the authentication

 // deployModule('vertx.auth-mgr-v1.0')

  // Start the web server, with the config we defined above

 // deployModule('vertx.web-server-v1.0', webServerConf)

//}