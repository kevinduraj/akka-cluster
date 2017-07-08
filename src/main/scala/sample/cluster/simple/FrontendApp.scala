package sample.cluster.simple

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import sample.cluster.simple.BackendApp._

object FrontendApp extends App{

  val conf =
    """akka.remote.netty.tcp.hostname="%hostname%"
      |akka.remote.netty.tcp.port=%port%
      |akka.cluster.roles = [frontend]
      |""".stripMargin



  val argumentsError = """
   Please run the service with the required arguments:  <hostIpAddress> <port> """

  assert(args.length == 2, argumentsError)

  // Override the configuration of the port when specified as program argument

  val hostname = args(0)
  val port = args(1).toInt

  val config =  ConfigFactory.parseString( conf.replaceAll("%hostname%",hostname)
    .replaceAll("%port%",port.toString)).withFallback(ConfigFactory.load())

  //  implicit val cassandraConfig = config.getConfig("akka-cassandra.main.db.cassandra")
  //  val storageAdapter = new StorageAdapter()

  val system = ActorSystem("ClusterSystem", config)
  system.actorOf(FrontEndActor.props, name = "backend")


}
