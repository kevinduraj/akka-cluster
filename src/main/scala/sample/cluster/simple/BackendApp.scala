package sample.cluster.simple

import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory


object BackendApp extends App {

  val conf =
    """akka.remote.netty.tcp.hostname="%hostname%"
      |akka.remote.netty.tcp.port=%port%
      |akka.cluster.roles = [backend]
      |""".stripMargin



  val argumentsError = """
   Please run the service with the required arguments:  <hostIpAddress> <port> """

  assert(args.length == 2, argumentsError)

  // Override the configuration of the port when specified as program argument

  val hostname = args(0)
  val port = args(1).toInt

  val config =  ConfigFactory.parseString( conf.replaceAll("%hostname%",hostname)
    .replaceAll("%port%",port.toString)).withFallback(ConfigFactory.load())

  val system = ActorSystem("ClusterSystem", config)
  system.actorOf(Backend.props, name = "backend")
}
