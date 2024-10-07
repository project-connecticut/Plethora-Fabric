package io.sc3.plethora.gameplay.registry

import io.sc3.plethora.Plethora.MOD_ID
import io.sc3.plethora.api.meta.IMetaProvider
import io.sc3.plethora.api.meta.IMetaRegistry
import io.sc3.plethora.gameplay.modules.BindableModuleItemMeta
import io.sc3.plethora.integration.DetailsMetaWrapper.MetaProvider

object PlethoraMetaRegistration {
  @JvmStatic
  fun registerMetaProviders(registry: IMetaRegistry) {
    with (registry) {
      provider("metaProvider", MetaProvider)
      provider("bindableModuleItem", BindableModuleItemMeta)
    }
  }

  private inline fun <reified T> IMetaRegistry.provider(name: String, provider: IMetaProvider<T>) {
    registerMetaProvider("$MOD_ID:$name", MOD_ID, T::class.java, provider)
  }
}
