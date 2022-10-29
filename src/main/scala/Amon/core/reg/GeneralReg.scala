package Amon.core.reg

import spinal.core._
import spinal.lib.slave
import Amon.core.AmonModule
import Amon.core.GeneralRegConfig
import Amon.core.interface.{WriteRegInterface => WRI, ReadRegInterface => RRI}

case class RegGroup(
    val wrPortNum: Int,
    val rdPortNum: Int,
    val regNum: Int
) extends AmonModule {
  val io = new Bundle {
    val wports = Vec(slave(WRI(regNum)), wrPortNum)
    val rports = Vec(slave(RRI(regNum)), rdPortNum)
  }
  val regAdSize = log2Up(regNum)

  val regs = Vec(RegInit(U(0, machBits bits)), regNum)

  // write ports
  io.wports.foreach { wport =>
    when(wport.wen) {
      regs(wport.waddr) := wport.wdata
    }
  }

  // read ports
  io.rports.foreach { rport =>
    rport.rdata := RegNextWhen(regs(rport.raddr), rport.ren).init(0)
  }
}

object GeneralReg extends GeneralRegConfig {
  def apply(wrPortNum: Int, rdPortNum: Int): RegGroup = {
    RegGroup(wrPortNum, rdPortNum, phyRegNum)
  }
}
