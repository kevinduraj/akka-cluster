

Start backend first with:

sbt "runMain sample.cluster.simple.BackendApp 127.0.0.1 2551"


then start the front end with:

sbt "runMain sample.cluster.simple.FrontendApp localhost 9000"

