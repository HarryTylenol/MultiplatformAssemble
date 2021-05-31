package app.harry.multiplatformassemble.android

import android.app.Application
import app.harry.multiplatformassemble.android.ui.MainActivityViewModel
import app.harry.multiplatformassemble.data.MemberRepository
import app.harry.multiplatformassemble.data.MemberRepositoryImp
import app.harry.multiplatformassemble.di.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            modules(
                module {
                    single<MemberRepository> { MemberRepositoryImp() }
                    viewModel { MainActivityViewModel(get()) }
                }
            )
        }
    }
}