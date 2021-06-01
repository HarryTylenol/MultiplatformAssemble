import app.harry.multiplatformassemble.data.MemberRepository
import app.harry.multiplatformassemble.data.MemberRepositoryImp
import app.harry.multiplatformassemble.di.initKoin
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.core.component.KoinComponent
import react.child
import react.createContext
import react.dom.render

object AppDependencies : KoinComponent {
    val repository: MemberRepository

    init {
        initKoin()
        repository = MemberRepositoryImp()
    }
}

val AppDependenciesContext = createContext<AppDependencies>()

@InternalCoroutinesApi
fun main() {
    render(kotlinx.browser.document.getElementById("root")) {
        AppDependenciesContext.Provider(AppDependencies) {
            child(App)
        }
    }
}