## Introduction

This is a basic framework for deploying groovy vert-x verticles using gradle. I started playing with vert-x yesterday and there didn't seem to be a good reference for just starting an application comprising a simple set of related verticles from gradle and running it from the command-line.

Vert-x is very new and it seems like the module system is quickly becoming adopted as a way to manage an application within vert-x (at least from groovy's perspective). A boostrap 'main' verticle can programatically deploy child verticles. One motivating factor for the module-as-launcher framework seems unfortunately be classpath management with dependency jars.  (caveat: see above, I have only been playing with vert-x for a couple of days).

I hope that this little starter kit might inspire some folks to help put together a more robust starting point for vert-x development in groovy.



## Goals
1. Be able to manage dependencies for a vert-x app in a reasonable way
2. Be able to run *gradle runVert* and see my work
3. Get some basic application level configuration working
4. Get to a solid starting point for delving into vert-x as an app developer


## How it works

In effect we have two bootstraps which for convention we can call Application and Module.
There is only 1 Application bootstrap, but in theory we could have multiple Module bootstraps for completely separate services with their own set of dependencies.

Application structure:
```
    /src/main/boot/AppLauncher.groovy  Application Bootstrap Verticle
    /src/main/conf/AppProperties.json  Application conf - becomes container.config
    /src/main/groovy/     Module Bootstrap
                    App.groovy	
		    mod.js
		    <Assorted Verticles>
	            <other supporting classes>
```
 
 Deploying this using
 `gradle runVert`
 
 Builds your application's deployment layout to build/stage/. The module is named based on the modulename and version in gradle.properties
 
## TODO
Integrate the mod.js configs in the container layer config
Figure out how to update code in-place. Maybe with embedded vert-x
Make more robust :)

 


