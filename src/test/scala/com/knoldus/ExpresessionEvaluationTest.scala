package com.knoldus

import org.scalatest.FunSuite

/**
  * Created by sahil on 2/15/16.
  */
class ExpresessionEvaluationTest extends FunSuite {

  test("the output is valid") {

    val result = ExpressionEvaluation.evaluateExpression(List('1','2','+','2','0','*','3'))
    val expected = 96
    assert(result===expected)
  }

  test("list of expression is empty") {

    val result = ExpressionEvaluation.evaluateExpression(List())
    val expected = 0
    assert(result===expected)
  }
}
