package io.sc3.plethora.gameplay.modules.keyboard

import io.sc3.plethora.api.method.FutureMethodResult
import io.sc3.plethora.api.method.IUnbakedContext
import io.sc3.plethora.api.module.IModuleContainer
import io.sc3.plethora.api.module.SubtargetedModuleMethod
import io.sc3.plethora.gameplay.registry.PlethoraModules.KEYBOARD_M
import io.sc3.plethora.integration.EntityIdentifier

object KeyboardMethods {
   val EXAMPLE = SubtargetedModuleMethod.of(
      "example", KEYBOARD_M, EntityIdentifier::class.java,
      "function():string -- Example method. Kept for workaround purposes."
    ) { unbaked, _ -> example(unbaked) }
    private fun example(unbaked: IUnbakedContext<IModuleContainer>): FutureMethodResult {
      return FutureMethodResult.result("Example method result.")
    }
  }
