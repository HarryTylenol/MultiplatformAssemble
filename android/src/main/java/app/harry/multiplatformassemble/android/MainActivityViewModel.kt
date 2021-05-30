package app.harry.multiplatformassemble.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.harry.multiplatformassemble.data.MemberRepository
import app.harry.multiplatformassemble.domain.Member
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val memberRepository: MemberRepository
) : ViewModel() {

    private val _androids = MutableStateFlow(emptyList<Member>())
    val android = _androids.asStateFlow()

    init {
        viewModelScope.launch {
            memberRepository.runCatching {
                getAndroidMembers()
            }.onSuccess {
                _androids.value = it.data
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

}