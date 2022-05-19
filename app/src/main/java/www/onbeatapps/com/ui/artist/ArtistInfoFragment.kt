package www.onbeatapps.com.ui.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import www.onbeatapps.com.R
import www.onbeatapps.com.databinding.FragmentArtistInfoBinding
import www.onbeatapps.com.ui.base.BaseFragment
import www.onbeatapps.com.ui.dashBoardActivity.DashBoardActivity
import www.onbeatapps.com.ui.lineUp.LineUpAdapter
import www.onbeatapps.com.ui.lineUp.LineUpViewModel

@AndroidEntryPoint
class ArtistInfoFragment : BaseFragment<LineUpViewModel>() {
    private var _binding: FragmentArtistInfoBinding? = null
    private val binding get() = _binding!!
    private val lineUpViewModel: LineUpViewModel by viewModels()
    private var lineUpAdapter: LineUpAdapter? = null

    override fun setup() {
        DashBoardActivity.naviId =  R.id.navigation_artist_info
        setUpClick()
    }

    private fun setUpClick() {
        binding.apply {
            btBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.window?.statusBarColor = resources.getColor(R.color.white)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        _binding = FragmentArtistInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getViewModel() = lineUpViewModel

}