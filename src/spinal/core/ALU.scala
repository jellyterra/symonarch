// Copyright (C) 2024 Symonarch Project
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https:www.gnu.org/licenses/>.

package core

import spinal.core._
import spinal.core.sim._

import scala.language.postfixOps

case class ALU(config: ALU.Config) extends Module {
  val io = ALU.IOBundle(config)
}

object ALU {
  case class Config(width: Int)

  object Mode extends SpinalEnum {
    val Add, Sub, Mul, Div = newElement()
  }

  case class IOBundle(config: Config) extends Bundle {
    val Mode               = in  UInt (2                 bit)
    val OperandA, OperandB = in  UInt (config.width      bit)
    val Result             = out UInt (config.width << 1 bit)
  }

  def main(args: Array[String]): Unit = {
    SimConfig.withWave.compile(ALU(Config(32))).doSim { dut =>
      dut.clockDomain.forkStimulus(10)
    }
  }
}
