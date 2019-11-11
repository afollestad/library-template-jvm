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
package com.afollestad.librarytemplate

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
@FlowPreview
class StuffDoer(
  private var mainContext: CoroutineContext = Dispatchers.Default,
  private var executionContext: CoroutineContext = Dispatchers.Unconfined
) {
  private val job by lazy { Job(executionContext[Job]) }
  private val scope by lazy { CoroutineScope(executionContext + job) }

  fun doStuff(): Flow<Int> {
    return flow {
      scope.launch(executionContext) {
        for (num in 1 until 500) {
          if (!isActive) break
          withContext(mainContext) {
            emit(num)
          }
          delay(100)
        }
      }
    }
  }

  fun shutdown() {
    job.cancel()
  }
}
