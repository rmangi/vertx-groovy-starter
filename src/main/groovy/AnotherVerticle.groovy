import com.getspun.*

def conf = container.config

vertx.createHttpServer().requestHandler { req ->

def x = new TestMessage()




println x.dump()
  req.response.end "<html><body><h1>${x.message}</h1> <p>From AppProperties: ${conf.modulename}-${conf.version}<p> </body></html>"
}.listen(3435, "localhost")

