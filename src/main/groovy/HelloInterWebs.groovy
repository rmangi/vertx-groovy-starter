
vertx.createHttpServer().requestHandler { req ->
  req.response.end "<html><body><h1>Hello Interwebs!</h1><p>${container.config.app_message}</p></body></html>"
}.listen(3434, "localhost")

