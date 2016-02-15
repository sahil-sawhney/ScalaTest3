package com.knoldus

import org.scalatest.FunSuite
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by sahil on 2/15/16.
  */
class FastestFutureTest extends FunSuite {

  test("the output is valid") {
    val f1:Future[Int]=Future{Thread.sleep(1000);1}
    val f2:Future[Int]=Future{Thread.sleep(2000);2}
    val f3:Future[Int]=Future{Thread.sleep(3000);2}

    val result = Await.result(FastestFuture.returnFuture(List(f1,f2,f3)),10 seconds)
    val expected = 1
    assert(result===expected)
  }

  test("the list is empty") {

    val result = Await.result(FastestFuture.returnFuture(List()),10 seconds)
    val expected = 0
    assert(result===expected)
  }


}
