package ir.alirezaiyan.detail

import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 4/30/2020 12:32 PM.
 */
class DetailViewModel @Inject constructor(private val useCase: DetailUseCase) : ViewModel()