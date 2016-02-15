package com.knoldus

import org.scalatest.FunSuite

/**
  * Created by sahil on 2/15/16.
  */
class MyOrderingTraitTest extends FunSuite{

  test("list is sorted correctly"){

    val e1 = new Employee(1, "sahil", 100)
    val e2 = new Employee(2, "varun", 500)
    val e3 = new Employee(3, "akshay", 200)
    val e4 = new Employee(4, "parth", 300)
    val e5 = new Employee(5, "savi", 700)
    val unSortedList: List[Employee] = List(e1, e2, e3, e4, e5)
    val result=MyOrderingTrait.employeeSorting(unSortedList)
    val expected=List(e1,e3,e4,e2,e5)
    assert(result===expected)
  }

  test("list is empty"){

    val unSortedList: List[Employee] = List()
    val result=MyOrderingTrait.employeeSorting(unSortedList)
    val expected=List()
    assert(result===expected)
  }
}
