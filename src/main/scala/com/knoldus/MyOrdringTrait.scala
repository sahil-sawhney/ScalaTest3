package com.knoldus

import scala.math.Ordering
/**
  * Created by sahil on 2/15/16.
  */
 object MyOrderingTrait {

  def employeeSorting(list:List[Employee]):List[Employee]= {

    val sortedList = list.sorted(new Employee(1, "1", 1))
    sortedList
  }
}

 class Employee(val id:Int, val name:String, val salary:Int)  extends Ordering[Employee] {

   override def compare(x: Employee, y: Employee): Int = {

     val temp: Int = x.salary.compare(y.salary)
     temp
   }
 }