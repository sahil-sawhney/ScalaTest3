package com.knoldus

/**
  * Created by sahil on 2/15/16.
  */
object ExpressionEvaluation {

  def evaluateExpression(list: List[Char]):Int={

    def compute(input:List[Char], first:String, operator:Char, second:String):Int={

      if(list.isEmpty)
        return 0
      input match{
        case head::tail if(head=='+' && operator==' ') => compute(tail,first,'+',second)
        case head::tail if(head=='-' && operator==' ') => compute(tail,first,'-',second)
        case head::tail if(head=='*' && operator==' ') => compute(tail,first,'*',second)
        case head::tail if(head=='/' && operator==' ') => compute(tail,first,'/',second)
        case head::tail if(head=='+' && operator!=' ') => compute(tail,(findResult(first.toInt,operator,second.toInt)).toString,'+',"")
        case head::tail if(head=='-' && operator!=' ') => compute(tail,(findResult(first.toInt,operator,second.toInt)).toString,'-',"")
        case head::tail if(head=='*' && operator!=' ') => compute(tail,(findResult(first.toInt,operator,second.toInt)).toString,'*',"")
        case head::tail if(head=='/' && operator!=' ') => compute(tail,(findResult(first.toInt,operator,second.toInt)).toString,'/',"")
        case head::tail if(head.toInt.isInstanceOf[Int] && operator==' ') => compute(tail,first+(head.toString),operator,second)
        case head::tail if(head.toInt.isInstanceOf[Int] && operator!=' ') => compute(tail,first,operator,second+(head.toString))
        case _ => findResult(first.toInt,operator,second.toInt)

      }
    }

    compute(list,"",' ',"")
  }

   def findResult(x:Int,op:Char,y:Int):Int={ op match{
      case '+' => x+y
      case '-' => x-y
      case '*' => x*y
      case '/' => x/y
    }
  }

}
