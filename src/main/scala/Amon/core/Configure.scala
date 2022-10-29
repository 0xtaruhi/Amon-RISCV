package Amon.core

import scala.math
import spinal.core.log2Up

trait BasicConfig {
  val wordBits   = 32
  val byteBits   = 8
  val halfBits   = 16
  val doubleBits = 64

  val wordAdSize   = log2Up(wordBits)
  val byteAdSize   = log2Up(byteBits)
  val halfAdSize   = log2Up(halfBits)
  val doubleAdSize = log2Up(doubleBits)

  val machBits = 64
}

trait GeneralRegConfig {
  val phyRegNum    = 64
  val phyRegAdSize = log2Up(phyRegNum)
}
