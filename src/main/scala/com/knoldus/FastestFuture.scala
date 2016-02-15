package com.knoldus

import scala.concurrent.{Promise, Future}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by sahil on 2/15/16.
  */
object FastestFuture {

  def returnFuture(list:List[Future[Int]]):Future[Int]={

    if(list.isEmpty)
      return Future(0)
    val p=Promise[Int]
    list.foreach(_.onComplete(v=> p.complete(v)))
    p.future
  }
}
