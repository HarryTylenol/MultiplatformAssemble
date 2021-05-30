package app.harry.multiplatformassemble

import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

fun <T> Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any?): T {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) { parametersOf(parameter) }
}

fun <T> Koin.get(objCClass: ObjCClass) = get<T>(objCClass = objCClass, qualifier = null, parameter = null)
fun <T> Koin.getWithParams(objCClass: ObjCClass, parameter: Any?) = get<T>(objCClass = objCClass, qualifier = null, parameter = parameter)