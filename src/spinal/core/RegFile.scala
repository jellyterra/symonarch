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

case class RegFile(config: RegFile.Config) extends Module {
  val io = RegFile.IOBundle(config)
}

object RegFile {
  case class Config()

  case class IOBundle(config: Config) extends Bundle {}

  def main(args: Array[String]): Unit = {
    SimConfig.withWave.compile(RegFile(Config())).doSim { dut =>
      dut.clockDomain.forkStimulus(10)
    }
  }
}
