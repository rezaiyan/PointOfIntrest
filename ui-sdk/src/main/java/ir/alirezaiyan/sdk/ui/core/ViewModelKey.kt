package ir.alirezaiyan.sdk.ui.core

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 2:41 PM.
 */
@MapKey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class ViewModelKey(val value: KClass<out ViewModel>)