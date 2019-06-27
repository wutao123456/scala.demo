package actor

/**
  * @author wutao 
  * @date 2019/6/27
  */
object Example_01 extends App {

  import akka.actor.Actor
  import akka.event.Logging
  import akka.actor.ActorSystem
  import akka.actor.Props

  class MyActor extends Actor{

    val log = Logging(context.system,this)

    def receive= {
      case "test" => log.info("received test")
      case _ => log.info("received unknown message ")
    }
  }


  //创建ActorSystem对象
  val system = ActorSystem("myActorSystem")

  //返回ActorSystem的LoggingAdpater
  val systemLog = system.log

  //创建MyActor,指定actor名称为myactor
  val myActor = system.actorOf(Props[MyActor],name = "myactor")

  systemLog.info("准备向myactor发送消息")

  //向myactor发送消息
  myActor!"test"
  myActor!123


}
