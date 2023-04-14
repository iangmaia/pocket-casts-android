package au.com.shiftyjelly.pocketcasts.wear

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import au.com.shiftyjelly.pocketcasts.account.watchsync.WatchSync
import au.com.shiftyjelly.pocketcasts.account.watchsync.WatchSyncAuthData
import com.google.android.horologist.auth.data.tokenshare.TokenBundleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WearMainActivityViewModel @Inject constructor(
    private val watchSync: WatchSync,
    private val tokenBundleRepository: TokenBundleRepository<WatchSyncAuthData?>,
) : ViewModel() {

    fun startMonitoringAuth() {
        viewModelScope.launch {
            tokenBundleRepository.flow
                .collect {
                    watchSync.processAuthDataChange(it)
                }
        }
    }
}
