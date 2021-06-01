import app.harry.multiplatformassemble.domain.Member
import kotlinx.coroutines.*
import react.*
import react.dom.*

@InternalCoroutinesApi
val App = functionalComponent<RProps> {
    val appDependencies = useContext(AppDependenciesContext)
    val repository = appDependencies.repository

    val (members, setMembers) = useState(emptyList<Member>())

    useEffectWithCleanup(dependencies = listOf()) {
        val mainScope = MainScope()

        mainScope.launch {
            setMembers(repository.getAndroidMembers().data)
        }
        return@useEffectWithCleanup { mainScope.cancel() }
    }
    h1 {
        +"MultiplatformAssemble"
    }
    ul {
        members.forEach { item ->
            li {
                +"${item.name} (${item.level})"
            }
        }
    }

}