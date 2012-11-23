import org.vertx.groovy.core.*

def logger = container.logger

logger.info "ModuleLauncherConfig: " + container.config.dump()

logger.info "Deploying spun"

def moduleConfig = ['app_message':'A message from AppConfig']

moduleConfig.putAll(container.config)

container.deployVerticle('HelloInterWebs.groovy', moduleConfig)
container.deployVerticle('AnotherVerticle.groovy', moduleConfig)

