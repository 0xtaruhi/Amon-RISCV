package Amon.core.interface

import spinal.core._
import Amon.core._

case class WriteRegInterface(
    val regNum: Int
) extends AmonInterface
    with GeneralRegConfig {
  val adSize = log2Up(regNum)

  val waddr = UInt(adSize bits)
  val wen   = Bool()
  val wdata = UInt(machBits bits)


  override def asMaster(): Unit = {
    out(waddr, wen, wdata)
  }
}

case class ReadRegInterface(
    val regNum: Int
) extends AmonInterface
    with GeneralRegConfig {
  val adSize = log2Up(regNum)

  val raddr = UInt(adSize bits)
  val ren   = Bool()
  val rdata = UInt(machBits bits)

  override def asMaster(): Unit = {
    out(ren, raddr)
    in(rdata)
  }
}
