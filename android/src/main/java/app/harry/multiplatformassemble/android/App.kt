package app.harry.multiplatformassemble.android

import android.app.Application
import app.harry.multiplatformassemble.di.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            modules(
                module {
                    viewModel { MainActivityViewModel(get()) }
                }
            )
        }
    }
}