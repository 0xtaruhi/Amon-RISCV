package Amon.core

import spinal.core._
import spinal.lib._
import scala.reflect.runtime.universe

abstract class AmonModule extends Component with BasicConfig {}
abstract class AmonInterface extends Bundle with IMasterSlave with BasicConfig {}

object Amon {
  def main(args: Array[String]): Unit = {

    SpinalConfig(targetDirectory = "rtl").generateVerilog(Top())
  }
}
