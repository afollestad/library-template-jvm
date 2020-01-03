/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.afollestad.librarytemplatesample

import com.afollestad.librarytemplate.StuffDoer
import java.util.Scanner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
fun main() {
  println("Press enter to exit...")

  val stuffDoer = StuffDoer(Dispatchers.Default, Dispatchers.IO)
  GlobalScope.launch {
    stuffDoer.doStuff()
        .collect {
          print("$it ")
        }
  }

  waitForEnter()
  stuffDoer.shutdown()
}

private fun waitForEnter() = Scanner(System.`in`).nextLine()
